/**
 *
 * @author Trevor Hartman
 * @author Jeff Grimm
 *
 * @since Version 1.0
 */

public class ForecastDisplay implements Display {

    private WeatherStation ws;

    private float currentPressure;

    private float lastPressure;

    // Constructor that allows class to accept an weatherstation object, and stores that object as I.variable ws
    public ForecastDisplay(WeatherStation weatherstation) {

        this.ws = weatherstation;

    }

    @Override
    public void update() {

        currentPressure = ws.getPressure();

        lastPressure = ws.getPressure();

        display(); // Calls display method from below
        

    }

    @Override
    public void display() {

        System.out.print("Forecast: ");
        if (currentPressure > lastPressure) {
            System.out.println("Improving weather on the way!");
        } else if (currentPressure == lastPressure) {
            System.out.println("More of the same");
        } else if (currentPressure < lastPressure) {
            System.out.println("Watch out for cooler, rainy weather");
        }

    }
}
