package counter;

public class Counter extends Subject{
	
	private int count=0;
	
	public void increment(){
		count++;
    	notifyObservers(count);
	}
	
	public void decrement(){
		count--;
	   	notifyObservers(count);
	}

    public int getCount() {
        return count;
    }

}
