package counter;

public class OddOrangeHandler extends CounterHandler{
    public OddOrangeHandler(CounterHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(int count) {
        if(count % 2 != 0 && count >= 15 && count != 17 && count != 19){
            System.out.println("Orange");
        }else {
            nextHandler.handle(count);
        }
    }
}
