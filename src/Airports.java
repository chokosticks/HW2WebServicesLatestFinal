import javax.annotation.PostConstruct;
import javax.jws.WebService;
import javax.xml.ws.WebServiceProvider;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by antondahlin on 2016-02-13.
 */

@WebServiceProvider
public class Airports {

    private ArrayList<Airport> airports = new ArrayList<Airport>();


    public Airports(){

        Flight fi0 = new Flight("Stockholm", "Oslo", new Date(2016-02-01), 1200, 120);
        Flight fi1 = new Flight("Stockholm", "Helsingfors", new Date(2016-12-05), 1100, 12);
        Flight fi2 = new Flight("Stockholm", "Rejkavik", new Date(2016-12-05), 1100, 12);
        Flight fi3 = new Flight("Oslo", "Moskva", new Date(2016-12-03), 1300, 132);
        Flight fi4 = new Flight("Oslo", "Helsingfors", new Date(2016-12-05), 1100, 12);
        Flight fi5 = new Flight("Moskva", "Paris", new Date(2016-12-05), 1100, 12);
        Flight fi6 = new Flight("Helsingfors", "Moskva", new Date(2016-12-05), 1100, 12);


        ArrayList<Flight> initFlights0 = new ArrayList<Flight>();
        ArrayList<Flight> initFlights1 = new ArrayList<Flight>();
        ArrayList<Flight> initFlights2 = new ArrayList<Flight>();
        ArrayList<Flight> initFlights3 = new ArrayList<Flight>();
        ArrayList<Flight> initFlights4 = new ArrayList<Flight>();


        initFlights0.add(fi0);
        initFlights0.add(fi1);
        initFlights0.add(fi2);

        Airport stockholm = new Airport("Stockholm", initFlights0);
        airports.add(stockholm);


        initFlights1.add(fi3);
        initFlights1.add(fi4);
        Airport oslo = new Airport("Oslo", initFlights1);
        airports.add(oslo);

        initFlights2.add(fi5);
        Airport moskva = new Airport("Moskva", initFlights2);
        airports.add(moskva);

        initFlights3.add(fi6);
        Airport helsingfors = new Airport("Helsingfors", initFlights3);
        airports.add(helsingfors);

        Airport paris = new Airport("Paris", initFlights4);
        airports.add(paris);
        Airport rejkavik = new Airport("Rejkavik", initFlights4);
        airports.add(rejkavik);
    }

    public ArrayList<Airport> getAirports(){
        return airports;
    }

    public boolean airportExists(String airport){

        for(Airport ap: airports){
            if(ap.getName().equals(airport)){
                return true;
            }
        }
        return false;
    }

    public Airport getAirport(String airport){
        Airport temp = new Airport();
        for(Airport ap: airports){
            System.out.println("FOR: airport= "+ap.getName());
            if(ap.getName().equalsIgnoreCase(airport)){
                temp = ap;
            }
        }
        return temp;
    }

    public void printAirports(){
        for(Airport airport: airports){
            System.out.println(airport.getName());
        }
    }


}
