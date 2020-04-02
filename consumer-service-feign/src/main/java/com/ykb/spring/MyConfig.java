package com.ykb.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class MyConfig {

    @Autowired
    private IExposerRest er;


    @Scheduled(fixedDelay = 2000)
    public void test() {
        String testPropLoc = this.er.testProp();
        System.out.println(testPropLoc);
    }

}
