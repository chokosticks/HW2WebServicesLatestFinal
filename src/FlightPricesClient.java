import flightitinearies.ns.*;
import flightitinearies.ns.Flight;

import java.util.List;

/**
 * Created by Rickard on 2016-02-13.
 */
public class FlightPricesClient
{
    public static void main(String[] args) {
        flightitinearies.ns.FlightItinearies port = (new FlightItineariesService()).getFlightItineariesPort();
        List<Flight> result = port.getFlightPrices(args[0]);

        if(result.isEmpty()) {
            System.out.println("No itinerary found");
        }else{

            for(Flight fi: result) {
                System.out.println(fi.toString());
            }
        }

    }
}
