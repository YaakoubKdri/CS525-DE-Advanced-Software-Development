package bank.email;

public class EmailSender implements IEmailSender {
    private static final EmailSender instance = new EmailSender();

    private EmailSender() {
    }

    public static EmailSender getInstance(){
        return instance;
    }

    @Override
    public void sendEmail(String message) {
        System.out.println("Sending email: " + message);
    }
}
