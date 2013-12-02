/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MIG.ka.bprocess.GameController;

import MIG.ka.bprocess.LoginScreenController.LoginScreenController;

/**
 *
 * @author derintendant
 */
public class GameController {
    
    LoginScreenController login;

    public GameController() {
	login = new LoginScreenController();
    }
    
    public void startLogin() {
	login.setPauseOnLostFocus(false);
	login.start();
    }
    
    
}
