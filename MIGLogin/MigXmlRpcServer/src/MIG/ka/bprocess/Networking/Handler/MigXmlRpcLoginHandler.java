/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MIG.ka.bprocess.Networking.Handler;

import MIG.ka.bprocess.LoginModel.LoginModel;

/**
 *
 * @author Thor
 */
public class MigXmlRpcLoginHandler {

    public MigXmlRpcLoginHandler() {
    }

    public boolean checkLogindata(String username , String password)
    {
        return LoginModel.checkLogindata(username, password);
    }
}
