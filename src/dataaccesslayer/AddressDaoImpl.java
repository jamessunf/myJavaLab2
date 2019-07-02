/**
 * Course: CST8288_521 OOP with Design Patterns
 * Assignment: Lab2
 * Project Purpose: Explore DAO patten.
 * 
 * File Name: AddressDaoImpl.java 
 * Professor: George Kriger
 * Author: Feng Sun
 * Date: Jun/12/2019
 */
package dataaccesslayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import transferobjects.Address;

/**
 * class to implement AddressDao interface, refer to operating create, read, update and delete from database
 * 
 * It is specific some functions, such as extracting values,updating value, adding new values and deleting some values,
 * that deal with addresses table, include obtain table metadata and data,
 * @author kriger, feng
 * @version 1.0.0
 * @see dataaccesslayer.AddressDao
 */
public class AddressDaoImpl implements AddressDao{

    /**
     * The override method, that purpose to obtain all rows of addresses table data.
     * @return a List, that include all rows of address table.
     */
    @Override
    public List<Address> getAllAddress() {
        
                Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
                
		ArrayList<Address> addresses = null;
		try{
			DataSource ds = new DataSource();
			con = ds.createConnection();
			pstmt = con.prepareStatement(
					"SELECT AddressId,FirstName,LastName,Email,PhoneNumber FROM Addresses");
                       
			rs = pstmt.executeQuery();
			addresses = new ArrayList<Address>();
                        
                                ResultSetMetaData metaData = rs.getMetaData();
                           
			while(rs.next()){
                            
                           
				Address address = new Address();
                                address.setAddressId(new Integer(rs.getInt(metaData.getColumnName(1))));
                                address.setFirstName(rs.getString(metaData.getColumnName(2)));
                                address.setLastName(rs.getString(metaData.getColumnName(3)));
                                address.setEmail(rs.getString(metaData.getColumnName(4)));
                                address.setPhoneNumber(rs.getString(metaData.getColumnName(5)));
                                addresses.add(address);
                                
                                
				
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{ if(rs != null){ rs.close(); } }
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(pstmt != null){ pstmt.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(con != null){ con.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
		}
		return addresses;
    }

   /**
    * The override method, it deals with obtain a specific address object by the provide id.
    * @param id, it accepts from client, 
    * @return a specific address object, by that id
    */

    @Override
    public Address getAddressById(Integer id) {
        
                Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
                Address address = null;
                
		
		try{
			DataSource ds = new DataSource();
			con = ds.createConnection();
			pstmt = con.prepareStatement(
					"SELECT AddressId,FirstName,LastName,Email,PhoneNumber FROM Addresses WHERE AddressId = ?");
                        pstmt.setInt(1, id.intValue());
			rs = pstmt.executeQuery();
                              ResultSetMetaData metaData = rs.getMetaData();
                           
			while(rs.next()){
                          
				address = new Address();
                                address.setAddressId(new Integer(rs.getInt(metaData.getColumnName(1))));
                                address.setFirstName(rs.getString(metaData.getColumnName(2)));
                                address.setLastName(rs.getString(metaData.getColumnName(3)));
                                address.setEmail(rs.getString(metaData.getColumnName(4)));
                                address.setPhoneNumber(rs.getString(metaData.getColumnName(5)));
 			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{ if(rs != null){ rs.close(); } }
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(pstmt != null){ pstmt.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(con != null){ con.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
		}
		return address;
    }
    
    /**
     * The override method, it deals with add a new address object to the table.
     * @param address object, a new one that would transfer add to the table
     */

    @Override
    public void addAddress(Address address) {
        		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			DataSource ds = new DataSource();
			con = ds.createConnection();
			
			pstmt = con.prepareStatement(
					"INSERT INTO Addresses (FirstName, LastName,Email,PhoneNumber) " +
			        "VALUES(?, ?, ?, ?)");
			pstmt.setString(1, address.getFirstName());
			pstmt.setString(2, address.getLastName());
                        pstmt.setString(3, address.getEmail());
                        pstmt.setString(4, address.getPhoneNumber());
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{ 
			try{ if(pstmt != null){ pstmt.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(con != null){ con.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
		}
    }

    /**
     * The override method, it deals with update a specific address list
     * 
     * @param address object, that transfer to update the list in the table
     */
    @Override
    public void updateAddress(Address address) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * The override method, it deals with delete a list of data from table
     * 
     * @param address object, that the list would delete form the table
     */

    @Override
    public void deleteAddress(Address address) {
        	Connection con = null;
		PreparedStatement pstmt = null;
		try{
			DataSource ds = new DataSource();
			con = ds.createConnection();
			pstmt = con.prepareStatement(
					"DELETE FROM Addresses WHERE FirstName = ? AND LastName = ?");	
			pstmt.setString(1, address.getFirstName());
                        pstmt.setString(2, address.getLastName());
                        
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{ if(pstmt != null){ pstmt.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(con != null){ con.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
		}
    }



}