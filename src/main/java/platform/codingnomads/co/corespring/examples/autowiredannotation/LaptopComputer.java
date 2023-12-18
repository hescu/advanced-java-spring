package platform.codingnomads.co.corespring.examples.autowiredannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("laptop")
public class LaptopComputer {
    @Autowired
    private VideoCard videoCard;
}
