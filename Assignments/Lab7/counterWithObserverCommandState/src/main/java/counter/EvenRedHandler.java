package counter;

public class EvenRedHandler extends CounterHandler{
    public EvenRedHandler(CounterHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(int count) {
        if(count % 2 == 0 && (count < 10 || count == 12 || count == 13)){
            System.out.println("Red");
        }else{
            nextHandler.handle(count);
        }
    }

}
