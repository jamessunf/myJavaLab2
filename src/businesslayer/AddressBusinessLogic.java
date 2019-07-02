/**
 * Course: CST8288_521 OOP with Design Patterns
 * Assignment: Lab2
 * Project Purpose: Explore DAO patten.
 * 
 * File Name: AddressBusinessLogic.java 
 * Professor: George Kriger
 * Author: Feng Sun
 * Date: Jun/12/2019
 */
package businesslayer;

import dataaccesslayer.AddressDao;
import dataaccesslayer.AddressDaoImpl;
import java.util.List;
import transferobjects.Address;

/**
 * class to operating address data in business layer
 * @author kriger, feng
 * @version 1.0.1
 * @see dataaccesslayer.AddressDaoImpl
 */
public class AddressBusinessLogic {
    
    	private static final int FIRST_NAME_MAX_LENGTH = 30;
	private static final int LAST_NAME_MAX_LENGTH = 30;
	
	private AddressDao addressdao = null;
        
        /**
         * constructor to instantiate a private AddressDaoImpl object
         */
        public AddressBusinessLogic(){
		addressdao = new AddressDaoImpl();
	}
	
        /**
         * List of the rows of addresses table
         * 
         * @return a list of all of data from addresses table
         */
	public List<Address> getAllAddress(){
            
		return addressdao.getAllAddress();
	}
        
        /**
         * Obtain a address object form table by id
         * @param id that use to find that list from table
         * @return address object that obtain from table by id
         */
        public Address getAddress(Integer id){
        
                return addressdao.getAddressById(id);
        }
        
        /**
         * Add a new list to the addresses table
         * @param address the new value of the list
         * @throws ValidationException 
         */
        public void addAddress(Address address) throws ValidationException{
		cleanAddress(address);
		validateAddress(address);
		addressdao.addAddress(address);
	}
        /**
         * Delete a specific row for the addresses table
         * 
         * @param address, the list would be delete from table
         */
        public void deleteAddress(Address address){
		addressdao.deleteAddress(address);
	}
        private void cleanAddress(Address address){
		if(address.getFirstName() != null){ 
			address.setFirstName(address.getFirstName().trim());
		}
		if(address.getLastName() != null){ 
			address.setLastName(address.getLastName().trim());
		}
	}
	
        /**
         * The private validation method, deal with validate length of first name and last name
         * 
         * @param address, that would be validate that name
         * @throws ValidationException 
         */
	private void validateAddress(Address address) throws ValidationException{
		validateString(address.getFirstName(), "First Name", FIRST_NAME_MAX_LENGTH, true);
		validateString(address.getLastName(), "Last Name", LAST_NAME_MAX_LENGTH, true);
	}
        
        
        /**
         * The private method, that deal with specific the validate task for the validateAddress method.
         * 
         * @param value the value of the address
         * @param fieldName the field name
         * @param maxLength the maximum length that string will be.
         * @param isNullAllowed allowed is null
         * @throws ValidationException 
         */
        private void validateString(String value, String fieldName, int maxLength, boolean isNullAllowed)
	    throws ValidationException{
		if(value == null && isNullAllowed){
			// return; // null permitted, nothing to validate
		}
		else if(value == null && ! isNullAllowed){
		    throw new ValidationException(String.format("%s cannot be null", 
		    		fieldName));
		}
		else if(value.length() == 0){
			throw new ValidationException(String.format("%s cannot be empty or only whitespace", 
					fieldName));
		}
		else if(value.length() > maxLength){
			throw new ValidationException(String.format("%s cannot exceed %d characters", 
					fieldName, maxLength));
		}
	}
    
}
