package counter;

public interface CounterState {
    void increment(Counter counter);
    void decrement(Counter counter);
}
