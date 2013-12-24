/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//!!!-Keine Infos über Datenbank eingetragen-!!!
//!!!-Model vergleicht username und passwort - oder tut das der Controller?-!!!

package MIG.ka.bprocess.LoginModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import BCrypt.BCrypt;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author Jan
 */
public class LoginModel {
    private static LoginModel instance = null;
    
    // Session Handling
    private final ArrayList sessions = new ArrayList<>();
    
    // JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    private static final String DB_URL = "jdbc:mysql://localhost";

    //  Database credentials
    private static final String USER = "mightyheroes";
    private static final String PASS = "bi-dri-wit-it-hirn-e";

    private LoginModel() {
    }
    
    public static LoginModel getInstance()
    {
        if(instance == null)
        {
            instance = new LoginModel();
        }
        return instance;
    }
    
    public boolean checkSession(String sessionID)
    {
        for (Iterator sessionItter = sessions.iterator(); sessionItter.hasNext();) 
        {
            Session session = (Session)sessionItter.next();
            if(session.getSessionID().equals(sessionID))
            {
                return true;
            }
        }
        return false;
    }
    
    public Session getSessionByID(String sessionID)
    {
        for (Iterator sessionItter = sessions.iterator(); sessionItter.hasNext();) 
        {
            Session session = (Session)sessionItter.next();
            if(session.getSessionID().equals(sessionID))
            {
                return session;
            }
        }
        return null;
    }
    
    public boolean checkLogindata(String loginusername, String loginpassword, String sessionID) 
    {
        if(!this.checkSession(sessionID))//Sessions could only excist once
        {
            this.sessions.add(new Session(sessionID));
        }
        else
        {
            return false;
        }
        return true;
//        boolean loginstatus;
//        loginstatus = false;//true = Benutzername vorhanden, Passwort korrekt   
//        Connection conn = null;
//        Statement stmt = null;
//        try{
//            //Register JDBC driver
//            Class.forName("com.mysql.jdbc.Driver");
//
//            //Open a connection
//            System.out.println("Connecting to database...");
//            conn = DriverManager.getConnection(DB_URL,USER,PASS);
//
//            //Execute a query
//            System.out.println("Creating statement...");
//            stmt = conn.createStatement();
//            String sql;
//            sql = "SELECT username, password "
//                + "FROM users where username="
//                + loginusername;
//            ResultSet rs = stmt.executeQuery(sql);
//
//            //Extract password from result set
//            String databasepassword = rs.getString("password");
//            loginstatus = BCrypt.checkpw(loginpassword, databasepassword);
//            
//            //Clean-up environment
//            rs.close();
//            stmt.close();
//            conn.close();
//            }catch(SQLException se){
//            //Handle errors for JDBC
//            se.printStackTrace();
//            }catch(Exception e){
//            //Handle errors for Class.forName
//            e.printStackTrace();
//            }finally{
//            //finally block used to close resources
//            try{
//                if(stmt!=null)
//                    stmt.close();
//            }catch(SQLException se2){
//            }// nothing we can do
//            try{
//                if(conn!=null)
//                    conn.close();
//            }catch(SQLException se){
//                se.printStackTrace();
//            }//end finally try
//        }//end try
//        return loginstatus;
    }
}
