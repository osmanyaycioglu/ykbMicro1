package com.ykb.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.NoOpPing;

public class MyRibbonConfig {

    @Autowired
    private IClientConfig config;

    @Bean
    public IRule ribbonRule(final IClientConfig config) {
        return new AvailabilityFilteringRule();
    }

    public IPing ribbonPing() {
        return new NoOpPing();
    }

}
