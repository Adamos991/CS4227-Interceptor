import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LoggingInterceptor implements WeatherDataInterceptor {
    private BufferedWriter writer;

    public LoggingInterceptor() throws IOException {
        writer = new BufferedWriter(new FileWriter("weather.log", true));
    }

    @Override
    public void intercept(ContextObject context) {
        // Log the measurements to the file
        try {
            writer.write(java.time.LocalDate.now().toString() + ": " + String.format("Temperature: %.2f, Humidity: %.2f, Pressure: %.2f\n", context.getTemperature(), context.getHumidity(), context.getPressure()));
            if (context.getTemperature() > 30.0) {
                writer.write("WARNING: High temperature alert!\n");
            }
            if (context.getHumidity() > 80.0) {
                writer.write("WARNING: High humidity alert!\n");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
