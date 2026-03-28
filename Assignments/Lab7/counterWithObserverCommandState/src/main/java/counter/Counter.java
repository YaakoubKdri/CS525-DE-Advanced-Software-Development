package counter;

public class Counter extends Subject{
	CounterState state;
	
	private int count=0;

    private CounterHandler handler;

    public void setHandler(CounterHandler handler) {
        this.handler = handler;
    }

    public void increment(){
		count=state.increment();
        handler.handle(count); // CoR
    	donotify(count);
	}
	
	public void decrement(){
		count=state.decrement();
        handler.handle(count);
    	donotify(count);
	}

	public void setState(CounterState state) {
		this.state = state;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	

}
