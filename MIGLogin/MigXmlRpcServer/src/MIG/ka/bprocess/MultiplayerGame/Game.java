/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MIG.ka.bprocess.MultiplayerGame;

import MIG.ka.bprocess.LoginModel.LoginModel;
import MIG.ka.bprocess.LoginModel.Session;
import java.util.ArrayList;

/**
 *
 * @author Thomas
 */
public class Game
{
    ArrayList<Session> sessionsByID = new ArrayList<>(2);

    public String getOwnerSessionID()
    {
        return this.sessionsByID.get(0).getSessionID();
    }
    
    public Game(String sessionID)
    {
        Session session = LoginModel.getInstance().getSessionByID(sessionID);
        if(session != null)
        {
            this.sessionsByID.add(session);
        }
    }
    
    public boolean addUser(String sessionID)
    {
        Session session = LoginModel.getInstance().getSessionByID(sessionID);
        if(session != null)
        {
            if(this.sessionsByID.size() <= 1)
            {
                if(!checkGame(sessionID))
                {
                    this.sessionsByID.add(session);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean checkGame(String sessionID)
    {
        Session session = LoginModel.getInstance().getSessionByID(sessionID);
        if(session != null)
        {
            for (Session actualUser : sessionsByID) {
                if(actualUser == session)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
