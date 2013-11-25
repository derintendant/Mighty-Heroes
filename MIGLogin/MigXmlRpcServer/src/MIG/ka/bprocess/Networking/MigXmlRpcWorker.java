/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MIG.ka.bprocess.Networking;

import MIG.ka.bprocess.LoginModel.LoginModel;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
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
            handler.addHandler("LoginModel", MIG.ka.bprocess.LoginModel.LoginModel.class);
            this.server.getXmlRpcServer().setHandlerMapping(handler);
            
             XmlRpcServerConfigImpl serverConfig =
              (XmlRpcServerConfigImpl) this.server.getXmlRpcServer().getConfig();
          serverConfig.setEnabledForExtensions(true);
          serverConfig.setContentLengthOptional(false);
            
            Logger.getLogger(MigXmlRpcWorker.class.getName()).log(Level.INFO, 
                    "Started the Working Socket at Port: " + port);
            this.server.acceptClient("127.0.0.1");
            this.server.start();
        } catch (IOException ex) 
        {
            Logger.getLogger(MigXmlRpcWorker.class.getName()).log(Level.SEVERE, 
                    "Failed to Start the Working Socket at Port: " + port , ex);
        } catch (XmlRpcException ex) {
            Logger.getLogger(MigXmlRpcWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean checkLogindata(ArrayList<String> params)
    {
        return LoginModel.checkLogindata(params.get(0), params.get(1));
    }
        
}
