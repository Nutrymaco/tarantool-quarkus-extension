package com.nutrymaco.tarantool.quarkus;

import io.quarkus.runtime.annotations.ConfigRoot;
import io.smallrye.config.WithDefault;
import io.smallrye.config.WithName;


@ConfigRoot
public class QuarkusTarantoolClientConfig {

    /**
     *
     */
    @WithName("address")
    @WithDefault("localhost:3301")
//    @ConfigProperty(name = "quarkus.tarantool.client.address", defaultValue = "localhost:3301")
    public String address;


}