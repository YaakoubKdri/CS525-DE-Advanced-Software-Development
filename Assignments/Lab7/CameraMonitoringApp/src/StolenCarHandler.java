import java.util.List;

public class StolenCarHandler extends CameraHandler{
    private List<String> stolenCars = List.of("ABC123", "XYZ999");

    public StolenCarHandler(CameraHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(RecordCam record) {
        if(stolenCars.contains(record.licencePlate())){
            System.out.println("Notify police: stolen car " + record.licencePlate());
        }else {
            nextHandler.handle(record);
        }
    }
}
