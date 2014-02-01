/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MIG.ka.bprocess.MultiplayerGame;

import MIG.ka.bprocess.Common.CommonEvent;

/**
 *
 * @author Thomas
 */
public class JoinGameEvent extends CommonEvent
{
    String ownerSessionID;

    public JoinGameEvent(String id , String ownerSessionID) 
    {
        super(id);
        this.ownerSessionID = ownerSessionID;
    }
    
    public String getOwnerSessionID()
    {
        return this.ownerSessionID;
    }
}
