package customers;

import java.util.Iterator;
import java.util.List;

public class SkippingIterator implements Iterator<Customer> {
    private final List<Customer> list;
    private int position;

    public SkippingIterator(List<Customer> list) {
        this.list = list;
        this.position = 0;
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
        Customer customer = list.get(position);
        position += 2;
        return customer;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
