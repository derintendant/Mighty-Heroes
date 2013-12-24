/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MIG.ka.bprocess.Networking.Handler;

import MIG.ka.bprocess.LoginModel.LoginModel;
import MIG.ka.bprocess.MultiplayerGame.Game;
import MIG.ka.bprocess.MultiplayerLobbyModel.LobbyModel;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Thomas
 */
public class MigXmlRpcLobbyHandler 
{
    public boolean addGame(String sessionID)
    {
        LobbyModel.getInstance().addGame(new Game(sessionID));
        return true;
    }
     
    public boolean addUser(String ownerSessionID, String sessionID)
    {
        Game game = LobbyModel.getInstance().getGameBySessionID(ownerSessionID);
        if(game != null)
        {
            return game.addUser(sessionID);
        }
        return false;
    }
    
    public ArrayList<String> getAllGames(String sessionID)
    {
        ArrayList<String> result = new ArrayList<>();
        if(LoginModel.getInstance().checkSession(sessionID))
        {
            for (Game game : LobbyModel.getInstance().getAllGames()) {
                result.add(game.getOwnerSessionID());
            }
        }
        return result;
     }
}
