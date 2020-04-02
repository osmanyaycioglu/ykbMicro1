package com.ykb.spring;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "exposer")
@RequestMapping("/exp")
public interface IExposerRest {

    @GetMapping("/testProp")
    public String testProp();

    @GetMapping("/testProp2")
    public String testProp2();

}

