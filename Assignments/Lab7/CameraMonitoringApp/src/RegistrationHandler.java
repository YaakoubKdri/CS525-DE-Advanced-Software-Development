import java.util.List;

public class RegistrationHandler extends CameraHandler{
    private List<String> unregistered = List.of("DEF456");

    public RegistrationHandler(CameraHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(RecordCam record) {
        if(unregistered.contains(record.licencePlate())){
            System.out.println("Send registration ticket to " + record.licencePlate());
        }else {
            nextHandler.handle(record);
        }
    }
}
