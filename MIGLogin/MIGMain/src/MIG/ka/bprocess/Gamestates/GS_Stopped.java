/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MIG.ka.bprocess.Gamestates;

import MIG.ka.bprocess.Common.CommonEvent;
import MIG.ka.bprocess.Common.ViewProperty;
import MIG.ka.bprocess.Login.LoginEvent;
import MIG.ka.bprocess.Login.LoginListener;
import MIG.ka.bprocess.Login.Screen.LoginView;
import MIG.ka.bprocess.MainMenu.StartMultiplayerEvent;
import MIG.ka.bprocess.MainMenu.StartMultiplayerListener;
import MIG.ka.bprocess.MultiplayerGame.Game;
import MIG.ka.bprocess.Networking.NetworkingClient;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thor
 */
public class GS_Stopped extends Gamestate implements LoginListener, StartMultiplayerListener{

    
    private LoginView view;
    
    @Override
    public void actionPerformed(LoginEvent event) {
        boolean LoginSucces;
        LoginSucces = NetworkingClient.getInstance().LoginRequest(event.getName(), event.getPassword());
        if(LoginSucces)
        {
            Logger.getLogger(GS_Stopped.class.getName()).log(Level.INFO , "Username and Password accepted");
            //TODO: Mathode aufrufen, die diesen Fall behandelt
        }
        else
        {
            Logger.getLogger(GS_Stopped.class.getName()).log(Level.INFO , "Wrong Username or Password insert");
            //TODO: Mathode aufrufen, die diesen Fall behandelt
        }
    }   

    /**
     *
     * @param event
     * This Method is not used in this Application.
     * It can be used to Handle all Type of possible Events.
     */
    @Override
    public void actionPerformed(CommonEvent event) {
    }
    public GS_Stopped() 
    {
        super("GS_Stopped");
    }

    @Override
    public void init() 
    {
        view = new LoginView();
        view.setListener((LoginListener)this);
        this.startLogin();
    }

    @Override
    public void cleanup() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void startLogin() {
        ViewProperty.getInstance().setPauseOnLostFocus(false);
	ViewProperty.getInstance().start();
    }

    @Override
    public void actionPerformed(StartMultiplayerEvent event) 
    {
        //Lobby View anzeigen!!!
        //Datenmodel abfrage, welche spiele vorhanden sind!
        ArrayList<Game> games = NetworkingClient.getInstance().getAllGames();
    }
}
