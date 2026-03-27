public class SpeedingHandler extends CameraHandler {
    private static final int LIMIT = 100;

    public SpeedingHandler(CameraHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(RecordCam record) {
        if(record.speed() > LIMIT){
            System.out.println("send speeding ticket to " + record.licencePlate());
        }else {
            nextHandler.handle(record);
        }
    }
}
