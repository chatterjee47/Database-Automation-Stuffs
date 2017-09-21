package LearnPrograming;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
 
public class MultipleSQLQuery {
	
	private static Connection conn = null;
 
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		
		// Load Microsoft SQL Server JDBC driver.
	    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    // Prepare connection url.
	    String url = "jdbc:sqlserver://Cebu1.HankeyInvestments.Dev2:1433;DatabaseName=nowcom";
	    // Get connection to DB.
	    conn = DriverManager.getConnection(url, "slight_ss", "Testing.Dev2");
		
		
				
		 Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			    String ExecuteEmp1 = "select name from  [Lookup].[ActivityType]";
			    String ExecuteEmp2 = "select ActivityTypeID from  [Lookup].[ActivityType]";
			    
			    conn.setAutoCommit(false);
			    stmt.addBatch(ExecuteEmp1);
			    stmt.addBatch(ExecuteEmp2);
			  
			    ResultSet rs = stmt.executeQuery("select * from  [Lookup].[ActivityType]");
			    rs.last();
			    System.out.println(rs.last());
			    System.out.println("rows before batch execution= " + rs.getRow());
			    stmt.executeBatch();
			    conn.commit();
			    System.out.println("Batch executed");
			    rs = stmt.executeQuery("select * from  [Lookup].[ActivityType]");
			    rs.last();
			    System.out.println("rows after batch execution= " + rs.getRow());
			    conn.close();
			  }
			}