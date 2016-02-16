package designmode.observer;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    // private float temperature;
    // private float humidity;
    // private Subject weatherData;

    // public CurrentConditionsDisplay(Subject weatherData) {
    // this.weatherData = weatherData;
    // weatherData.registerObsevser(this);
    // }
    //
    // @Override
    // public void display() {
    // System.out.println(String.format("Current conditions:%sF degreees and %s%% humidity", temperature, humidity));
    // }
    //
    // @Override
    // public void update(float temperature, float humidity, float pressure) {
    // this.temperature = temperature;
    // this.humidity = humidity;
    // display();
    // }

    Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println(String.format("Current conditions:%sF degreees and %s%% humidity", temperature, humidity));
    }

    @Override
    public void update(Observable obs, Object arg) {
        if (obs instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) obs;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

}
