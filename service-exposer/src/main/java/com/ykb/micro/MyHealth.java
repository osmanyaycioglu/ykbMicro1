package com.ykb.micro;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class MyHealth implements HealthIndicator {

    @Override
    public Health health() {
        return Health.status(Status.UP)
                     .withDetail("mystat",
                                 "Şundan dolayı down")
                     .build();
    }

}
