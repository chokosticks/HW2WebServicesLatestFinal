import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
 * Created by antondahlin on 2016-02-08.
 */


@WebService(targetNamespace = "ns.flightItinearies")
public class FlightItinearies {

    private static HashMap<Airport, Boolean> visited = new HashMap<Airport, Boolean>();
    private static ArrayList<FlightItinerary> itineraries = new ArrayList<FlightItinerary>();
    private static Airports airports = new Airports();

    public FlightItinearies(){
        System.out.println("Flight Itinearies Service Started");
    }


    @WebMethod
    public List<FlightItinerary> getFlightItinearies(String departureCity, String destinationCity){

        ArrayList<FlightItinerary> result = new ArrayList<FlightItinerary>();

        if(!airports.airportExists(destinationCity) || !airports.airportExists(departureCity)) {
            System.out.println("Non existing airport specified");
            return result;
        }

        Airport finalDestination = airports.getAirport(destinationCity);
        Airport departureAirport = airports.getAirport(departureCity);

        initDFSVisit();



        DFS(departureAirport, departureAirport.getFlights(), finalDestination);

        return itineraries;
    }


    @WebMethod
    public List<Flight> getFlightPrices(String date)
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        try
        {
            d =df.parse(date);
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
        List<Flight> resultList = new ArrayList<Flight>();
        for(Airport a: airports.getAirports())
        {
            for(Flight f: a.getFlights())
            {
                if(df.format(d).equals(df.format(f.getDepartureDate())))
                {
                    resultList.add(f);
                    System.out.println(f.toString());
                }
            }
        }
        return resultList;
    }

    public void initDFSVisit(){
        for(Airport airport: airports.getAirports()){
            visited.put(airport,false);
        }
    }




    public void DFS(Airport currentAirport, ArrayList<Flight> flights, Airport finalDestination){
        ArrayList<FlightItinerary> flightItinerary = new ArrayList<FlightItinerary>();
        DFSRec(currentAirport, flights, finalDestination, flightItinerary);
    }

    public void DFSRec(Airport currentAirport, ArrayList<Flight> flights, Airport finalDestination, ArrayList<FlightItinerary> flightItinerary){

        visited.put(currentAirport, true);

        FlightItinerary fi = new FlightItinerary();


        for(Flight flight: currentAirport.getFlights()){

            Airport newCurrentAirport = airports.getAirport(flight.getDestinationCity());
            System.out.println("DFS-From: "+currentAirport.getName()+" DFS-To: "+ newCurrentAirport.getName());

            if(!visited.get(newCurrentAirport) && !newCurrentAirport.equals(finalDestination)) {
                //resultFlightItinerary.addFlight(flight);
                DFS(newCurrentAirport, newCurrentAirport.getFlights(), finalDestination);

            }else if(!visited.get(newCurrentAirport) && newCurrentAirport.equals(finalDestination)){
                visited.put(currentAirport, false);
                System.out.println("FOUNT IT "+newCurrentAirport.getName());

            }
        }
    }


    public static void main(String[] args){
        Endpoint.publish("http://0.0.0.0:1337/FlightItinearies", new FlightItinearies());
    }
}
