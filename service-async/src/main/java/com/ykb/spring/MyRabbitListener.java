package com.ykb.spring;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitListener {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "asyncservice",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(name = "asyncservexch",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "asynckey"))
    @SendTo("result_exchange/resultback")
    public String handleMessage(final Customer cust) {
        System.out.println(cust);
        return "Name : " + cust.getName();
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "asyncservice2",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(name = "asyncservexch",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "secondkey"))
    public void handleMessage2(final Customer cust) {
        System.out.println(cust);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "asyncservice3",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(name = "async_topic",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.TOPIC),
                                             key = "test.abc.*"))
    public void handleMessage3(final Customer cust) {
        System.out.println(cust);
    }

}
