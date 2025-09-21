package maldace.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnect {
	
	private final String serverName = "LAPTOP-AEBT61JV\\SQLEXPRESS";
	private final String dbName = "text";
	private final String portNumber = "1433";
	private final String instance = "";
//	private final String password = "";
//	private final String userID = "";
	
//	public Connection getConnection() throws Exception {
//			String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName;
//			if (instance == null || instance.trim().isEmpty())
//				url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			return DriverManager.getConnection(url, userID, password);
//		}
	
	public Connection getConnectionW() throws Exception {
		String url = "jdbc:sqlserver://" + serverName
				+ ";encrypt=true;trustServerCertificate=true;integratedSecurity=true;databaseName=" + dbName;
		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://" + serverName  + ";encrypt=true;trustServerCertificate=true;integratedSecurity=true;databaseName="
					+ dbName;
		// DriverManager.registerDriver(new
		// com.mic
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url);
	}
	
	public static void main(String[] args) {
		try {
			// connnect to database 'testdb'
			Connection conn = new DBConnect().getConnectionW();
			// crate statement
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO GiaoVien(id, name, address) "
					+ "VALUES (?, ?, ?)");
			stmt.setInt(1, 2);
			stmt.setString(2, "Trung2");
			stmt.setString(3, "HCM2");
			stmt.execute();
			
			stmt = conn.prepareStatement("SELECT * FROM GiaoVien");
			// get data from table ‘GiaoVien'
			ResultSet rs = stmt.executeQuery();
			// show data
			while (rs.next()) {
			System.out.println(rs.getInt("id") + " " + rs.getString(2)
			+ " " + rs.getString(3));
			}
			conn.close(); // close connection
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
