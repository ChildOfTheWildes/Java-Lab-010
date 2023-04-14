/**
 *
 * @author Trevor Hartman
 * @author Jeff Grimm
 *
 * @since Version 1.0
 */

public class CurrentConditions implements Display {

    // Instance variables
private WeatherStation ws;

private float temperature;

private float humidity;

private float pressure;

// Constructor that allows class to accept an weatherstation object, and stores that object as I.variable ws
public CurrentConditions(WeatherStation weatherstation) {

    this.ws = weatherstation;

}
// Interface update method that updates all I.variables from the weatherstation object passed to this class via the
    // weatherstations's get methods
    @Override
    public void update() {

    this.temperature = ws.getTemperature();

    this.humidity = ws.getHumidity();

    this.pressure = ws.getPressure();

    display(); // Calls display method from below

    }

    // Interface method for displaying the update method's variables
    @Override
    public void display() {

        System.out.printf("The Temperature is %f, the Humidity is %f, and the pressure is %f.", temperature, humidity, pressure);

    }

}


