/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MIG.ka.bprocess.GameController;

import MIG.ka.bprocess.LoginController.CommonListener;

/**
 *
 * @author Thor
 */
public interface StateListener extends CommonListener{
    
    public void actionPerformed(StatechangeEvent event);
    public void actionPerformed(ExitEvent event);
}
