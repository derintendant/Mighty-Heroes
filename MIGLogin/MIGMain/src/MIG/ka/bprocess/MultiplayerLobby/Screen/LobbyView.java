/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MIG.ka.bprocess.MultiplayerLobby.Screen;

import MIG.ka.bprocess.Common.ViewProperty;
import MIG.ka.bprocess.MainMenu.StartMultiplayerListener;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;

/**
 *
 * @author Thomas
 */
public class LobbyView implements ScreenController
{
    private StartMultiplayerListener multiplayerListener;

    public LobbyView() 
    {
//        ViewProperty.getInstance().setLobbyScreen(this);
    }
    
    public void initView() 
    {
        ViewProperty.getInstance().gotoScreen("lobby");
	
    }
    
    public void createGame() 
    {
    }
    
    public void joinGame()
    {
    }
    
    public void leaveLobby()
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
