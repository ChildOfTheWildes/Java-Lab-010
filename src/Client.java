/**
 *
 * @author Trevor Hartman
 * @author Jeff Grimm
 *
 * @since Version 1.0
 */

import java.io.IOException;

public class Client {

    public static void main(String[] args) throws IOException {

        WeatherStation wsObj = new WeatherStation(); // Creates weatherStation object

        Display currentConditions = new CurrentConditions(wsObj); // Creates currentConditions object that takes the
        // weatherStation object to update values

        Display forcastDisplay = new ForecastDisplay(wsObj); // Creates forcastDisplay object that takes the
        // weatherStation object to update values

        Display statisticsDisplay = new StatisticsDisplay(wsObj); // Creates statisticDisplay object that takes the
        // weatherStation object to update values

        wsObj.measure(); // Calls the method measure used to parse info from the weatherStation URL

        currentConditions.update(); // Updates values in currentCondition object that also calls method display

        System.out.println(); // linebreak

        statisticsDisplay.update(); // Updates values in statisticDisplay object that also calls method display

        System.out.println(); // linebreak

        forcastDisplay.update(); // Updates values in forcastDisplay object that also calls method display

        System.out.println(); // linebreak

        }






}
