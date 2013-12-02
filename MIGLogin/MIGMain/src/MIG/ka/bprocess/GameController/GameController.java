/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MIG.ka.bprocess.GameController;

import MIG.ka.bprocess.Login.Screen.LoginView;

/**
 *
 * @author derintendant
 */
public class GameController {
    
    LoginView login;

    public GameController() {
	login = new LoginView();
    }
    
    public void startLogin() {
	login.setPauseOnLostFocus(false);
	login.start();
    }
    
    
}
