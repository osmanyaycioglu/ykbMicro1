package com.ykb.micro.remoteevent;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

public class MyRemoteEvent extends RemoteApplicationEvent {

    private static final long serialVersionUID = 4568065173733085381L;

    public MyRemoteEvent() {
    }

    public MyRemoteEvent(final Object source,
                         final String id,
                         final String messageParam) {
        super(source,
              id);
        this.message = messageParam;
    }

    private String message;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(final String messageParam) {
        this.message = messageParam;
    }


}
