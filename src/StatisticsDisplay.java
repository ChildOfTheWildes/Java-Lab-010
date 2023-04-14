/**
 *
 * @author Trevor Hartman
 * @author Jeff Grimm
 *
 * @since Version 1.0
 */


public class StatisticsDisplay implements Display {

    // Instance variables
    private WeatherStation ws;

    private float temperatureMin;

    private float temperatureMax;

    private float temperatureTotal;

    private int numReadings;


    // Interface update method that updates all I.variables from the weatherstation object passed to this class via the
    // weatherstations's get methods
    // temperatureMax and temperatureMin are initialized to extreme values to ensure they are updated in update method
    public StatisticsDisplay(WeatherStation weatherstation) {

        this.ws = weatherstation;

    }

    @Override
    public void update() {

        // Parses min/max from the WeatherStation and declares only one reading was done (since the program only runs once)
        // Would be cool given more time to figure out how to run a loop from client and keep track of loop iteration here

        temperatureMin = ws.getMin();

        temperatureMax = ws.getMax();

        temperatureTotal = (temperatureMax + temperatureMin ) / 2;

        numReadings = 1;

        display(); // Calls display method from below

    }

    @Override
    public void display() {

        // Cannot figure out why numReadings won't print with format specifier so I tacked it on with a +
        System.out.printf("The Temperature min is %f, the Temperature max is %f, the Temperature average is %f, the number of readings are " + numReadings + ".",
                temperatureMin, temperatureMax, temperatureTotal);

    }
}
