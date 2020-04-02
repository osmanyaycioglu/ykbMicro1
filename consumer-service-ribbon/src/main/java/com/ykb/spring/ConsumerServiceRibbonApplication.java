package com.ykb.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "exposer", configuration = MyRibbonConfig.class)
public class ConsumerServiceRibbonApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ConsumerServiceRibbonApplication.class,
                              args);
    }

}
