package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertExample {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://blueskii.iptime.org:3306/team5", 
					"team5", "123456"
					); //연결 문자열(Connection String): IP / Port / DB
			
			String sql = "insert into user8_boards(board_title, board_content, board_writer, board_date) values (?, ?, ?, now())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "내일은 수요일");
			pstmt.setString(2, "히히히히");
			pstmt.setString(3, "다다미");
			pstmt.executeUpdate();
			
			System.out.println("1개의 행이 저장됨");
			
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			try {pstmt.close();} catch (SQLException e1) {}
			try {conn.close();} catch (SQLException e) {}
		}

	}

}
