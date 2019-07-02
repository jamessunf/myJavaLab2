/**
 * Course: CST8288_521 OOP with Design Patterns
 * Assignment: Lab2
 * Project Purpose: Explore DAO patten.
 * 
 * File Name: Address.java 
 * Professor: George Kriger
 * Author: Feng Sun
 * Date: Jun/12/2019
 */
package transferobjects;
/**
 * class to transfer data between the data layer and business layer
 * @author kriger,feng
 * @version 1.0.0
 * 
 */
public class Address {
    
    private Integer addressId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    
    /**
     * 
     * the constructor of address
     */
    public Address(){}
    
    
    
    /**
     * the getter of address id
     * @return address of id by a Integer
     */
    public Integer getAddressId(){
        return addressId;
    }
    /**
     * the setter of address id
     * @param addressId, that the address id value of parameter
     */
    public void setAddressId(Integer addressId){
        this.addressId = addressId;
    }
    /**
     * the getter of address first name
     * @return the first name of address, by string
     */
    public String getFirstName(){
        return firstName;
    }
    /**
     * the setter of address first name
     * @param firstName, that first name value of parameter
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    /**
     * the getter of address last name
     * @return the last name of address, by string
     */
    public String getLastName(){
        return lastName;
    }
    /**
     * the setter of address last name
     * @param lastName, that the last name value of parameter
     */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }   
    /**
     * the getter of address email
     * @return a email of address, by string
     */
    public String getEmail(){
        return email;
    }
    /**
     * the setter of mail
     * @param email, that the email value of parameter
     */
    public void setEmail(String email){
        this.email = email;
    }
    /**
     * the getter of phone number
     * @return the phone number of address, by string
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }
    /**
     * the setter of phone number
     * @param phoneNumber, that the phone number value of parameter
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
}
