package platform.codingnomads.co.ioc.examples.constructorinjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("platform.codingnomads.co.ioc.examples.constructorinjection")
public class LaptopConfiguration {

    @Bean
    public Processor processor() {
        return new Processor(8, "i9");
    }

    @Bean
    public OS os() {
        return new OS("ubuntu");
    }

    @Bean
    public Memory memory() { return new Memory(8); }

    @Bean
    public GPU gpu() { return new GPU("GeForce RTX 4080"); }
}
