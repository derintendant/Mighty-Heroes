/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MIG.ka.bprocess.Networking.Handler;

import MIG.ka.bprocess.MultiplayerGame.Game;
import MIG.ka.bprocess.MultiplayerLobbyModel.LobbyModel;
import java.util.ArrayList;

/**
 *
 * @author Thomas
 */
public class MigXmlRpcLobbyHandler 
{
    public void addGame(String user)
    {
        LobbyModel.getInstance().addGame(new Game(user));
    }
    
     public Game getGameByUserName(String user)
     {
         return LobbyModel.getInstance().getGameByUserName(user);
     }
     
     public boolean addUser(String gameOwner, String user)
     {
         Game game = getGameByUserName(gameOwner);
         if(game != null)
         {
             return game.addUser(user);
         }
         return false;
     }
    
     public ArrayList<Game> getAllGames()
     {
         return LobbyModel.getInstance().getAllGames();
     }
             
             
    
}
