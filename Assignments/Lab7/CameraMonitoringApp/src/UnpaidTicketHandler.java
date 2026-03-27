import java.util.List;

public class UnpaidTicketHandler extends CameraHandler{
    private List<String> unpaid = List.of("GHI789");

    public UnpaidTicketHandler(CameraHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(RecordCam record) {
        if(unpaid.contains(record.licencePlate())){
            System.out.println("Notify police: unpaid tickets for " + record.licencePlate());
        }
    }
}
