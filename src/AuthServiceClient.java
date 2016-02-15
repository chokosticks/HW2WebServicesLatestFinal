import wsdl.mynamespace.wsdl.authservice.AuthPortType;
import wsdl.mynamespace.wsdl.authservice.AuthService;

/**
 * Created by antondahlin on 2016-02-14.
 */



public class AuthServiceClient {

    public static void main(String[] args){
        AuthPortType port = (new AuthService()).getAuthPort();

        System.out.println(port.authorize("Anton", "password"));
    }

}
