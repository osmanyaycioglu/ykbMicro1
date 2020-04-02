package com.ykb.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceExposerApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ServiceExposerApplication.class,
                              args);
    }

}
