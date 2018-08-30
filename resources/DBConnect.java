package resources;

import java.sql.*;

public class DBConnect {
	
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch(Exception e) {
			System.out.println("First try: " + e.getMessage());
		}
		
		Connection con = null;
		
		try {
			String host = "";
			String uName = "";
			String uPass = "";
			
			con = DriverManager.getConnection(host, uName, uPass);
		} catch(SQLException err) {
			System.out.println("SQLException: " + err.getMessage());
			System.out.println("SQLState: " + err.getSQLState());
			System.out.println("Vendor Error: " + err.getErrorCode());
		}
	}
}
