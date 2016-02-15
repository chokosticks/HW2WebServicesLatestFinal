/**
 * Created by antondahlin on 2016-02-08.
 **/

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import flightitinearies.ns.*;
import flightitinearies.ns.Flight;
import flightitinearies.ns.FlightItinearies;
import flightitinearies.ns.FlightItinerary;


public class FlightItineariesClient {

    public static void main(String[] args) {
        try {

            FlightItinearies port = (new FlightItineariesService()).getFlightItineariesPort();



            List<FlightItinerary> result = port.getFlightItinearies(args[0], args[1]);

            if(result.isEmpty()) {
                System.out.println("No itinerary found");
            }else{

                for(FlightItinerary fi: result) {
                    System.out.println("[Itinerary]\n");
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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
