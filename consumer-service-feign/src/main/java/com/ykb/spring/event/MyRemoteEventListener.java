package com.ykb.spring.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyRemoteEventListener {

    @EventListener(MyRemoteEvent.class)
    public void handle(final MyRemoteEvent mEvent) {
        System.out.println(mEvent.getMessage());
    }
}
