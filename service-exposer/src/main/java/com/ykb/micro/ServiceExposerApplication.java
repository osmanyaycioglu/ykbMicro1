package com.ykb.micro;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableDiscoveryClient
@EnableRabbit
@EnableHystrix
@EnableCircuitBreaker
@RemoteApplicationEventScan
public class ServiceExposerApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ServiceExposerApplication.class,
                              args);
    }

}
