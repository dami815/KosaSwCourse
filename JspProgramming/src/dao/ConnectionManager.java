package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	public static Connection getConnection() 
			throws ClassNotFoundException, SQLException{
		Connection conn =null;
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(				 
				"jdbc:mysql://blueskii.iptime.org:3306/team0",
				"team0", "123456"
		);
		return conn;
	}
}
