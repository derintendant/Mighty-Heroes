/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MIG.ka.bprocess.GameController;

import MIG.ka.bprocess.LoginController.CommonEvent;

/**
 *
 * @author Thor
 */
public class StatechangeEvent extends CommonEvent{

    private final Gamestate aim;
    private final boolean cleanup;

    public StatechangeEvent(Gamestate aim, boolean cleanup, String id) {
        super(id);
        this.aim = aim;
        this.cleanup = cleanup;
    }
    
    public Gamestate getInitiator()
    {
        return this.aim;
    }
    
    public boolean  isCleanup()
    {
        return this.cleanup;
    }            
    
}
