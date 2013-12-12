/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MIG.ka.bprocess.Networking;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
// * @author Thor
 */
public class MIGXmlRpcClient {
     public static void main(String[] args) 
    {
        try
        {
            boolean ans = NetworkingClient.getInstance().LoginRequest("test", "passwort");
            System.out.println("Ans:" + ans);
        }
        catch(NullPointerException e)
        {
            Logger.getLogger(NetworkingClient.class.getName()).log(Level.SEVERE, "Server is not available!" , e);
        }
       
    }
}
