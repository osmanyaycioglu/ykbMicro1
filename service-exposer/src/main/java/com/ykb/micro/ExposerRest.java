package com.ykb.micro;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/exp")
@RefreshScope
public class ExposerRest {

    @Autowired
    private RabbitTemplate rt;

    @Value("${my.property}")
    private String         myProp;

    @Value("${aa.bb.cc}")
    private String         aabbcc;

    @Value("${server.port}")
    private int            port;

    private static int     counter = 0;

    @HystrixCommand(fallbackMethod = "testFallback",
                    commandProperties = {
                                          @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                                                           value = "500")
                    })
    @GetMapping("/testProp")
    public String testProp() {

        Customer customerLoc = new Customer();
        customerLoc.setName("osman");
        customerLoc.setSurname("yay");
        customerLoc.setUsername("user1");
        customerLoc.setAccount(100);
        this.rt.convertAndSend("asyncservexch",
                               "asynckey",
                               customerLoc);
        ExposerRest.counter++;
        if ((ExposerRest.counter % 4) == 0) {
            try {
                Thread.sleep(1000);
            } catch (Exception eLoc) {
            }
        }
        return this.myProp + " " + this.port;
    }

    public String testFallback() {
        return "Şu anda hizmet yok";
    }

    @GetMapping("/testProp2")
    public String testProp2() {
        return this.aabbcc;
    }

}
