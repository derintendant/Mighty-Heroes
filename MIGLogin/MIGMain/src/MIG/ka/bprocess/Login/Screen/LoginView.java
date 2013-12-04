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

/**
 *
 * @author derintendant
 */
public class LoginView implements ScreenController
{
    
    private ArrayList<CommonListener> listeners = new ArrayList<>();
    private LoginListener listener;
    private int id;

    public LoginView() {
    }
    
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
            String enteredUsername = usernameTextField.getRealText();
            String enteredPassword = passwordTextField.getRealText();
            
            firePropertyChange(new LoginEvent(enteredUsername, enteredPassword, "loginButtonClick"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    
    
    public void addListener(CommonListener listener) 
    {
        id++;
	this.listeners.add(listener);
        this.listener = (LoginListener)listener;
    }

    @Override
    public void bind(Nifty nifty, Screen screen) 
    {
//        ViewProperty.getInstance().setNifty(nifty);
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
            tmpListener.actionPerformed(property);
        }
        this.listener.actionPerformed(property);
    }
}
