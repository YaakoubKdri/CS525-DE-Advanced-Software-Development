public abstract class CameraHandler {
    protected CameraHandler nextHandler;

    public CameraHandler(CameraHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public CameraHandler getNextHandler() {
        return nextHandler;
    }

    public abstract void handle(RecordCam record);
}
