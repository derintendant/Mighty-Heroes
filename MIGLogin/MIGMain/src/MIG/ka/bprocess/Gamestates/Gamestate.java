/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MIG.ka.bprocess.Gamestates;

/**
 *
 * @author Thor
 */
public abstract class Gamestate {
    
    protected String id;
    protected StateListener listener;

    public Gamestate(String id) {
        this.id = id;
    }
    
    public String getId()
    {
        return this.id;
    }
    
    public void setListener(StateListener listener)
    {
        this.listener = listener;
    }
    
    abstract public void init(); 
    abstract public void cleanup();
}
