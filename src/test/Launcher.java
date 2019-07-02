/**
 * Course: CST8288_521 OOP with Design Patterns
 * Assignment: Lab2
 * Project Purpose: Explore DAO patten.
 * 
 * File Name: Launcher.java 
 * Professor: George Kriger
 * Author: Feng Sun
 * Date: Jun/12/2019
 */
package test;

import businesslayer.AddressBusinessLogic;
import businesslayer.ValidationException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferobjects.Address;
/**
 * class to test the project function, list all data, create a new one and delete it.
 * @author kriger,feng
 * @version 1.0.0
 * 
 */

public class Launcher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
        
        AddressBusinessLogic logic = new AddressBusinessLogic();
			List<Address> list = null;
			Address address = null;
        
          try {   
              
            System.out.println("First: Printing Addresses:");
            list = logic.getAllAddress();
            printAddresses(list);
            
            System.out.println("Second: Inserting One Address:");
            address = new Address();
            address.setFirstName("FirstTestAdd");
            address.setLastName("LastTestAdd");
            address.setEmail("first.lastnamee@email.com");
            address.setPhoneNumber("345-567890");
            logic.addAddress(address);
              
            list = logic.getAllAddress();
            printAddresses(list);
            
            System.out.println("Third: Delete that Address:");
            
          
            logic.deleteAddress(address);
            list = logic.getAllAddress();
            printAddresses(list);
            
            
        } catch(ValidationException e){
			System.err.println(e.getMessage());
        }
        
    }
    
    private static void printAddress(Address address){
	    	String output = String.format("%s, %s, %s, %s ,%s",
	    			address.getAddressId().toString(),
	    			address.getFirstName(),
	    			address.getLastName(),
                                address.getEmail(),
                                address.getPhoneNumber());
	    	System.out.println(output);
	}
    
    
    private static void printAddresses(List<Address> addresses){
	    for(Address address : addresses){
	    	printAddress(address);
	    }
	    System.out.println();
	}
    
}
