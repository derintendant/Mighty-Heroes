/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MIG.ka.bprocess.Networking;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
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
    
    private final static String serverUrlPrefix = "http://";
    private final static String serverIp = "localhost";//"scootaloo.me";
    private final static String serverPort = ":8085/";//server";
    private static String sessionID;
    
    private final XmlRpcClient client;
    
    private NetworkingClient() {
        this.client = new XmlRpcClient();
        XmlRpcClientConfigImpl conf = new XmlRpcClientConfigImpl();
        try 
        {
            conf.setServerURL(new URL(serverUrlPrefix+serverIp+serverPort));
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
          params.add(sessionID);
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
        this.sessionID = username;
        ArrayList list = new ArrayList();
        list.add(username);
        list.add(password);
        return (boolean)sendWithParams("LoginHandler.checkLogindata", list);
    }
    
     public void addGame()
    {
        ArrayList list = new ArrayList();
        sendWithParams("LobbyHandler.addGame", list);
    }
     
     public boolean addUser(String ownerSessionID)
     {
        ArrayList list = new ArrayList();
        list.add(ownerSessionID);
        return (boolean)sendWithParams("LobbyHandler.addUser", list);
     }
    
     public ArrayList<String> getAllGames()
     {
         ArrayList list = new ArrayList();
         Object result = sendWithParams("LobbyHandler.getAllGames" , list);
         Object resultObjectArray[] = (Object[])result;
         ArrayList<String> resultList = new ArrayList();
        for (Object resultObjectArray1 : resultObjectArray) {
            resultList.add((String) resultObjectArray1);
        }
         return resultList;
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
