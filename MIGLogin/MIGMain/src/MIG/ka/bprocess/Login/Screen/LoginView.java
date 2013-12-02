/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MIG.ka.bprocess.Login.Screen;

import MIG.ka.bprocess.Common.ViewProperty;
import MIG.ka.bprocess.Login.LoginEvent;
import MIG.ka.bprocess.Login.LoginListener;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.controls.TextField;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;

/**
 *
 * @author derintendant
 */
public class LoginView implements ScreenController
{
    
    private LoginListener loginListener;
    
    public void quitGame() {
	System.out.println("Quitting Game");
	       ViewProperty.getInstance().stop();
    }
    
    public void login() 
    {
        try
        {
            System.out.println("Login started");
            TextField usernameTextField = ViewProperty.getInstance().getNifty().getCurrentScreen().findNiftyControl("usernameTextField", TextField.class);
            TextField passwordTextField = ViewProperty.getInstance().getNifty().getCurrentScreen().findNiftyControl("passwordTextField", TextField.class);
            String enteredUsername = usernameTextField.getText();
            String enteredPassword = passwordTextField.getText();

            LoginEvent loginEvent = new LoginEvent(enteredUsername, enteredPassword, "loginButtonClick");

            loginListener.actionPerformed(loginEvent);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    
    
    public void setListener(LoginListener loginListener) {
	this.loginListener = loginListener;
    }

    @Override
    public void bind(Nifty nifty, Screen screen) {
    }

    @Override
    public void onStartScreen() {
    }

    @Override
    public void onEndScreen() {
    }
    
}
