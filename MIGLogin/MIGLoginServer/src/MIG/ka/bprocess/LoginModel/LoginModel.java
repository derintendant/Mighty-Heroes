/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//!!!-Keine Infos über Datenbank eingetragen-!!!
//!!!-Model vergleicht username und passwort - oder tut das der Controller?-!!!

package MIG.ka.bprocess.LoginModel;
import java.sql.*;

/**
 *
 * @author Jan
 */
public class LoginModel {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/EMP";

    //  Database credentials
    static final String USER = "database-username";
    static final String PASS = "database-password";
   
    public static boolean checkLogindata(String loginusername, String loginpassword) {
        boolean loginstatus;
        loginstatus = false;//true = Benutzername vorhanden, Passwort korrekt   
        Connection conn = null;
        Statement stmt = null;
        try{
            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT username, password FROM Users";
            ResultSet rs = stmt.executeQuery(sql);

            //Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                String username = rs.getString("username");
                String password = rs.getString("password");

                //compare username and password
                if(username.equals(loginusername)){
                    if(password.equals(loginpassword)){
                        loginstatus = true;
                        break;
                    }
                }
            }//end while
            //Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return loginstatus;
    }
}
