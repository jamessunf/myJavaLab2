/**
 * Course: CST8288_521 OOP with Design Patterns
 * Assignment: Lab2
 * Project Purpose: Explore DAO patten.
 * 
 * File Name: ValidationException.java 
 * Professor: George Kriger
 * Author: Feng Sun
 * Date: Jun/12/2019
 */
package businesslayer;
/**
 * class to claim the exception for this project, it inherit form exception
 * @author kriger, feng
 * @version 1.0.0
 * 
 */

public class ValidationException extends Exception {
	
    /**
     * The exception of validation
     */
	public ValidationException(){
		super("Data not in valid format");
	}
        /**
         * The exception of validation, accepts a message parameter by string
         * @param message 
         */
	
	public ValidationException(String message){
		super(message);
	}
        /**
         * The exception of validation, that accepts both message by string
         * and a throwable parameters
         * @param message
         * @param throwable 
         */
	
	public ValidationException(String message, Throwable throwable){
		super(message, throwable);
	}
	/**
         * The exception of validation, accepts a throwable parameter 
         * @param throwable 
         */
	public ValidationException(Throwable throwable){
		super(throwable);
	}
}
