/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MIG.ka.bprocess.Networking;

import MIG.ka.bprocess.MultiplayerGame.Game;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;

/**
 *
 * @author Thor
 */
public class NetworkingClient {
    
    private static NetworkingClient instance = null;
    
    private final static String ServerUrlPrefix = "http://";
    private final static String ServerIp = "mightyheroes.scootaloo.me/api";
    
    private final XmlRpcClient client;
    
    private NetworkingClient() {
        this.client = new XmlRpcClient();
        XmlRpcClientConfigImpl conf = new XmlRpcClientConfigImpl();
        try 
        {
            conf.setServerURL(new URL(ServerUrlPrefix+ServerIp));
            conf.setConnectionTimeout(60 * 1000);
            conf.setReplyTimeout(60 * 1000);

        } 
        catch (MalformedURLException ex) 
        {
            Logger.getLogger(NetworkingClient.class.getName()).log(Level.SEVERE, "Server URL is not working!" , ex);
        }
        this.client.setConfig(conf);
        this.client.setTransportFactory(new XmlRpcCommonsTransportFactory(client));
    }
    
    private Object sendWithParams(String MethodName, ArrayList params)
    {
        try 
        {
          return this.client.execute(MethodName, params);
        } 
        catch (XmlRpcException ex) 
        {
            Logger.getLogger(NetworkingClient.class.getName())
                    .log(Level.SEVERE, "Failed Serverrequest for: " + MethodName + " with following Parameters: " + params, ex);
        }
        return null;
    }
    
    /**
     *
     * @param username
     * @param password
     * @return
     * @throws NullPointerException
     */
    public boolean LoginRequest(String username, String password) throws NullPointerException
    {
        ArrayList list = new ArrayList();
        list.add(username);
        list.add(password);
        return (boolean)sendWithParams("LoginHandler.checkLogindata", list);
    }
    
     public void addGame(String user)
    {
        ArrayList list = new ArrayList();
        list.add(user);
        sendWithParams("LobbyHandler.addGame", list);
    }
    
     public Game getGameByUserName(String user)
     {
         Object game;
        ArrayList list = new ArrayList();
        list.add(user);
        try
        {
            game = sendWithParams("LobbyHandler.getGameByUserName", list);
            if(game != null)
            {
                return (Game)game;
            }    
        }
        catch(ClassCastException ex)
        {
             Logger.getLogger(NetworkingClient.class.getName())
                    .log(Level.SEVERE, "Server returned no game!", ex);
        }
        return null;
     }
     
     public boolean addUser(String gameOwner, String user)
     {
        ArrayList list = new ArrayList();
        list.add(gameOwner);
        list.add(user);
        return (boolean)sendWithParams("LobbyHandler.addUser", list);
     }
    
     public ArrayList<Game> getAllGames()
     {
         ArrayList list = new ArrayList();
         return (ArrayList<Game>)sendWithParams("LobbyHandler.getAllGames" , list);
     }
     
    public static NetworkingClient getInstance()
    {
        if(instance == null)
        {
           instance = new NetworkingClient();
        }
        return instance;
    }
}
