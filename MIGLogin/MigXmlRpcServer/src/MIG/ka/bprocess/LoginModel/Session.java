/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MIG.ka.bprocess.LoginModel;

/**
 *
 * @author Thomas
 */
public class Session {
    
    private String sessionID;

    public Session() {
    }

    public Session(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getSessionID() {
        return sessionID;
    }
}
