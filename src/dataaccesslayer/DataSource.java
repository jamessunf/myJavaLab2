/**
 * Course: CST8288_521 OOP with Design Patterns
 * Assignment: Lab2
 * Project Purpose: Explore DAO patten.
 * 
 * File Name: DataSource.java 
 * Professor: George Kriger
 * Author: Feng Sun
 * Date: Jun/12/2019
 */
package dataaccesslayer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * class to set the database sources.
 * @author kriger, feng
 * @version 1.0.0
 *
 */
public class DataSource {
    
     /*Connection*/
    private Connection connection = null;
    private  String connectionString;
    private  String username;
    private  String password;
    
    /**
     * the connection method, that reads the properties for database.properties files
     * Using those properties to connect database.
     * @return Connection object, that connect the database.
     */
   
    public Connection createConnection(){
        
        
        Properties props = new Properties();
		InputStream in = null;
		try {
			in = Files.newInputStream(Paths.get("src/dataaccesslayer/database.properties"));
			props.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// catch()
		finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}// finally
		
            //String drivers = props.getProperty("jdbc.drivers");
	    connectionString = props.getProperty("jdbc.url");
	    username = props.getProperty("jdbc.username");
	    password = props.getProperty("jdbc.password");
        
        
        try {
            
            if(connection != null){
            
                System.out.println("Can not create new connection, one exists already! ");
                
            }else{
            connection = DriverManager.getConnection(connectionString,username,password);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    
        return connection;
    }
    
    
    
}
