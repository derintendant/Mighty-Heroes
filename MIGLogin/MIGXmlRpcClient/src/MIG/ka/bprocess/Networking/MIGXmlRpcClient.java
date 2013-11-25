/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MIG.ka.bprocess.Networking;

/**
 *
// * @author Thor
 */
public class MIGXmlRpcClient {
     public static void main(String[] args) 
    {
       boolean ans = NetworkingClient.getInstance().LoginRequest("test", "passwort");
        System.out.println("Ans:" + ans);
    }
}
