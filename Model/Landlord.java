package Model;

import java.util.ArrayList;

public class Landlord extends User {

    // inherits email from user, use email as fk

    private int messageID; // pk, nn, ai
    private ArrayList<String> message = new ArrayList<String>();
  
    public Landlord()
    {
        super();
    }

    public Landlord(String email, String password, String fname, String lname, String role, int id, String message)
    {
        super(email, password, fname, lname, role);
        this.messageID = id;

    }


    public ArrayList<String> RetreiveMessage (ArrayList<String>  allMsg)
    {	
    	String email = getEmail(); 	// get the email of current user logged in
    	ArrayList<String> result = new ArrayList<String>();
   // 	System.out.println("user logged in: "+ super.getEmail());
   // 	System.out.println("Displaying all messages");
    	for(int i=0; i<allMsg.size(); i++) {
    		String [] temp = allMsg.get(i).split("\n"); //Split each String in ArrayList to get email and messages
	    		if(temp[0].equals(email)) {		//check if messages belong to current user
	    			String temp2 = "Property ID " +temp[2]+"   -   "+ temp[1];
	    			result.add(temp2);
	    		}
			System.out.println(temp[1]);
    	}
    	return result;
    }

    // public Listing addProperty()
    // {
    //     return;
    // }
    
    public ArrayList<Listing> LandlordListings (ArrayList<Listing> allListings){
    	
    	String email = getEmail(); 	// get the email of current user logged in
    	ArrayList<Listing> result = new ArrayList<Listing>();
    	for(int i=0; i<allListings.size(); i++) {
    		if(allListings.get(i).email().equals(email)) {
    			result.add(allListings.get(i));
    		}
    	}
    	return result;
    }

    public String editStatus()
    {
        return "";
    }

}