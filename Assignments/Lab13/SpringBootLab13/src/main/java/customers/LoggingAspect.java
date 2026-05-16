package customers;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

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
}
