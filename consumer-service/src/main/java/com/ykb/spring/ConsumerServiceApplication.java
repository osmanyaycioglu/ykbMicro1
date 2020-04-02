package com.ykb.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerServiceApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ConsumerServiceApplication.class,
                              args);
    }

}
