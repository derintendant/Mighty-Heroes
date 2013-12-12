/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MIG.ka.bprocess.Common;

import MIG.ka.bprocess.Login.Screen.LoginView;
import com.jme3.app.SimpleApplication;
import com.jme3.niftygui.NiftyJmeDisplay;
import de.lessvoid.nifty.Nifty;

/**
 *
 * @author Thomas
 */
public class ViewProperty extends SimpleApplication
{
    private static ViewProperty instance = null;
    private Nifty nifty;
    private LoginView view;

    public void setView(LoginView view) {
        this.view = view;
    }
    private ViewProperty() 
    {
    }
    
    public static ViewProperty getInstance()
    {
        if(instance == null)
        {
            instance = new ViewProperty();
        }
        return instance;
    }
    
     @Override
    public void simpleInitApp() {
	NiftyJmeDisplay niftyDisplay = new NiftyJmeDisplay(assetManager, inputManager, audioRenderer, guiViewPort);
	nifty = niftyDisplay.getNifty();
        nifty.registerScreenController(view);
	nifty.addXml("Interface/LoginScreen.xml");
	nifty.addXml("Interface/MenuScreen.xml");
	nifty.addXml("Interface/LobbyScreen.xml");
	nifty.gotoScreen("login");
	
	// Quick Hack to add Demo items to the ListBox
//	nifty.gotoScreen("lobby");
//	ListBox listBox = nifty.getCurrentScreen().findNiftyControl("GamesListBox", ListBox.class);
//	listBox.addItem("Game 1");
//	listBox.addItem("Game 2");
//	listBox.addItem("Game 3");
	guiViewPort.addProcessor(niftyDisplay);
	
        flyCam.setEnabled(false);
        flyCam.setDragToRotate(true);
	inputManager.setCursorVisible(true);
    }

    public Nifty getNifty()
    {
        return this.nifty;
    }
    
    public void gotoScreen(String screenId)
    {
        nifty.gotoScreen(screenId);
    }
    
    public void setNifty(Nifty nifty)
    {
        this.nifty = nifty;
    }
}
