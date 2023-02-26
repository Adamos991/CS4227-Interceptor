import java.io.IOException;

public class WeatherStation{
    public static void main(String[] args) throws IOException {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        weatherData.setMeasurements(18, 65, 999);
        weatherData.setMeasurements(25, 70, 1000);
        weatherData.setMeasurements(55, -10, 1500);
    }
}