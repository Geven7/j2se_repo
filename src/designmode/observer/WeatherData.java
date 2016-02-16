package designmode.observer;

import java.util.Observable;

public class WeatherData extends Observable {

    // private ArrayList observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        // observers = new ArrayList();
    }

    // @Override
    // public void registerObsevser(Observer o) {
    // System.out.println("registerObsevser");
    // observers.add(o);
    // }
    //
    // @Override
    // public void removeObserver(Observer o) {
    // int i = observers.indexOf(o);
    // if (i >= 0) {
    // observers.remove(i);
    // }
    // }
    //
    // @Override
    // public void notifyObservers() {
    // for (int i = 0; i < observers.size(); i++) {
    // Observer observer = (Observer) observers.get(i);
    // observer.update(temperature, humidity, pressure);
    // }
    // }

    public void measusrementsChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measusrementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

}
