/**
 * Course: CST8288_521 OOP with Design Patterns
 * Assignment: Lab2
 * Project Purpose: Explore DAO patten.
 * 
 * File Name: AddressDao.java 
 * Professor: George Kriger
 * Author: Feng Sun
 * Date: Jun/12/2019
 */
package dataaccesslayer;

import java.util.List;
import transferobjects.Address;
//import transferobjects.Address;

/**
 * interface to define the data access object for address database
 * @author kriger, feng
 * @version 1.0.0
 * 
 */
public interface AddressDao {
    
    /**
     * Declaration a method use to deal with all lists of addresses table
     * @return a list, contain the all the lists of addresses table
     */
    public List getAllAddress();
    /**
     * Declaration a method use to deal with obtain a address list by its id
     * @param id, that specific that address by this id
     * @return a address object, by specific id
     */
    public Address getAddressById(Integer id);
    /**
     * Declaration a method use to deal with add a new row to the address table
     * @param address object, that the new list would be add to the table
     */
    public void addAddress(Address address);
    /**
     * Declaration a method use to update a row in the address table
     * @param address object, that the updating list 
     */
    public void updateAddress(Address address);
    /**
     * Declaration a method use to deleting a row in the address table
     * @param address object, that the deleting list
     */
    public void deleteAddress(Address address);
    
    
}
