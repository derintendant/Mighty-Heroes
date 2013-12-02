/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MIG.ka.bprocess.Networking.Handler;

import MIG.ka.bprocess.LoginModel.LoginModel;
import java.util.ArrayList;

/**
 *
 * @author Thor
 */
public class MigXmlRpcLoginHandler {

    public MigXmlRpcLoginHandler() {
    }

    /**
     * for testing purpose it is one user and password hard coded here.
     * This will be changed in the Demo Version.
     * The username is case insensitiv so "HANS" equals "hans"
     * @param username the name of the user that wants to login
     * @param password the password the user handed in
     * @return true if user name and password match each other in the Database.
     */
    public boolean checkLogindata(String username , String password)
    {
//        return LoginModel.checkLogindata(username, password);
        return username.equalsIgnoreCase("hans") && password.equals("wurst");
    }
}
