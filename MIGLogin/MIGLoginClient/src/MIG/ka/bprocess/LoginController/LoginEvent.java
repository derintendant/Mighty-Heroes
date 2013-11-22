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
public class LoginEvent extends CommonEvent{

    private String name;
    private String password;

    public LoginEvent(String name, String password, String id) {
        super(id);
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
    
    
}
