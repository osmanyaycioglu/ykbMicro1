package com.ykb.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consume")
public class ConsumerRest {

    @Autowired
    private IExposerRest er;

    @GetMapping("/test")
    public String testRestClient() {
        return this.er.testProp();
    }

}
