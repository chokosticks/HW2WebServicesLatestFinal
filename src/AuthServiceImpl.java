import mynamespace.wsdl.authservice.AuthPortType;
import mynamespace.wsdl.authservice.AuthRequest;
import mynamespace.wsdl.authservice.AuthResponse;
import mynamespace.wsdl.authservice.AuthService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import javax.xml.ws.WebServiceProvider;


/**
 * Created by antondahlin on 2016-02-15.
 */


public class AuthServiceImpl implements AuthPortType{

    private static String userName = "webservice";
    private static String password = "password";



    @Override
    public AuthResponse authorize(AuthRequest request) {
        AuthResponse resp = new AuthResponse();

        if(request.getArg0().equals(this.userName) && request.getArg1().equals(this.password)){
            resp.setReturn("ABCJL8769xzvf");
        }
        resp.setReturn("wrong credentials");

        return resp;
    }

    public static void main(String[] args){
        Endpoint.publish("http://0.0.0.0:1337/Authroize", new AuthService());
    }
}
