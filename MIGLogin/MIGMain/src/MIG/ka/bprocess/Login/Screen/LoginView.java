/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MIG.ka.bprocess.Login.Screen;

import MIG.ka.bprocess.Common.CommonListener;
import MIG.ka.bprocess.Common.ViewProperty;
import MIG.ka.bprocess.Login.LoginEvent;
import MIG.ka.bprocess.Login.LoginListener;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.controls.TextField;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author derintendant
 */
public class LoginView implements ScreenController
{
    
    private final ArrayList<CommonListener> listeners = new ArrayList<>();

    public LoginView() {
    }
    
    public void quitGame() 
    {
        Logger.getLogger(LoginView.class.getName()).log(Level.INFO , "Quitting Game");
        ViewProperty.getInstance().stop();
    }
    
    public void login() 
    {
        Logger.getLogger(LoginView.class.getName()).log(Level.INFO , "Login started");
        TextField usernameTextField = ViewProperty.getInstance().findNiftyControl("usernameTextField", TextField.class);
        TextField passwordTextField = ViewProperty.getInstance().findNiftyControl("passwordTextField", TextField.class);
        String enteredUsername = usernameTextField.getRealText();
        String enteredPassword = passwordTextField.getRealText();
        
        firePropertyChange(new LoginEvent(enteredUsername, enteredPassword, "loginButtonClick"));
    }
    
    
    
    
    public void addListener(CommonListener listener) 
    {
	this.listeners.add(listener);
    }

    @Override
    public void bind(Nifty nifty, Screen screen) 
    {
    }

    @Override
    public void onStartScreen() {
    }

    @Override
    public void onEndScreen() {
    }
    
    public void firePropertyChange(LoginEvent property)
    {
        for (CommonListener tmpListener : listeners) 
        {
            if(tmpListener instanceof LoginListener)
            {
                ((LoginListener)tmpListener).actionPerformed(property);
            }
        }
    }
}
