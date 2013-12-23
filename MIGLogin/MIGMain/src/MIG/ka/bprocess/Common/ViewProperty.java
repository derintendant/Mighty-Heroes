/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MIG.ka.bprocess.Common;

import MIG.ka.bprocess.Login.Screen.LoginView;
import MIG.ka.bprocess.MainMenu.Screen.MainMenuView;
import MIG.ka.bprocess.MultiplayerLobby.Screen.LobbyView;
import com.jme3.app.SimpleApplication;
import com.jme3.niftygui.NiftyJmeDisplay;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.controls.NiftyControl;

/**
 *
 * @author Thomas
 */
public class ViewProperty extends SimpleApplication
{
    private static ViewProperty instance = null;
    private Nifty nifty;
    private LoginView loginScreen;
    private MainMenuView mainMenuScreen;
    private LobbyView lobbyScreen;
    
    public void setLoginScreen(LoginView loginScreen) 
    {
        this.loginScreen = loginScreen;
    }
    
    public void setMainMenuScreen(MainMenuView mainMenuScreen)
    {
        this.mainMenuScreen = mainMenuScreen;
    }
    
    public void setLobbyScreen(LobbyView lobbyScreen)
    {
        this.lobbyScreen = lobbyScreen;
    }
    
//    public void setLobbyScreen(LobbyView lobbyScreen)
//    {
//        nifty.registerScreenController(lobbyScreen);
//    }
//    
//    public void setMainMenuScreen(MainMenuView mainMenuScreen)
//    {
//        nifty.registerScreenController(mainMenuScreen);
//    }
    
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
        nifty.registerScreenController(loginScreen);
        nifty.registerScreenController(mainMenuScreen);
        nifty.registerScreenController(lobbyScreen);
	nifty.addXml("Interface/LoginScreen.xml");
	nifty.addXml("Interface/MenuScreen.xml");
	nifty.addXml("Interface/LobbyScreen.xml");
	nifty.gotoScreen("login");
	guiViewPort.addProcessor(niftyDisplay);
	
        flyCam.setEnabled(false);
        flyCam.setDragToRotate(true);
	inputManager.setCursorVisible(true);
    }

    public <T extends NiftyControl> T findNiftyControl(String elementName, Class requested)
    {
        return (T) this.nifty.getCurrentScreen().findNiftyControl(elementName, requested);
    }
    
    public void gotoScreen(String screenId)
    {
        nifty.gotoScreen(screenId);
    }
}
