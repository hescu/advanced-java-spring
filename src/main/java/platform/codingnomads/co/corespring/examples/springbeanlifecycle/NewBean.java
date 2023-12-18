package platform.codingnomads.co.corespring.examples.springbeanlifecycle;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class NewBean implements BeanNameAware {

    @Override
    public void setBeanName(String name) {
        System.out.println("I am a little munchkin from Munchkinland.");
    }
}
