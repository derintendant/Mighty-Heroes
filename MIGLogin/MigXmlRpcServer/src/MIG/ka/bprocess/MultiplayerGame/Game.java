/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MIG.ka.bprocess.MultiplayerGame;

import java.util.ArrayList;

/**
 *
 * @author Thomas
 */
public class Game 
{
    ArrayList<String> usersByName = new ArrayList<>();

    public Game(String userOne)
    {
        this.usersByName.add(userOne);
    }
    
    public boolean addUser(String user)
    {
        if(this.usersByName.size() <= 1)
        {
            if(!checkGame(user))
            {
                this.usersByName.add(user);
                return true;
            }
        }
        return false;
    }
    
    public boolean checkGame(String user)
    {
        for (String actualUser : usersByName) {
            return actualUser.equals(user);
        }
        return false;
    }
    
    
    
}
