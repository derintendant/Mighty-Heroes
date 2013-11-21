/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MIG.ka.bprocess.LoginController;

/**
 *
 * @author Thomas
 */
public class LoginController implements LoginListener{

    @Override
    public void actionPerformed(LoginEvent event) {
        //TODO: sendWithParams("verifyUser",new Vector<String> {event.getName , event.getPassword };) 
    }

    @Override
    public void actionPerformed(CommonEvent event) {
    }
}
