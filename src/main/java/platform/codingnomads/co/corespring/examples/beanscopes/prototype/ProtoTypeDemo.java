package platform.codingnomads.co.corespring.examples.beanscopes.prototype;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ProtoTypeDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(PrototypeDemoConfig.class);
        ctx.refresh();

        SpringBean springBean1 = ctx.getBean(SpringBean.class);
        System.out.println("Hash code: " + springBean1.hashCode());

        SpringBean springBean2 = ctx.getBean(SpringBean.class);
        System.out.println("Hash code: " + springBean2.hashCode());

        SecondSpringBean secondSpringBean1 = ctx.getBean(SecondSpringBean.class);
        System.out.println("Hash code: " + secondSpringBean1.hashCode());

        SecondSpringBean secondSpringBean2 = ctx.getBean(SecondSpringBean.class);
        System.out.println("Hash code: " + secondSpringBean2.hashCode());

        ctx.close();
    }
}
