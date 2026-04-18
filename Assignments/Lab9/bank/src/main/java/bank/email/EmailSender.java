package bank.email;

public class EmailSender implements IEmailSender {
    @Override
    public void sendEmail(String message) {
        System.out.println("Sending email: " + message);
    }
}
