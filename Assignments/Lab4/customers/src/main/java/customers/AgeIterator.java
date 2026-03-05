package customers;

import java.util.*;

public class AgeIterator implements Iterator<Customer> {
    private final List<Customer> list;
    private int position;

    public AgeIterator(List<Customer> list) {
        this.position = 0;
        this.list = new ArrayList<>(list);
        Collections.sort(this.list, Comparator.comparingInt(Customer::getAge));
    }

    public Iterator<Customer> iterator(){
        return this;
    }
    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    @Override
    public Customer next() {
        return list.get(position++);
    }

    @Override
    public void remove(){
        throw new UnsupportedOperationException();
    }

}
