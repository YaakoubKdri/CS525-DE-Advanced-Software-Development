package counter;

import java.util.ArrayList;
import java.util.Collection;

public class Subject {
    private Collection<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(int value){
        for(Observer observer : observers){
            observer.update(value);
        }
    }
}
