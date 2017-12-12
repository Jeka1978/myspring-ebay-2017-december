package quoters.aop;

import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author Evgeny Borisov
 */
@Component
@Aspect
public class QuoterAspect {
    private Random random = new Random();

    @Pointcut("execution(* quoters.business..*.*(..))")
    public void businessMethod(){}

   /* @Around("@annotation(quoters.Secured) && businessMethod()")
    @SneakyThrows
    public Object handleSecuredMethods(ProceedingJoinPoint pjp) {
        System.out.println(123);
        if (random.nextInt(2) == 2) {
            throw new SecurityException("not allowed here, try again");
        }
        Object retVal = pjp.proceed();
        System.out.println(456);
        return retVal;
    }*/

    @Before("execution(* quoters..*.say*(..))")
    public void beforeSayMethods(JoinPoint jp) {
        System.out.println("this is quote: "+jp.getTarget().getClass().getSimpleName());
    }
}

















