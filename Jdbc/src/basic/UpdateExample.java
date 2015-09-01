package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateExample {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://blueskii.iptime.org:3306/team5", 
					"team5", "123456"
					); //연결 문자열(Connection String): IP / Port / DB
			
			String sql = "update user8_boards set board_title=?, board_content=?, board_writer=? where board_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "Today is Tuesday");
			pstmt.setString(2, "수정하기 싫어욥");
			pstmt.setString(3, "다다미");
			pstmt.setInt(4, 1);
			int rows = pstmt.executeUpdate();
			
			System.out.println(rows + "개의 행이 수정됨");
			
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			try {pstmt.close();} catch (SQLException e1) {}
			try {conn.close();} catch (SQLException e) {}
		}

	}

}
