package customers;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.time.LocalDate;

@Aspect
@Component
public class LoggingAspect {
    @After("execution(* customers.EmailSender.sendEmail(..)) && args(email,message)")
    public void logAfterSendingEmail(JoinPoint joinPoint, String email, String message){
        EmailSender emailSender = (EmailSender) joinPoint.getTarget();
        System.out.println(
                LocalDate.now()
                + " method=" + joinPoint.getSignature().getName()
                + " address=" + email
                + " message=" + message
                + " outgoing mail server=" + emailSender.getOutgoingMailServer()
        );
    }

    @Around("execution(* customers.CustomerDAO.*(..))")
    public Object measureMethodTime(ProceedingJoinPoint call) throws Throwable{
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(call.getSignature().getName());
        Object returnValue = call.proceed();
        stopWatch.stop();
        long totalTime = stopWatch.getLastTaskTimeMillis();
        System.out.println("Execution time of " + call.getSignature().getName() + " = " + totalTime + " ms");
        return returnValue;
    }
}
