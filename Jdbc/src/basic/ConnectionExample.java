package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			//Class.forName("oracle.jdbc.OracleDriver");
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					//"jdbc:oracle:thin:@70.12.108.154:1521:orcl", 
					"jdbc:mysql://blueskii.iptime.org:3306/team5",
					//"user8", "12345"
					"team5", "123456"
					); //연결 문자열(Connection String): IP / Port / DB
			System.out.println("연결 성공");
			
		} catch (Exception e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {}
		}

	}

}
