/**
 *
 * @author Trevor Hartman
 * @author Jeff Grimm
 *
 * @since Version 1.0
 */

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WeatherStation {
    private URL url;
    private List<Display> displays;
    private Gson gson;
    private float temperature;
    private float humidity;
    private float pressure;

    // Added variables to parse min/max directly from weatherstation api (URL) in constructor
    private float min;
    private float max;

    // Constructor that stores the contents of the array ArrayList as a list named display
    // Not sure what Gson type is
    // Initializes url to the weather map link
    public WeatherStation() {
        displays = new ArrayList<Display>();
        gson = new Gson();
        try {
            url = new URL("https://api.openweathermap.org/data/2.5/weather?q=Loleta,us&units=imperial&APPID=132cb2f1db987da116d403e616723290");
        } catch (MalformedURLException m) {
        }
    }

    // registerDisplay registers each dependent class/object the displays list (list is declared above)
    public void registerDisplay(Display d) {

        displays.add(d);
    }

    public void removeDisplay(Display d) {

        displays.remove(d);
    }

    // Traverses array/list displays by
    public void notifyDisplays() { // updates via loop all objects/classes dependent on Displays
        for (Display d : displays) {
            d.update(); // Call update method stored in Display class for each element in displays array
        }
    }

    // Getters

    public float getMin() {
        return min;
    }

    public float getMax() {
        return max;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public static float hPaToInHG(float hPa) {
        return hPa * 0.029529983071445f;
    }

    public void measure() throws IOException {
        InputStreamReader reader = new InputStreamReader(url.openStream());
        JsonObject object = gson.fromJson(reader, JsonObject.class);
        JsonObject main = object.get("main").getAsJsonObject();

        // Added these lines to parse min/max directly from url
        this.max = main.get("temp_max").getAsFloat();
        this.min = main.get("temp_min").getAsFloat();

        this.temperature = main.get("temp").getAsFloat();
        this.humidity = main.get("humidity").getAsFloat();
        this.pressure = WeatherStation.hPaToInHG(main.get("pressure").getAsFloat());
        notifyDisplays();

    }
}
