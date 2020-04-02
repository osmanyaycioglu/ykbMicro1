package com.ykb.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consume")
public class ConsumerRest {

    @Autowired
    private RestTemplate rt;


    @GetMapping("/test")
    public String testRestClient() {
        String forObjectLoc = this.rt.getForObject("http://exposer/exp/testProp",
                                                   String.class);
        return forObjectLoc;
    }

}
