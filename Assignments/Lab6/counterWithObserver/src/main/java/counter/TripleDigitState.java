package counter;

public class TripleDigitState implements CounterState{
    @Override
    public void increment(Counter counter) {
        counter.setCount(counter.getCount() + 3);
    }

    @Override
    public void decrement(Counter counter) {
        counter.setCount(counter.getCount() - 3);
    }
}
