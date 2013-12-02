/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MIG.ka.bprocess.MultiplayerLobbyModel;

import MIG.ka.bprocess.MultiplayerGame.Game;
import java.util.ArrayList;

/**
 *
 * @author Thomas
 */
public class LobbyModel {

    static LobbyModel instance = null;
    
    ArrayList<Game> gamesInLobby = new ArrayList<>();
    
    private LobbyModel() 
    {
    }
    
    public static LobbyModel getInstance()
    {
        if(instance == null)
        {
            instance = new LobbyModel();
        }
        return instance;
    }
    
    public Game getGameByUserName(String user)
    {
        for (Game actualGame : gamesInLobby) 
        {
            if(actualGame.checkGame(user))
            {
                return actualGame;
            }
        }
        return null;
    }
    
    public void addGame(Game game)
    {
        this.gamesInLobby.add(game);
    }
    
    public ArrayList<Game> getAllGames()
    {
        return this.gamesInLobby;
    }
}
