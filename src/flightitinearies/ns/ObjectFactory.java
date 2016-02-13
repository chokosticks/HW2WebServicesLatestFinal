
package flightitinearies.ns;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the flightitinearies.ns package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetFlightItineariesResponse_QNAME = new QName("ns.flightItinearies", "getFlightItineariesResponse");
    private final static QName _GetFlightItinearies_QNAME = new QName("ns.flightItinearies", "getFlightItinearies");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: flightitinearies.ns
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetFlightItinearies }
     * 
     */
    public GetFlightItinearies createGetFlightItinearies() {
        return new GetFlightItinearies();
    }

    /**
     * Create an instance of {@link GetFlightItineariesResponse }
     * 
     */
    public GetFlightItineariesResponse createGetFlightItineariesResponse() {
        return new GetFlightItineariesResponse();
    }

    /**
     * Create an instance of {@link Flight }
     * 
     */
    public Flight createFlight() {
        return new Flight();
    }

    /**
     * Create an instance of {@link FlightItinerary }
     * 
     */
    public FlightItinerary createFlightItinerary() {
        return new FlightItinerary();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlightItineariesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "ns.flightItinearies", name = "getFlightItineariesResponse")
    public JAXBElement<GetFlightItineariesResponse> createGetFlightItineariesResponse(GetFlightItineariesResponse value) {
        return new JAXBElement<GetFlightItineariesResponse>(_GetFlightItineariesResponse_QNAME, GetFlightItineariesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlightItinearies }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "ns.flightItinearies", name = "getFlightItinearies")
    public JAXBElement<GetFlightItinearies> createGetFlightItinearies(GetFlightItinearies value) {
        return new JAXBElement<GetFlightItinearies>(_GetFlightItinearies_QNAME, GetFlightItinearies.class, null, value);
    }

}
