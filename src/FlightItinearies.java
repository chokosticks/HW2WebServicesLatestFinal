import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by antondahlin on 2016-02-08.
 */


@WebService(targetNamespace = "ns.flightItinearies")
public class FlightItinearies {

    private static HashMap<Airport, Boolean> visited = new HashMap<Airport, Boolean>();
    private static Airports airports = new Airports();
    private static ArrayList<FlightItinerary> itineraryResult = new ArrayList<>();
    private static ArrayList<Booking> bookedItinearies = new ArrayList<>();

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

        result = DFS(departureAirport, finalDestination);
        itineraryResult = result;
        setItineraryId();
        return result;
    }

    private void setItineraryId(){
        int id = 0;
        for(FlightItinerary fi: itineraryResult){
            fi.setId(id);
            id++;
        }
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

    @WebMethod
    public String bookItinerary(int id, int creditCardNumber){
        if(id < itineraryResult.size()) {
            bookedItinearies.add(new Booking(creditCardNumber, itineraryResult.get(id)));
            String from, to="";
            Booking booking = bookedItinearies.get(bookedItinearies.size()-1);
            from = booking.getItinerary().getFlights().get(0).getDepartureCity();
            to = booking.getItinerary().getFlights().get(booking.getItinerary().getFlights().size()-1).getDestinationCity();
            return "Booking succeeded for flight itinerary id: " + id + " from " + from + " to " + to + " for " + booking.getItinerary().getPrice();
        }else
            return "No itinerary with that id exists";
    }

    @WebMethod
    public String issueTickets(int creditCardNumber){
        int itineraryID = 0;
        for(Booking booking: bookedItinearies){
            if(booking.getCreditCardNumber() == creditCardNumber){


                return "Tickets issued for itinerary id: "+booking.getItinerary().getId();

            }
        }
        return "No booking found for your creditcard number";
    }

    public void initDFSVisit(){
        for(Airport airport: airports.getAirports()){
            visited.put(airport,false);
        }
    }


    public ArrayList<FlightItinerary> DFS(Airport currentAirport, Airport finalDestination){
        ArrayList<Flight> resultFlights = new ArrayList<>();
        ArrayList<FlightItinerary> allItinerary = new ArrayList<>();
        DFSRec(currentAirport, finalDestination, resultFlights, allItinerary);
        return allItinerary;
    }

    public void DFSRec(Airport currentAirport, Airport finalDestination, ArrayList<Flight> resultFlights, ArrayList<FlightItinerary> allItinerary){

        if(visited.get(currentAirport)){
            return;
        }

        visited.put(currentAirport, true);

        if(currentAirport.equals(finalDestination)){
            System.out.println("New Itinerary");
            FlightItinerary newFlightItinerary = new FlightItinerary();
            newFlightItinerary.setFlights(resultFlights);
            allItinerary.add(newFlightItinerary);
            return;
        }

        for(Flight flight: currentAirport.getFlights()){
            System.out.println("DFS-From: "+currentAirport.getName()+" : " +" DFS-To: "+ airports.getAirport(flight.getDestinationCity()).getName());

            resultFlights.add(flight);
            DFSRec(airports.getAirport(flight.getDestinationCity()), finalDestination, resultFlights, allItinerary);

            resultFlights.remove(resultFlights.size()-1);
            visited.put(airports.getAirport(flight.getDestinationCity()), false);
        }
    }


    public static void main(String[] args){
        Endpoint.publish("http://0.0.0.0:1337/FlightItinearies", new FlightItinearies());
    }
}
