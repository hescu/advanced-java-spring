package platform.codingnomads.co.aspectorientedprogramming.lab.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PrintableAspect {

    @Pointcut("@annotation(Printable)")
    public void executePrintable() { }

    @Before("executePrintable()")
    public void printString(JoinPoint joinPoint) {
        System.out.println("Executing Printable Annotation XXXXXXXXXX");
    }
}
