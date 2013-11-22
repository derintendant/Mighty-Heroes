/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MIG.ka.bprocess.LoginController;

import MIG.ka.bprocess.Networking.NetworkingClient;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thomas
 */
public class LoginController implements LoginListener{

    @Override
    public void actionPerformed(LoginEvent event) {
        boolean LoginSucces;
        LoginSucces = NetworkingClient.getInstance().LoginRequest(event.getName(), event.getPassword());
        if(LoginSucces)
        {
            Logger.getLogger(LoginController.class.getName()).log(Level.INFO , "Username and Password accepted");
            //TODO: Mathode aufrufen, die diesen Fall behandelt
        }
        else
        {
            Logger.getLogger(LoginController.class.getName()).log(Level.INFO , "Wrong Username or Password insert");
            //TODO: Mathode aufrufen, die diesen Fall behandelt
        }
    }   

    /**
     *
     * @param event
     * This Method is not used in this Application.
     * It can be used to Handle all Type of possible Events.
     */
    @Override
    public void actionPerformed(CommonEvent event) {
    }
}
