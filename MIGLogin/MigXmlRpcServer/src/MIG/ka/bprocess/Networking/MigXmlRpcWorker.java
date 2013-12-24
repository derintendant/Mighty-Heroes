/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MIG.ka.bprocess.Networking;

import java.io.IOException;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;

/**
 *
 * @author Thor
 */
public class MigXmlRpcWorker {
    
    private final WebServer server;

    public MigXmlRpcWorker(int port , InetAddress addr) 
    {
        this.server = new WebServer(port, addr);
        try 
        {
            PropertyHandlerMapping handler = new PropertyHandlerMapping();
            handler.addHandler("LoginHandler", MIG.ka.bprocess.Networking.Handler.MigXmlRpcLoginHandler.class);
            handler.addHandler("LobbyHandler", MIG.ka.bprocess.Networking.Handler.MigXmlRpcLobbyHandler.class);
            this.server.getXmlRpcServer().setHandlerMapping(handler);
            
             XmlRpcServerConfigImpl serverConfig =
              (XmlRpcServerConfigImpl) this.server.getXmlRpcServer().getConfig();
            serverConfig.setEnabledForExtensions(true);
            serverConfig.setContentLengthOptional(false);
            
            Logger.getLogger(MigXmlRpcWorker.class.getName()).log(Level.INFO, 
                    "Started the Working Socket at Port: " + port);
            this.server.start();
        } 
        catch (IOException | XmlRpcException ex) 
        {
            Logger.getLogger(MigXmlRpcWorker.class.getName()).log(Level.SEVERE, 
                    "Failed to Start the Working Socket at Port: " + port , ex);
        }
    }
}
