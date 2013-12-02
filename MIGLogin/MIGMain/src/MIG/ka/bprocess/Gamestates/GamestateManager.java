/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MIG.ka.bprocess.Gamestates;

import MIG.ka.bprocess.Common.CommonEvent;
import java.util.ArrayList;

/**
 *
 * @author Thor
 */
public class GamestateManager implements StateListener
{

    ArrayList<Gamestate> stateList = new ArrayList<Gamestate>(3);

    public GamestateManager() {
        this.addState(new GS_Stopped());
        this.initState();
    }
    
    private void addState(Gamestate state)
    {
        this.stateList.remove(state);
        this.stateList.add(state);
    }
    
    private void initState()
    {
        this.getstateListEnd().init();
    }
    
    private Gamestate getstateListEnd()
    {
        return this.stateList.get(this.stateList.size()-1);
    }
    
    private int getIndexOf(String id)
    {
        int counter = 0;
        for (Gamestate gamestate : stateList) 
        {
            if(gamestate.getId().equalsIgnoreCase(id))
            {
                return counter;
            }
            counter++;
        }
        return -1;
        
    }
    
    private void changeActiveElement(Gamestate state)
    {
        this.stateList.remove(state);
        this.stateList.add(state);
    }
    
    public void actionPerformed(StatechangeEvent event) 
    {
        int index;
        if(event.isCleanup())
        {
            this.getstateListEnd().cleanup();
            this.stateList.remove(this.getstateListEnd());
            index = -1;
        }
        else
        {
            index = getIndexOf(event.getId());
        }
        if(index == -1)
        {
            if(event.getId().equals("GS_Paused"))
            {
                this.addState(new GS_Paused());
            }
            else if(event.getId().equals("GS_Running"))
            {
                this.addState(new GS_Running());
            }
            else if(event.getId().equals("GS_Stopped"))
            {
                this.addState(new GS_Stopped());
            }
        }
        else
        {
            this.changeActiveElement(this.stateList.get(index));
        }
        this.initState();
    }

     public void actionPerformed(ExitEvent event) 
     {
        for (Gamestate gamestate : stateList) 
        {
            gamestate.cleanup();
        }
     }
    
    public void actionPerformed(CommonEvent event) 
    {
    }
}
