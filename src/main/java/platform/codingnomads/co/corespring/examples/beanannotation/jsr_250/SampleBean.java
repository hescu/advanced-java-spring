package platform.codingnomads.co.corespring.examples.beanannotation.jsr_250;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SampleBean {

    public SampleBean() {
        System.out.println("bean is getting ready!");
    }

    @PostConstruct
    public void init() {
        System.out.println("bean @PostConstruct is gathering resources..");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("time to @PreDestroy and head home..");
    }

    @PostConstruct
    public void doStuff() {
        System.out.println("bean @PostConstruct is doing stuff...");
    }

    @PreDestroy
    public void lastWords() {
        System.out.println("time to @PreDestroy and say a few last words..");
    }

}
