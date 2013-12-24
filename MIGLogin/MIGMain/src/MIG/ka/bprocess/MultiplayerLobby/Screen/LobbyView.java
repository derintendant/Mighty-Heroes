/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MIG.ka.bprocess.MultiplayerLobby.Screen;

import MIG.ka.bprocess.Common.CommonEvent;
import MIG.ka.bprocess.Common.CommonListener;
import MIG.ka.bprocess.Common.ViewProperty;
import MIG.ka.bprocess.MultiplayerGame.CreateGameEvent;
import MIG.ka.bprocess.MultiplayerGame.CreateGameListener;
import MIG.ka.bprocess.MultiplayerGame.JoinGameEvent;
import MIG.ka.bprocess.MultiplayerGame.JoinGameListener;
import MIG.ka.bprocess.MultiplayerGame.LeaveLobbyEvent;
import MIG.ka.bprocess.MultiplayerGame.LeaveLobbyListener;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.NiftyEventSubscriber;
import de.lessvoid.nifty.controls.ListBoxSelectionChangedEvent;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thomas
 */
public class LobbyView implements ScreenController
{
     private final ArrayList<CommonListener> listeners = new ArrayList<>();
     private String selection = null;

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
        firePropertyChange(new CreateGameEvent("CreateGame"));
    }
    
    public void joinGame()
    {
        firePropertyChange(new JoinGameEvent("JoinGame", this.selection));
    }
    
    public void leaveLobby()
    {
        firePropertyChange(new LeaveLobbyEvent("LeaveLobby"));
    }
    
    public void addListener(CommonListener listener) 
    {
	this.listeners.add(listener);
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
   
    public void firePropertyChange(CommonEvent property)
    {
        for (CommonListener tmpListener : listeners) 
        {
            if(tmpListener instanceof JoinGameListener && property instanceof JoinGameEvent)
            {
                ((JoinGameListener)tmpListener).actionPerformed((JoinGameEvent)property);
            }
            else if(tmpListener instanceof CreateGameListener && property instanceof CreateGameEvent)
            {
                ((CreateGameListener)tmpListener).actionPerformed((CreateGameEvent)property);
            }
            else if(tmpListener instanceof LeaveLobbyListener && property instanceof LeaveLobbyEvent)
            {
                ((LeaveLobbyListener)tmpListener).actionPerformed((LeaveLobbyEvent)property);
            }
        }
    }
    
    @NiftyEventSubscriber(id="GamesListBox")
    public void onMyListBoxSelectionChanged(final String id, final ListBoxSelectionChangedEvent<String> event) 
    {
        List<String> selection = event.getSelection();
        for (String selectedItem : selection) 
        {
            this.selection = selectedItem;
        }
    }
}
