/**
 * Created by antondahlin on 2016-02-08.
 **/

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import flightitinearies.ns.*;
import flightitinearies.ns.Flight;
import flightitinearies.ns.FlightItinearies;
import flightitinearies.ns.FlightItinerary;
import mynamespace.wsdl.authservice.AuthPortType;
import mynamespace.wsdl.authservice.AuthRequest;
import mynamespace.wsdl.authservice.AuthService;


public class FlightItineariesClient {
    static Scanner scanner;
    static String auth="";
    public static void main(String[] args) {
        try {
            scanner = new Scanner(System.in);
            int input = 0;
            while(input!=9)
            {
                System.out.println("1. Authenticate.");
                System.out.println("2. Search for flights between two cities. \n3. See prices of all flights departing on a date.");
                System.out.println("4. Booking.");
                input = scanner.nextInt();
                switch(input)
                {
                    case 1:
                        AuthPortType port = (new AuthService()).getAuthPort();
<<<<<<< HEAD
//                        AuthRequest auth = new AuthRequest();
//                        auth.setArg1("webservice");
//                        auth.setArg0("password");
//                        port.authorize(auth);

=======
                        auth = port.authorize("webservice", "password");
                        System.out.println(auth);
                        System.out.println(port.authorize("Anton", "dinmama"));
>>>>>>> github1/master
                        break;
                    case 2:
                        searchFlights();
                        break;
                    case 3:
                        flightsOnDate();
                        break;
                    case 4:
                        booking();
                        break;


                    case 9:
                        System.exit(0);
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private static void booking()
    {
        System.out.println("<itinerary ID> <credit card number>");
        String in = scanner.nextLine();
        in = scanner.nextLine();
        FlightItinearies port = (new FlightItineariesService()).getFlightItineariesPort();

        String result = port.bookItinerary(Integer.parseInt(in.split(" ")[0]), Integer.parseInt(in.split(" ")[1]));
        System.out.println(result);
    }

    private static void flightsOnDate()
    {
        System.out.println("<yyyy-mm-dd>");
        String in = scanner.nextLine();
        in = scanner.nextLine();
        flightitinearies.ns.FlightItinearies port = (new FlightItineariesService()).getFlightItineariesPort();
        List<Flight> result = port.getFlightPrices(in);

        if(result.isEmpty()) {
            System.out.println("No itinerary found");
        }else{

            for(Flight fi: result) {
                System.out.println(fi.toString());
            }
        }
    }


    private static void searchFlights()
    {
        FlightItinearies port = (new FlightItineariesService()).getFlightItineariesPort();

        System.out.println("<departure city> <destination city>");
        String in = scanner.nextLine();
        in = scanner.nextLine();
        List<FlightItinerary> result = port.getFlightItinearies(in.split(" ")[0], in.split(" ")[1]);

        if(result.isEmpty()) {
            System.out.println("No itinerary found");
        }else{

            for(FlightItinerary fi: result) {
                System.out.println("[ItineraryID: "+fi.getId()+ "]\n");
                for(Flight fl: fi.getFlights()){
                    StringBuilder sb = new StringBuilder();
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    sb.append("From: "+fl.getDepartureCity()+"\n").
                            append("To: "+fl.getDestinationCity()+"\n").
                            append("Price: "+fl.getPrice()+" \nDeparture date: "+fl.getDepartureDate()+"\n").
                            append("Available seats: "+fl.getAvailableSeats()+"\n");

                    System.out.println(sb.toString()+"\n");

                }
                System.out.println("\n\n");
            }
        }
    }

}
