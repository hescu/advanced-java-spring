package platform.codingnomads.co.corespring.lab.practice;

import com.querydsl.core.annotations.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath*:xml-config/musicians.xml"})
public class BandConfig {

    @Bean
    public Band band() { return new Band(); }
    @Bean
    public Singer singer() { return new Singer("Ronnie James Dio"); }

    @Bean
    public Drummer drummer() { return new Drummer("Frost", "Schlagzeug"); }
}
