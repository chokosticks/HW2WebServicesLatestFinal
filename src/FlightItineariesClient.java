/**
 * Created by antondahlin on 2016-02-08.
 **/

import java.util.List;
import flightitinearies.ns.*;
import flightitinearies.ns.Flight;
import flightitinearies.ns.FlightItinearies;
import flightitinearies.ns.FlightItinerary;


public class FlightItineariesClient {

    public static void main(String[] args) {
        try {

            FlightItinearies port = (new FlightItineariesService()).getFlightItineariesPort();
            List<Flight> result = port.getFlightPrices(args[0]);


//            List<FlightItinerary> result = port.getFlightItinearies(args[0], args[1]);
//
//            if(result.isEmpty()) {
//                System.out.println("No itinerary found");
//            }else{
//
//                for(FlightItinerary fi: result) {
//                    for(Flight fl: fi.getFlights()){
//                        System.out.println(fl.toString());
//                    }
//                }
//            }

            if(result.isEmpty()) {
                System.out.println("No itinerary found");
            }else{

                for(Flight fi: result) {
                        System.out.println(fi.toString());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
