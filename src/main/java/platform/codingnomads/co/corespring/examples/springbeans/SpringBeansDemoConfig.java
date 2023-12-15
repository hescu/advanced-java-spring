package platform.codingnomads.co.corespring.examples.springbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan(basePackageClasses = SpringDeveloper.class)
public class SpringBeansDemoConfig {
    @Bean
    public Address address() {
        return new Address("Main Street", 1500);
    }

    @Bean
    public Skills skills() {
        return new Skills(Arrays.asList("Python", "JavaScript", "Java"));
    }
}
