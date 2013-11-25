/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MIG.ka.bprocess.Networking;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import org.apache.xmlrpc.webserver.WebServer;

/**
 *
 * @author Thor
 */
public class MigXmlRpcServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        try 
        {
            MigXmlRpcWorker  worker;
            worker = new MigXmlRpcWorker(8085, InetAddress.getByName("localhost"));
        } catch (UnknownHostException ex) 
        {
            Logger.getLogger(MigXmlRpcServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
//    private final static int ServerPort = 8080;
//    
//    private WebServer server;
//
//    public MigXmlRpcServer() {
//        try 
//        {
//        this.server = new WebServer(ServerPort, Inet4Address.getLocalHost());
//        } catch (UnknownHostException ex) 
//        {
//            Logger.getLogger(MIG.ka.bprocess.Networking.MigXmlRpcServer.class.getName()).log(Level.SEVERE, 
//                    "Failed to create an new instance of the XmlRpc WebServer Class!", ex);
//        }
//    }

    
}
