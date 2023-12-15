package platform.codingnomads.co.corespring.examples.springbeans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
public class SpringDeveloper {

    private Address address;
    private Skills skills;

    public SpringDeveloper(Address address, Skills skills) {
        this.address = address;
        this.skills = skills;
    }
}
