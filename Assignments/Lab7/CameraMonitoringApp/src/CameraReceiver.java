public class CameraReceiver {
    private CameraHandler cameraHandler;

    public CameraReceiver(CameraHandler cameraHandler) {
        this.cameraHandler = cameraHandler;
    }
    public void receive(RecordCam record){
        cameraHandler.handle(record);
    }
}
