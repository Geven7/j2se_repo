package designmode.observer;

public interface Subject {

    public void registerObsevser(Observer o);

    public void removeObserver(Observer o);

    public void notifyObservers();
}
