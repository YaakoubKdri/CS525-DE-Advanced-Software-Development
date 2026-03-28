package counter;

public class OddBlueHandler extends CounterHandler{
    public OddBlueHandler(CounterHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(int count) {
        if(count % 2 != 0 && (count < 15 || count == 17 || count == 19)){
            System.out.println("Blue");
        }else {
            nextHandler.handle(count);
        }
    }
}
