package platform.codingnomads.co.corespring.examples.scopeannotaion;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ScopeAnnotationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ScopeAnnotationDemoConfig.class);
        ctx.refresh();
        SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
        Imperium imperium1 = ctx.getBean(Imperium.class);
        Imperium imperium2 = ctx.getBean(Imperium.class);

        System.out.println("-----Hashcode of Singleton-----");
        System.out.println(singletonBean1.hashCode());
        System.out.println(singletonBean2.hashCode());
        System.out.println(imperium1.hashCode());
        System.out.println(imperium2.hashCode());

        final PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
        final PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
        final Chaos chaos1 = ctx.getBean(Chaos.class);
        final Chaos chaos2 = ctx.getBean(Chaos.class);

        System.out.println("-----Hashcode of Prototype-----");
        System.out.println(prototypeBean1.hashCode());
        System.out.println(prototypeBean2.hashCode());
        System.out.println(chaos1.hashCode());
        System.out.println(chaos2.hashCode());
        System.out.println();
        ctx.close();
    }
}
