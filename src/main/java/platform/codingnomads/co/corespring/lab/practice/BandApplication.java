package platform.codingnomads.co.corespring.lab.practice;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import platform.codingnomads.co.corespring.lab.complete.CoreLabConfig;

@SpringBootApplication
public class BandApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(
                BandConfig.class);
        final Band band = ctx.getBean(Band.class);
        System.out.println(band);
    }
}
