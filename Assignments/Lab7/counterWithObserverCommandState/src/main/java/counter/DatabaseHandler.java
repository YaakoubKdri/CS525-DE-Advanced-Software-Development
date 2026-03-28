package counter;

public class DatabaseHandler extends CounterHandler{
    public DatabaseHandler(CounterHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(int count) {
        System.out.println("Saving to database: " + count);
    }

}
