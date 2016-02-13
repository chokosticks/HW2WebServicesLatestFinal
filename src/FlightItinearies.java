import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;


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

        for(Flight flight: departureAirport.getFlights()){

        }




        ArrayList<Airport> resultAirport = DFSIterative(departureAirport, finalDestination);

        for(Airport airport: resultAirport){
            System.out.println(airport.getName());
        }



        return itineraries;
    }

    public void initDFSVisit(){
        for(Airport airport: airports.getAirports()){
            visited.put(airport,false);
        }
    }

    public ArrayList<Airport> DFSIterative(Airport currentAirport, Airport finalDestination){

        Stack<Airport> stack = new Stack<Airport>();
        ArrayList<Airport> result = new ArrayList<Airport>();
        boolean stop = false;

        stack.push(currentAirport);
        while(!stack.isEmpty() && !stop){
            Airport airport = stack.pop();
            System.out.println(airport.getName());

            if(!visited.get(airport)){
                visited.put(airport, true);

                for(Flight flight: airport.getFlights()){
                    System.out.println("flight: "+flight.getDepartureCity()+" -> "+flight.getDestinationCity());
                    stack.push(airports.getAirport(flight.getDestinationCity()));
                    if(airport.getName().equals(flight.getDestinationCity()))
                        stop = true;
                }
            }
//            if(airport.getName().equals(finalDestination.getName()))
//                break;

        }

        while(!stack.isEmpty()){
            Airport temp = stack.pop();
            result.add(temp);
        }
        result.add(currentAirport);

        return result;
    }


//            1  procedure DFS-iterative(G,v):
//            2      let S be a stack
//            3      S.push(v)
//            4      while S is not empty
//            5            v = S.pop()
//            6            if v is not labeled as discovered:
//            7                label v as discovered
//            8                for all edges from v to w in G.adjacentEdges(v) do
//            9                    S.push(w)



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
