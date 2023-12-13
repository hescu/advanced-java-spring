package platform.codingnomads.co.ioc.examples.constructorinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Laptop {

    private Processor processor;
    private OS os;
    private Memory memory;
    private GPU gpu;

    // these fields are being injected from the ApplicationContext
    // if a class contains only one constructor (as this one does), the use of @Autowired is optional
    // if a class contains two or more constructors, @Autowired is required for constructor injection to take place
    public Laptop(Processor processor, OS os, Memory memory) {
        this.processor = processor;
        this.os = os;
        this.memory = memory;
    }

    @Autowired
    public void setGpu(GPU gpu) {
        this.gpu = gpu;
    }

    public String printLaptopConfiguration() {
        return "processor: " + processor.getCore() + " core " + processor.getName() +
                "\nOS: " + os.getName() +
                "\nMemory: " + memory.getCapacityInGB();
    }
}
