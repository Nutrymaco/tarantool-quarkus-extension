package com.nutrymaco.tarantool.quarkus.deployment;

import com.nutrymaco.tarantool.quarkus.QuarkusTarantoolClientProducer;
import io.quarkus.arc.deployment.AdditionalBeanBuildItem;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import org.tarantool.TarantoolClient;

class TarantoolQuarkusProcessor {

    private static final String FEATURE = "tarantool-client";
    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    AdditionalBeanBuildItem additionalBeanBuildItem() {
        return AdditionalBeanBuildItem.builder()
                .addBeanClass(QuarkusTarantoolClientProducer.class)
                .addBeanClass(TarantoolClient.class)
                .build();
    }

}
