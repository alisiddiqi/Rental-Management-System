package Controller;

import java.sql.*;
import java.io.*;
import java.util.*;

import Model.Listing;
import Model.User;

public class DBConnect {


    public final String dburl = "jdbc:mysql://127.0.0.1:3306/ensf";
    public final String username = "root";
    public final String password ="calgary1";

    private Connection connect;
    private ResultSet results;
    
    
    // Constructor
    public DBConnect(){

    }

    /** Method initializeConnection
    * Establishes database connection
    */
    public void initializeConnection(){
    	    	
        try{
            connect = DriverManager.getConnection(dburl, username, password);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<Listing> getListing() throws SQLException {
    	PreparedStatement p=null;
    	ResultSet rs=null;
    	initializeConnection();
    	ArrayList<Listing> allListing = new ArrayList<Listing>();
    	
    	try {
    		//Sql query
	    	String sql = "select * from listing"
	    			+ " where status = ?";
	    	p= connect.prepareStatement(sql);
	    	p.setString(1, "Active");
	    	rs = p.executeQuery();
	    	
	    	//Retrieving data
	    	while(rs.next()) {
	    		int id = rs.getInt("ID");
	    		String property = rs.getString("propertyType");
	    		//System.out.println(property);
	    		int bed = rs.getInt("bedrooms");
	    		int bath = rs.getInt("bathrooms");
	    		boolean furnished = rs.getBoolean("Furnished");
	    		String time = rs.getString("listingTime");
				String address = rs.getString("address");
	    		String quad = rs.getString("quadrant");
	    		String email= rs.getString("email");
	    		String status= rs.getString("status");
	    		boolean bal= rs.getBoolean("balance");
	    		
	    		allListing.add(new Listing (id,property, bed, bath, furnished, quad, time, address, email, status ,bal));
	    	}	
    	}
    	
    	// Catch block to handle exception
        catch (SQLException e) {
 
            // Print exception pop-up on screen
            System.out.println(e);
        }
    	connect.close();
    	return allListing;
    }




	public ArrayList<User> getUsers()
	{
		ArrayList<User> users = new ArrayList<User>();
		initializeConnection();
		try{
			Statement stmt = connect.createStatement();
			String query = "SELECT * FROM user";
			results = stmt.executeQuery(query);

			while(results.next())
			{
				users.add(new User(results.getString("email"), results.getString("password"),
						results.getString("FName"), results.getString("LName"), results.getString("Role")));
			}
			stmt.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}

		return users;
	}

    
    
    public ArrayList<String> getMessages() {
    	PreparedStatement p=null;
    	ResultSet rs=null;
    	initializeConnection();
    	ArrayList<String> messages = new ArrayList<String>();
    	
    	try {
    		//Sql query
	    	String sql = "select * from landlord";
	    	p= connect.prepareStatement(sql);
	    	rs = p.executeQuery();
	    	
	    	//Retrieving data
	    	while(rs.next()) {
	    		String email = rs.getString("lemail");
	    		String message = rs.getString("message");	    		
	    		messages.add(email+"\n"+message);
	    	}	
    	}
    	
    	// Catch block to handle exception
        catch (SQLException e) {
 
            // Print exception pop-up on screen
            System.out.println(e);
        }
    	return messages;
    }

   
}