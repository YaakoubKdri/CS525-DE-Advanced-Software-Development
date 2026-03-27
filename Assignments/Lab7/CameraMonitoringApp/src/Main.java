//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UnpaidTicketHandler unpaidTicketHandler = new UnpaidTicketHandler(null);
        RegistrationHandler registrationHandler = new RegistrationHandler(unpaidTicketHandler);
        SpeedingHandler speedingHandler = new SpeedingHandler(registrationHandler);
        StolenCarHandler stolenCarHandler = new StolenCarHandler(speedingHandler);

        CameraReceiver cameraReceiver = new CameraReceiver(stolenCarHandler);

        cameraReceiver.receive(new RecordCam("ABC123", 120, "CAM1"));
        cameraReceiver.receive(new RecordCam("DEF456", 80, "CAM2"));
        cameraReceiver.receive(new RecordCam("GHI789", 90, "CAM3"));
        cameraReceiver.receive(new RecordCam("JKL012", 110, "CAM4"));
    }
}