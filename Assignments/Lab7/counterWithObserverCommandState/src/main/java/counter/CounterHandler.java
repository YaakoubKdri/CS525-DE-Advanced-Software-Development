package counter;

public abstract class CounterHandler {
    protected CounterHandler nextHandler;

    public CounterHandler(CounterHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handle(int count);
}
