package com.ykb.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
@RequestMapping("/consume")
public class ConsumerRest {

    @Autowired
    private RestTemplate rt;

    @Autowired
    private EurekaClient ec;

    @GetMapping("/test")
    public String testRestClient() {
        String forObjectLoc = this.rt.getForObject("http://EXPOSER/exp/testProp",
                                                   String.class);
        ResponseEntity<String> forEntityLoc = this.rt.getForEntity("http://EXPOSER/exp/testProp",
                                                                   String.class);
        return forObjectLoc;
    }

    @GetMapping("/customer/getall")
    public List<Customer> getCustomer() {
        List<Customer> forObjectLoc = this.rt.getForObject("http://EXPOSER/customer/getall",
                                                           List.class);
        return forObjectLoc;
    }


    @GetMapping("/customer/getall2")
    public List<Customer> getCustomer2() {
        InstanceInfo inst = this.ec.getNextServerFromEureka("EXPOSER",
                                                            false);

        List<Customer> forObjectLoc = this.rt.getForObject(inst.getHostName() + "/customer/getall",
                                                           List.class);
        return forObjectLoc;
    }

}
