/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MIG.ka.bprocess.MultiplayerGame;

import MIG.ka.bprocess.Common.CommonListener;

/**
 *
 * @author Thomas
 */
public interface JoinGameListener extends CommonListener{
    public void actionPerformed(JoinGameEvent event);
}
