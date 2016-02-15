import wsdl.mynamespace.wsdl.authservice.AuthPortType;
import wsdl.mynamespace.wsdl.authservice.AuthService;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by antondahlin on 2016-02-15.
 */

public class AuthServiceImpl implements AuthPortType {

    private String userName = "webservice";
    private String password = "password";

    @Override
    public String authorize(String userName, String password) {
        if(userName.equals(this.userName) && password.equals(this.password)){
            return "ABCJL8769xzvf";
        }
        return "wrong credentials";
    }
}
