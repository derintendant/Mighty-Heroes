/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameController;

import MIG.ka.bprocess.LoginScreenController.LoginScreenController;
import com.jme3.app.SimpleApplication;
import com.jme3.niftygui.NiftyJmeDisplay;

/**
 *
 * @author derintendant
 */
public class GameController extends SimpleApplication {
    

    @Override
    public void simpleInitApp() {
	LoginScreenController login = new LoginScreenController();
	login.simpleInitApp();
    }

    public void startGame(LoginScreenController login) {
	this.simpleInitApp();
    }
    
}
