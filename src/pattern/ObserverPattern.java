package pattern;

import java.util.ArrayList;
import java.util.List;

abstract class Observer {
    protected Subject subject;
    abstract void update();
}

class Subject{
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attachObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void notifyAllObservers() {
        for(Observer observer : observers) {
            observer.update();
        }
    }
}

class BinaryObserver extends Observer {
    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attachObserver(this);
    }

    public void update() {
        System.out.println("this binary of state: "
                + Integer.toBinaryString(this.subject.getState()));
    }
}

class OctalObserver extends Observer {
    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attachObserver(this);
    }

    public void update() {
        System.out.println("this octal of state: "
                + Integer.toOctalString(this.subject.getState()));
    }
}

class HexObserver extends Observer {
    public HexObserver(Subject subject) {
        this.subject = subject;
        this.subject.attachObserver(this);
    }

    public void update() {
        System.out.println("this hex of state: "
                + Integer.toHexString(this.subject.getState()));
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        Subject subject = new Subject();
        new BinaryObserver(subject);
        new OctalObserver(subject);
        new HexObserver(subject);
        subject.setState(10);
        subject.setState(15);
    }
}
