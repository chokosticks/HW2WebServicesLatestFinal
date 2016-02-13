import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.ArrayList;
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


        airports.printAirports();


        ArrayList<FlightItinerary> result = new ArrayList<FlightItinerary>();

        if(!airports.airportExists(destinationCity) || !airports.airportExists(departureCity)) {
            System.out.println("Non existing airport specified");
            return result;
        }

        Airport finalDestination = airports.getAirport(destinationCity);
        Airport departureAirport = airports.getAirport(departureCity);

//        initDFSVisit();
//
//        System.out.println("Departure: "+departureCity);
//        for(Flight flight: departureAirport.getFlights()){
//            System.out.println("[info]"+flight.getPrice());
//        }
//
//        DFS(departureAirport, departureAirport.getFlights(), finalDestination);


//        ArrayList<Flight> resultSet = new ArrayList<Flight>();
//        this.finalDestination = destinationCity;
//        for(Flight fi: flights) {
//            visited.put(fi.getDepartureCity(), false);
//            if (fi.getDepartureCity().equals(departureCity) && fi.getDestinationCity().equals(destinationCity)) {
//                resultSet.add(fi);
//                return resultSet;
//            }
//        }
//        DFS(adjacentMatrix, visited, departureCity);
//        return resultSet;

        return itineraries;
    }

    public void initDFSVisit(){
        for(Airport airport: airports.getAirports()){
            visited.put(airport,false);
        }
    }




    public void DFS(Airport currentAirport, ArrayList<Flight> flights, Airport finalDestination){
        visited.put(currentAirport, true);
        System.out.println("From: "+currentAirport.getName());
        System.out.println(currentAirport.getFlights().size());



        for(Flight flight: currentAirport.getFlights()){
            Airport newCurrentAirport = airports.getAirport(flight.getDestinationCity());
            System.out.println("FromMM: "+currentAirport.getName()+" -To: "+ newCurrentAirport.getName());
            if(!visited.get(newCurrentAirport))
                DFS(newCurrentAirport, newCurrentAirport.getFlights(), finalDestination);
        }
//
////        visited.put(current, true);
////        ArrayList<String> neighbours = adj.get(current);
////
////        for(String neighbour: neighbours) {
////            Stack<String> temp = new Stack<String>();
////            System.out.println("current: " + current + " neigbour: " + neighbour);
////
////            if(!adj.containsKey(neighbour))
////                continue;
////
////            if (!visited.get(neighbour) && !neighbour.equals(finalDestination) && adj.containsKey(neighbour)) {
////                temp.push(current);
////                DFS(adj, visited, neighbour);
////
////            } else if(neighbour.equals(finalDestination)) {
////                System.out.println("I FOUND:"+finalDestination);
////                while(!temp.isEmpty()){
////                    System.out.println(temp.pop());
////
////                }
////                System.out.println("INside else if");
////                visited.put(current, true);
////
////            }
////        }
    }


    public static void main(String[] args){
        Endpoint.publish("http://0.0.0.0:1337/FlightItinearies", new FlightItinearies());
    }
}
