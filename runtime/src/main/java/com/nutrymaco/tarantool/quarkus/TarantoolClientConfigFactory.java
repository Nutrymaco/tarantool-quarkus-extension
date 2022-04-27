package com.nutrymaco.tarantool.quarkus;

import org.tarantool.TarantoolClientConfig;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

// todo create generic field converter
// todo add support for de-camel-casing
public class TarantoolClientConfigFactory {

    private static final Map<Class<?>, Function<String, Object>> converters = Map.of(
            String.class, s -> s,
            int.class, Integer::parseInt,
            float.class, Float::parseFloat,
            double.class, Double::parseDouble
    );


    public static TarantoolClientConfig createFromMap(Map<String, String> properties) {
        var config = new TarantoolClientConfig();
        for (var property: properties.entrySet()) {
            var field = getField(property.getKey());
            if (field.isPresent()){
                var value = convertValue(field.get().getType(), property.getValue());
                try {
                    field.get().set(config, value);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return config;
    }

    private static Optional<Field> getField(String fieldName) throws IllegalArgumentException, NullPointerException {
        try {
            return Optional.of(TarantoolClientConfig.class.getDeclaredField(fieldName));
        } catch (NoSuchFieldException e) {
            // todo change this on log with message like Quarkus send when property not mapped anywhere
            e.printStackTrace();
            return Optional.empty();
        }
    }

    private static Object convertValue(Class<?> type, String value) {
        var converter = converters.get(type);
        if (converter != null) {
            return converter.apply(value);
        }
        throw new RuntimeException("cannot find converter for type : " + type);
    }

}
