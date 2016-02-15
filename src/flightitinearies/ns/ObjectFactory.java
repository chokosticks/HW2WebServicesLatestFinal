
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

    private final static QName _IssueTicketsResponse_QNAME = new QName("ns.flightItinearies", "issueTicketsResponse");
    private final static QName _DFSRecResponse_QNAME = new QName("ns.flightItinearies", "DFSRecResponse");
    private final static QName _BookItineraryResponse_QNAME = new QName("ns.flightItinearies", "bookItineraryResponse");
    private final static QName _IssueTickets_QNAME = new QName("ns.flightItinearies", "issueTickets");
    private final static QName _InitDFSVisit_QNAME = new QName("ns.flightItinearies", "initDFSVisit");
    private final static QName _BookItinerary_QNAME = new QName("ns.flightItinearies", "bookItinerary");
    private final static QName _GetFlightItinearies_QNAME = new QName("ns.flightItinearies", "getFlightItinearies");
    private final static QName _GetFlightPricesResponse_QNAME = new QName("ns.flightItinearies", "getFlightPricesResponse");
    private final static QName _DFS_QNAME = new QName("ns.flightItinearies", "DFS");
    private final static QName _InitDFSVisitResponse_QNAME = new QName("ns.flightItinearies", "initDFSVisitResponse");
    private final static QName _GetFlightPrices_QNAME = new QName("ns.flightItinearies", "getFlightPrices");
    private final static QName _DFSRec_QNAME = new QName("ns.flightItinearies", "DFSRec");
    private final static QName _GetFlightItineariesResponse_QNAME = new QName("ns.flightItinearies", "getFlightItineariesResponse");
    private final static QName _DFSResponse_QNAME = new QName("ns.flightItinearies", "DFSResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: flightitinearies.ns
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DFSResponse }
     * 
     */
    public DFSResponse createDFSResponse() {
        return new DFSResponse();
    }

    /**
     * Create an instance of {@link GetFlightItineariesResponse }
     * 
     */
    public GetFlightItineariesResponse createGetFlightItineariesResponse() {
        return new GetFlightItineariesResponse();
    }

    /**
     * Create an instance of {@link DFS }
     * 
     */
    public DFS createDFS() {
        return new DFS();
    }

    /**
     * Create an instance of {@link GetFlightItinearies }
     * 
     */
    public GetFlightItinearies createGetFlightItinearies() {
        return new GetFlightItinearies();
    }

    /**
     * Create an instance of {@link GetFlightPricesResponse }
     * 
     */
    public GetFlightPricesResponse createGetFlightPricesResponse() {
        return new GetFlightPricesResponse();
    }

    /**
     * Create an instance of {@link DFSRec }
     * 
     */
    public DFSRec createDFSRec() {
        return new DFSRec();
    }

    /**
     * Create an instance of {@link GetFlightPrices }
     * 
     */
    public GetFlightPrices createGetFlightPrices() {
        return new GetFlightPrices();
    }

    /**
     * Create an instance of {@link InitDFSVisitResponse }
     * 
     */
    public InitDFSVisitResponse createInitDFSVisitResponse() {
        return new InitDFSVisitResponse();
    }

    /**
     * Create an instance of {@link BookItineraryResponse }
     * 
     */
    public BookItineraryResponse createBookItineraryResponse() {
        return new BookItineraryResponse();
    }

    /**
     * Create an instance of {@link DFSRecResponse }
     * 
     */
    public DFSRecResponse createDFSRecResponse() {
        return new DFSRecResponse();
    }

    /**
     * Create an instance of {@link IssueTicketsResponse }
     * 
     */
    public IssueTicketsResponse createIssueTicketsResponse() {
        return new IssueTicketsResponse();
    }

    /**
     * Create an instance of {@link BookItinerary }
     * 
     */
    public BookItinerary createBookItinerary() {
        return new BookItinerary();
    }

    /**
     * Create an instance of {@link InitDFSVisit }
     * 
     */
    public InitDFSVisit createInitDFSVisit() {
        return new InitDFSVisit();
    }

    /**
     * Create an instance of {@link IssueTickets }
     * 
     */
    public IssueTickets createIssueTickets() {
        return new IssueTickets();
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
     * Create an instance of {@link Airport }
     * 
     */
    public Airport createAirport() {
        return new Airport();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IssueTicketsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "ns.flightItinearies", name = "issueTicketsResponse")
    public JAXBElement<IssueTicketsResponse> createIssueTicketsResponse(IssueTicketsResponse value) {
        return new JAXBElement<IssueTicketsResponse>(_IssueTicketsResponse_QNAME, IssueTicketsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DFSRecResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "ns.flightItinearies", name = "DFSRecResponse")
    public JAXBElement<DFSRecResponse> createDFSRecResponse(DFSRecResponse value) {
        return new JAXBElement<DFSRecResponse>(_DFSRecResponse_QNAME, DFSRecResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookItineraryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "ns.flightItinearies", name = "bookItineraryResponse")
    public JAXBElement<BookItineraryResponse> createBookItineraryResponse(BookItineraryResponse value) {
        return new JAXBElement<BookItineraryResponse>(_BookItineraryResponse_QNAME, BookItineraryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IssueTickets }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "ns.flightItinearies", name = "issueTickets")
    public JAXBElement<IssueTickets> createIssueTickets(IssueTickets value) {
        return new JAXBElement<IssueTickets>(_IssueTickets_QNAME, IssueTickets.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InitDFSVisit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "ns.flightItinearies", name = "initDFSVisit")
    public JAXBElement<InitDFSVisit> createInitDFSVisit(InitDFSVisit value) {
        return new JAXBElement<InitDFSVisit>(_InitDFSVisit_QNAME, InitDFSVisit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookItinerary }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "ns.flightItinearies", name = "bookItinerary")
    public JAXBElement<BookItinerary> createBookItinerary(BookItinerary value) {
        return new JAXBElement<BookItinerary>(_BookItinerary_QNAME, BookItinerary.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlightItinearies }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "ns.flightItinearies", name = "getFlightItinearies")
    public JAXBElement<GetFlightItinearies> createGetFlightItinearies(GetFlightItinearies value) {
        return new JAXBElement<GetFlightItinearies>(_GetFlightItinearies_QNAME, GetFlightItinearies.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlightPricesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "ns.flightItinearies", name = "getFlightPricesResponse")
    public JAXBElement<GetFlightPricesResponse> createGetFlightPricesResponse(GetFlightPricesResponse value) {
        return new JAXBElement<GetFlightPricesResponse>(_GetFlightPricesResponse_QNAME, GetFlightPricesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DFS }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "ns.flightItinearies", name = "DFS")
    public JAXBElement<DFS> createDFS(DFS value) {
        return new JAXBElement<DFS>(_DFS_QNAME, DFS.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InitDFSVisitResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "ns.flightItinearies", name = "initDFSVisitResponse")
    public JAXBElement<InitDFSVisitResponse> createInitDFSVisitResponse(InitDFSVisitResponse value) {
        return new JAXBElement<InitDFSVisitResponse>(_InitDFSVisitResponse_QNAME, InitDFSVisitResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlightPrices }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "ns.flightItinearies", name = "getFlightPrices")
    public JAXBElement<GetFlightPrices> createGetFlightPrices(GetFlightPrices value) {
        return new JAXBElement<GetFlightPrices>(_GetFlightPrices_QNAME, GetFlightPrices.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DFSRec }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "ns.flightItinearies", name = "DFSRec")
    public JAXBElement<DFSRec> createDFSRec(DFSRec value) {
        return new JAXBElement<DFSRec>(_DFSRec_QNAME, DFSRec.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link DFSResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "ns.flightItinearies", name = "DFSResponse")
    public JAXBElement<DFSResponse> createDFSResponse(DFSResponse value) {
        return new JAXBElement<DFSResponse>(_DFSResponse_QNAME, DFSResponse.class, null, value);
    }

}
