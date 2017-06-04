package expenser;

import com.amazonaws.services.lambda.runtime.Context;
import java.sql.*;

public class Expenser {
	
	public static String hello(Object someInput, Context context) {
	    
		System.out.println("Hander received input: " + someInput.toString());
		
		try {  
			
			Class.forName("com.mysql.jdbc.Driver");  
			
			System.out.println("Connecting...");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://asdw.c0blwycbj9z9.us-west-2.rds.amazonaws.com:3306/expenses?user=master&password=hudsonBean10.");  
			
			Statement statement = connection.createStatement();  
			
			System.out.println("Running query...");
			
			ResultSet resultSet = statement.executeQuery("select * from expenses");  
			
			while(resultSet.next())  {
				
				System.out.println(resultSet.toString());  
			}
			
			System.out.println("Closing connection");
			
			connection.close();  
		
		} catch(Exception e) { 
			
			System.out.println("Error communicating with db: " + e);
		}  
	
    	return "Hello World";
    }

}
