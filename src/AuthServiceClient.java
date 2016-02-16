//import wsdl.mynamespace.wsdl.authservice.AuthPortType;
//import wsdl.mynamespace.wsdl.authservice.AuthService;

import mynamespace.wsdl.authservice.AuthPortType;
import mynamespace.wsdl.authservice.AuthRequest;
import mynamespace.wsdl.authservice.AuthService;


/**
 * Created by antondahlin on 2016-02-14.
 */



public class AuthServiceClient {

    public static void main(String[] args){
        AuthPortType port = (new AuthService()).getAuthPort();
        AuthRequest auth = new AuthRequest();
        auth.setArg0("webservice");
        auth.setArg1("password");

        System.out.println(port.authorize(auth));
    }
}
