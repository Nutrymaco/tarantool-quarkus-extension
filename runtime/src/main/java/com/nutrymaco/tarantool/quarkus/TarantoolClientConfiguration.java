package com.nutrymaco.tarantool.quarkus;

import io.quarkus.runtime.annotations.ConfigItem;
import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;
import io.quarkus.runtime.annotations.ConvertWith;
import io.smallrye.config.*;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.config.spi.Converter;
import org.tarantool.TarantoolClientConfig;

import java.lang.reflect.Field;
import java.util.Map;


@ConfigRoot(name = "tarantool-client", phase = ConfigPhase.RUN_TIME)
public class TarantoolClientConfiguration {

    /**
     * Tarantool instance address
     * default - localhost:3301
     *
     * @asciidoclet
     */
    @ConfigItem(name = "quarkus.tarantool-client.address", defaultValue = "localhost:3301")
    public String address;

    /**
     * Config map for https://github.com/tarantool/tarantool-java/blob/master/src/main/java/org/tarantool/TarantoolClientConfig.java[TarantoolClientConfig.class]
     *
     * @asciidoclet
     */
    @ConfigItem(name = ConfigItem.PARENT)
    public Map<String, String> tarantoolClientConfig;

}