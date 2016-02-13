import javax.xml.ws.WebServiceProvider;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by antondahlin on 2016-02-12.
 */
@WebServiceProvider
public class FlightItinerary {

    private static int id;
    private static ArrayList<Flight> flights;
    private int price =0;

    public FlightItinerary(ArrayList<Flight> flights)
    {
        setFlights(flights);
        Random r = new Random();
        id = r.nextInt(9999-1000+1) + 1000;
    }

    public FlightItinerary()
    {

    }


    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
        price = 0;
        for(Flight f: flights)
        {
            price += Math.floor(f.getPrice());
        }
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void addFlight(Flight flight){
        this.flights.add(flight);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice()
    {
        return price;
    }
}
