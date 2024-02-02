package platform.codingnomads.co.aspectorientedprogramming.lab.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServiceAspect {
    @Before("execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.greeting())")
    public void beforeGreeting(JoinPoint joinPoint) {
        System.out.println("Before the execution of the greeting() method.");
    }

    @After("execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.greeting())")
    public void afterGreeting(JoinPoint joinPoint) {
        System.out.println("After the execution of the greeting() method.");
    }
}
