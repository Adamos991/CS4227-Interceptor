public class SecurityInterceptorTest {
    public static void main(String[] args) {
        // create a mock context object
        ContextObject context = new ContextObject();
        context.setTemperature(20);
        context.setHumidity(50);
        context.setPressure(1013);

        // create a security interceptor object
        WeatherDataInterceptor interceptor = new SecurityInterceptor();

        // test case 1: context object with normal temperature, humidity, and pressure
        System.out.println("Test case 1: normal context object");
        interceptor.intercept(context);

        // test case 2: context object with high temperature, humidity, and pressure
        System.out.println("Test case 2: extremely high temperature, humidity, and pressure");
        context.setTemperature(100);
        context.setHumidity(90);
        context.setPressure(1100);
        interceptor.intercept(context);

        // test case 3: context object with low temperature, humidity, and pressure
        System.out.println("Test case 3: extremely low temperature, humidity, and pressure");
        context.setTemperature(-40);
        context.setHumidity(-1);
        context.setPressure(800);
        interceptor.intercept(context);
    }
}
