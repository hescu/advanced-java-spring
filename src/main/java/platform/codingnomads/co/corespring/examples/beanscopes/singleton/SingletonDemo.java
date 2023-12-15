package platform.codingnomads.co.corespring.examples.beanscopes.singleton;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SingletonDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(SingletonDemoConfig.class);
        ctx.refresh();

        SpringBean springBean1 = ctx.getBean(SpringBean.class);
        System.out.println("Hash code: " + springBean1.hashCode());

        SpringBean springBean2 = ctx.getBean(SpringBean.class);
        System.out.println("Hash code: " + springBean2.hashCode());

        SecondBean secondBean1 = ctx.getBean(SecondBean.class);
        System.out.println("Hash code: " + secondBean1.hashCode());

        SecondBean secondBean2 = ctx.getBean(SecondBean.class);
        System.out.println("Hash code: " + secondBean2.hashCode());

        ctx.close();
    }
}
