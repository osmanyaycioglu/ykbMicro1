package com.ykb.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.bus.SpringCloudBusClient;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ykb.spring.event.MyRemoteEvent;

@RestController
@RequestMapping("/consume")
public class ConsumerRest {

    @Autowired
    private IExposerRest         er;

    @Autowired
    private SpringCloudBusClient scbc;

    @Autowired
    private ApplicationContext   ac;

    @HystrixCommand(fallbackMethod = "testHyst")
    @GetMapping("/test")
    public String testRestClient() {

        MyRemoteEvent eventLoc = new MyRemoteEvent(this,
                                                   this.ac.getId(),
                                                   "test event message");
        this.scbc.springCloudBusOutput()
                 .send(MessageBuilder.withPayload(eventLoc)
                                     .build());
        return this.er.testProp();
    }

    public String testHyst() {
        return "End";
    }

}
