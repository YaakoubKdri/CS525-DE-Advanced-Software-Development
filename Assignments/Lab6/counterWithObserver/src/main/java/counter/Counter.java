package counter;

public class Counter extends Subject{
	
	private int count=0;
    private CounterState state;
    public Counter() {
        this.state = new SingleDigitState();
    }
	
	public void increment(){
		state.increment(this);
        updateState();
    	donotify(count);
	}
	
	public void decrement(){
		state.decrement(this);
        updateState();
    	donotify(count);
	}

    private void updateState() {
        if(Math.abs(count) < 10){
            state = new SingleDigitState();
        }else if(Math.abs(count) < 100){
            state = new DoubleDigitState();
        }else{
            state = new TripleDigitState();
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
