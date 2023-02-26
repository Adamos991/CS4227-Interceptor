class SecurityInterceptor implements WeatherDataInterceptor {

    @Override
    public void intercept(ContextObject context) {
        float temperature = context.getTemperature();
        float humidity = context.getHumidity();
        float pressure = context.getPressure();

        // Check if any measurement is outside the normal range
        if (temperature < -30.0 || temperature > 50.0 ||
            humidity < 0.0 || humidity > 100.0 ||
            pressure < 900.0 || pressure > 1100.0) {
            System.out.println("WARNING: Weather data has been tampered with!");
        }
    }
}
