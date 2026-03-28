package counter;

public class LoggingHandler extends CounterHandler{
    public LoggingHandler(CounterHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(int count) {
        System.out.println("Logging count: " + count);
        nextHandler.handle(count);
    }

}
