package exobserver;

public class ForecastDisplay implements Observer, DisplayElement {
	
	private float currentPressure = 29.92f;
	private float lastPressure;
	private WeatherData weatherData;
	
	public ForecastDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	@Override
	public void update(float temp, float humidity, float pressure) {
		lastPressure = currentPressure;
		currentPressure = pressure;
		display();
	}
	
	@Override
	public void display() {
		System.out.print("Forecast: ");
		if (currentPressure > lastPressure) {
			System.out.println("Melhora no tempo à caminho!");
		} 
		else if (currentPressure == lastPressure) {
			System.out.println("Mais do mesmo!");
		} 
		else if (currentPressure < lastPressure) {
			System.out.println("Fique de olho para um clima mais frio e chuvoso!");
		}
	}

}
