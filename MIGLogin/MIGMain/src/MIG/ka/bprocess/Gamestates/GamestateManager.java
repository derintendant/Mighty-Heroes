/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MIG.ka.bprocess.Gamestates;

import MIG.ka.bprocess.Common.CommonEvent;
import MIG.ka.bprocess.Common.ViewProperty;
import MIG.ka.bprocess.Login.LoginListener;
import MIG.ka.bprocess.Login.Screen.LoginView;
import MIG.ka.bprocess.MainMenu.StartMultiplayerListener;
import java.util.ArrayList;

/**
 *
 * @author Thor
 */
public class GamestateManager implements StateListener
{

    ArrayList<Gamestate> stateList = new ArrayList<>(3);

    public GamestateManager() {
        LoginView tmpView = new LoginView();
        GS_Stopped tmpGS = new GS_Stopped(tmpView);
        tmpView.addListener((LoginListener)tmpGS);
        tmpGS.setListener((StateListener)this);
        ViewProperty.getInstance().setLoginScreen(tmpView);
        this.addState(tmpGS);
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
    
    @Override
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
            switch (event.getId()) {
                case "GS_Paused":
                    this.addState(new GS_Paused());
                    break;
                case "GS_Running":
                    this.addState(new GS_Running());
                    break;
                case "GS_Stopped":
                    this.addState(new GS_Stopped());
                    break;
            }
        }
        else
        {
            this.changeActiveElement(this.stateList.get(index));
        }
        this.initState();
    }

    @Override
     public void actionPerformed(ExitEvent event) 
     {
        for (Gamestate gamestate : stateList) 
        {
            gamestate.cleanup();
        }
     }
    
    @Override
    public void actionPerformed(CommonEvent event) 
    {
    }
}
