import javax.xml.ws.WebServiceProvider;
import java.util.ArrayList;

/**
 * Created by antondahlin on 2016-02-12.
 */
@WebServiceProvider
public class FlightItinerary {

    private static int id;
    private static ArrayList<Flight> flights;

    public FlightItinerary(){}

    public FlightItinerary(int id){
        this.id = id;
    }


    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void addFlight(Flight flight){
        this.flights.add(flight);
    }

    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
