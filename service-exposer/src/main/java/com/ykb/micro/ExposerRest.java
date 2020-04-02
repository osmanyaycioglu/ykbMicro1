package com.ykb.micro;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exp")
public class ExposerRest {

    @Value("${my.property}")
    private String myProp;

    @Value("${aa.bb.cc}")
    private String aabbcc;

    @Value("${server.port}")
    private int    port;

    @GetMapping("/testProp")
    public String testProp() {
        return this.myProp + " " + this.port;
    }

    @GetMapping("/testProp2")
    public String testProp2() {
        return this.aabbcc;
    }

}
