package counter;

public class EvenGreenHandler extends CounterHandler{
    public EvenGreenHandler(CounterHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(int count) {
        if(count % 2 == 0 && count >= 10 && count != 12 && count != 13){
            System.out.println("Green");
        }else{
            nextHandler.handle(count);
        }
    }

}
