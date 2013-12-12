/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MIG.ka.bprocess.MainMenu.Screen;

import MIG.ka.bprocess.Common.ViewProperty;
import MIG.ka.bprocess.MainMenu.StartMultiplayerListener;
import com.jme3.app.SimpleApplication;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;

/**
 *
 * @author Thomas
 */
public class MainMenuView implements  ScreenController
{
     private StartMultiplayerListener multiplayerListener;
    
    
    public void initView() 
    {
        ViewProperty.getInstance().gotoScreen("menu");
	
    }
    
    public void startMultiplayer() 
    {
    }
    
    public void setListener(StartMultiplayerListener multiplayerListener) {
	this.multiplayerListener = multiplayerListener;
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
