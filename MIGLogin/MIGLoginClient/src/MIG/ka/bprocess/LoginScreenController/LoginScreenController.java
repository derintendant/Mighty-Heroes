/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MIG.ka.bprocess.LoginScreenController;

import MIG.ka.bprocess.LoginController.LoginEvent;
import com.jme3.app.SimpleApplication;
import com.jme3.niftygui.NiftyJmeDisplay;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.controls.TextField;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;

/**
 *
 * @author derintendant
 */
public class LoginScreenController extends SimpleApplication implements ScreenController{
    
    private Nifty nifty;
    private static  LoginScreenController app;

    public static void main(String[] args){
        app = new LoginScreenController();
        app.setPauseOnLostFocus(false);
        app.start();
    }

    
    @Override
    public void bind(Nifty nifty, Screen screen) {
	this.nifty = nifty;
    }

    @Override
    public void onStartScreen() {
    }

    @Override
    public void onEndScreen() {
    }

    @Override
    public void simpleInitApp() {
	NiftyJmeDisplay niftyDisplay = new NiftyJmeDisplay(assetManager, inputManager, audioRenderer, guiViewPort);
	nifty = niftyDisplay.getNifty();
	nifty.fromXml("Interface/LoginScreen.xml", "start", this);
	
	guiViewPort.addProcessor(niftyDisplay);
	
        flyCam.setEnabled(false);
        flyCam.setDragToRotate(true);
	inputManager.setCursorVisible(true);
    }
   
    public void quitGame() {
	app.stop();
    }
    
    public void login() {
	TextField usernameTextField = nifty.getCurrentScreen().findNiftyControl("usernameTextField", TextField.class);
	TextField passwordTextField = nifty.getCurrentScreen().findNiftyControl("usernameTextField", TextField.class);
	String enteredUsername = usernameTextField.getText();
	String enteredPassword = passwordTextField.getText();
	
	LoginEvent loginEvent = new LoginEvent(enteredUsername, enteredPassword, "1"); // Stimmt das so?
	// Hier LoginController aufrufen und Logindaten übergeben
    }
    
}
