import java.io.IOException;
import java.util.ArrayList;

public class WeatherData implements SetMeasurements, GetMeasurements, Subject {
    private ArrayList<Observer> observers;
    private ContextObject context;
    private WeatherDataDispatcher dispatcher;
    private LoggingInterceptor loggingInterceptor;
    private SecurityInterceptor securityInterceptor;

    public WeatherData() throws IOException {
        observers = new ArrayList<Observer>();
        context = new ContextObject();
        dispatcher = new WeatherDataDispatcher();
        loggingInterceptor = new LoggingInterceptor();
        securityInterceptor = new SecurityInterceptor();
        dispatcher.registerInterceptor(loggingInterceptor);
        dispatcher.registerInterceptor(securityInterceptor);
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer)observers.get(i);
            observer.update(context.getTemperature(), context.getHumidity(), context.getPressure());
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        context.setTemperature(temperature);
        context.setHumidity(humidity);
        context.setPressure(pressure);
        dispatcher.dispatch(context);
        measurementsChanged();
    }

    public float getTemperature() {
        return context.getTemperature();
    }

    public float getHumidity() {
        return context.getHumidity();
    }

    public float getPressure() {
        return context.getPressure();
    }
}