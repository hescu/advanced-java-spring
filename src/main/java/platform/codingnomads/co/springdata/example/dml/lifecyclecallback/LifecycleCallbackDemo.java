package platform.codingnomads.co.springdata.example.dml.lifecyclecallback;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LifecycleCallbackDemo {

    public static void main(String[] args) {
        SpringApplication.run(LifecycleCallbackDemo.class);
    }

    @Bean
    public CommandLineRunner runStuff(PrintEntityRepository printEntityRepository) {
        return (args) -> {
            // put your logic here
            printEntityRepository.save(new PrintEntity(456L));
            printEntityRepository.save(new PrintEntity(789L));
            printEntityRepository.save(new PrintEntity(123L));
            printEntityRepository.save(new PrintEntity(951L));
        };
    }
}
