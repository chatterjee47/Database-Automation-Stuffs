package LearnPrograming;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
 
public class connectingToDBExample {
	
	private static Connection conn = null;
 
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		
		// Load Microsoft SQL Server JDBC driver.
	    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    // Prepare connection url.
	    String url = "jdbc:sqlserver://Cebu1.HankeyInvestments.Dev2:1433;DatabaseName=nowcom";
	    // Get connection to DB.
	    conn = DriverManager.getConnection(url, "slight_ss", "Testing.Dev2");
		
		
		//Executing SQL query and fetching the result
		Statement st = conn.createStatement();
		String sqlquery = "select * from  [Lookup].[ActivityType]";
		System.out.println("Query to be executed :" + sqlquery);
		
		ResultSet result  = st.executeQuery(sqlquery);
				
			if (result.next()) {
		        while (result.next()) {
		          
		          String Name = result.getString("Name");
		          String ActivityTypeID = result.getString("ActivityTypeID");
		          // print them on the console
		          System.out.println("Name :" + Name);
		          System.out.println("ActivityTypeID: " + ActivityTypeID);
		        }
		        result.close();
		}		
	}
}