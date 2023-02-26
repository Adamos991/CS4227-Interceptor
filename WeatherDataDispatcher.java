import java.util.ArrayList;

class WeatherDataDispatcher {
    private ArrayList<WeatherDataInterceptor> interceptors;
    
    public WeatherDataDispatcher() {
        interceptors = new ArrayList<WeatherDataInterceptor>();
    }
    
    public void registerInterceptor(WeatherDataInterceptor interceptor) {
        interceptors.add(interceptor);
    }
    
    public void removeInterceptor(WeatherDataInterceptor interceptor) {
        interceptors.remove(interceptor);
    }
    
    public void dispatch(ContextObject context) {
        for (WeatherDataInterceptor interceptor : interceptors) {
            interceptor.intercept(context);
        }
    }
}
