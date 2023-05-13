package headfirst.observer;

public class Main {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        ConcurrentConditionDisplay currentDisplay = new ConcurrentConditionDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4F);
        weatherData.setMeasurements(90, 75, 31.4F);
        weatherData.setMeasurements(100, 85, 32.4F);
    }
}
