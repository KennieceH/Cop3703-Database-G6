package g6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class COP3703_Database_G6 {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        String serverName = "cisvm-oracle.unfcsd.unf.edu";
        String portNumber = "1521";
        String sid = "orcl";
        String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
        String username = "n01503765";
        String password = "Fall20223765";
        try {
			Connection conn = DriverManager.getConnection(url, username, password);
			
	        boolean reachable = conn.isValid(10);// 10 sec

	        if(reachable) {
	        	
	        	System.out.println("Success");
	        	conn.close();
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
	}

}
