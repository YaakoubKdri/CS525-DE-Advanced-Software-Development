package counter;

public class DoubleDigitState implements CounterState{
    @Override
    public void increment(Counter counter) {
        counter.setCount(counter.getCount() + 2);
    }

    @Override
    public void decrement(Counter counter) {
        counter.setCount(counter.getCount() - 2);
    }
}
