package counter;

public class SingleDigitState implements CounterState{
    @Override
    public void increment(Counter counter) {
        counter.setCount(counter.getCount() + 1);
    }

    @Override
    public void decrement(Counter counter) {
        counter.setCount(counter.getCount() - 1);
    }
}
