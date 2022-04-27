package com.nutrymaco.tarantool.quarkus;

import io.quarkus.arc.DefaultBean;
import org.tarantool.TarantoolClient;
import org.tarantool.TarantoolClientConfig;
import org.tarantool.TarantoolClientImpl;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Singleton;

@ApplicationScoped
public class QuarkusTarantoolClientProducer {
    
    @Inject
    TarantoolClientConfiguration propertiesTarantoolConfig;

    @Singleton
    @Produces
    public TarantoolClient tarantoolClient(TarantoolClientConfig tarantoolClientConfig) {
        return new TarantoolClientImpl(
                propertiesTarantoolConfig.address, tarantoolClientConfig);
    }

    @Produces
    @DefaultBean
    public TarantoolClientConfig tarantoolClientConfig() {
        return TarantoolClientConfigFactory.createFromMap(
                propertiesTarantoolConfig.tarantoolClientConfig);
    }

}