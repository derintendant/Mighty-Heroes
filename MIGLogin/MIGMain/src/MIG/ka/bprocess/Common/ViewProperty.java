/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MIG.ka.bprocess.Common;

import com.jme3.app.SimpleApplication;
import com.jme3.niftygui.NiftyJmeDisplay;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;

/**
 *
 * @author Thomas
 */
public class ViewProperty extends SimpleApplication implements ScreenController
{
    private static ViewProperty instance = null;
    private Nifty nifty;
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
	nifty.addXml("Interface/LoginScreen.xml");
	nifty.addXml("Interface/MenuScreen.xml");
	nifty.addXml("Interface/LobbyScreen.xml");
//	nifty.gotoScreen("login");
//        nifty.gotoScreen("menu");
        nifty.gotoScreen("lobby");
	guiViewPort.addProcessor(niftyDisplay);
	
        flyCam.setEnabled(false);
        flyCam.setDragToRotate(true);
	inputManager.setCursorVisible(true);
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

    public Nifty getNifty()
    {
        return this.nifty;
    }
    
    public void gotoScreen(String screenId)
    {
        nifty.gotoScreen(screenId);
    }
}
