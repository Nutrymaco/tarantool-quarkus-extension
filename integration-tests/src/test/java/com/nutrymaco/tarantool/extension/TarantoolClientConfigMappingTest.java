package com.nutrymaco.tarantool.extension;

import com.nutrymaco.tarantool.quarkus.TarantoolClientConfiguration;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.tarantool.TarantoolClientConfig;

import javax.inject.Inject;

@QuarkusTest
public class TarantoolClientConfigMappingTest {
    
    @Inject
    TarantoolClientConfiguration propertiesTarantoolClientConfig;

    @Inject
    TarantoolClientConfig tarantoolClientConfig;

    @Inject

    @Test
    public void testDefaultAddress() {
        Assertions.assertEquals(
            "localhost:3301",
            propertiesTarantoolClientConfig.address
        );
    }

    @Test
    public void testUsername() {
        Assertions.assertEquals(
                "test_user",
                tarantoolClientConfig.username
        );
    }

    @Test
    public void testDirectWriteFactor() {
        Assertions.assertEquals(
                0.8d,
                tarantoolClientConfig.directWriteFactor
        );
    }

}