package x.y.z;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    public MyComponent myComponent() {
        return new MyComponent();
    }
}
