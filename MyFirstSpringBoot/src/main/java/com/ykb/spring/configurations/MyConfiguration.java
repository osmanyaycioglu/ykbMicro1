package com.ykb.spring.configurations;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.ykb.spring.beans.EmployeeManager;

import x.y.z.MyComponent;

@Configuration
@Import(x.y.z.MyConfiguration.class)
public class MyConfiguration {

    @Bean
    @Qualifier("osman")
    public EmployeeManager createEmployeeManager() {
        return new EmployeeManager();
    }

    @Bean
    public MyComponent createMyComponent() {
        return new MyComponent();
    }

}
