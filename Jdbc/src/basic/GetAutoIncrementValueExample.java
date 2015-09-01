package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetAutoIncrementValueExample {

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
			pstmt = conn.prepareStatement(sql, new String[]{"board_no"});
			pstmt.setString(1, "에러 좀 그만 나와");
			pstmt.setString(2, "ㅠㅠ");
			pstmt.setString(3, "대밋");
			int row = pstmt.executeUpdate();
			int boardNo = 0;
			if(row == 1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()) {
					boardNo = rs.getInt(1);
					
				}
				rs.close();
			}
			
			
			System.out.println(boardNo + "번 게시물이 저장됨");
			
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			try {pstmt.close();} catch (SQLException e1) {}
			try {conn.close();} catch (SQLException e) {}
		}

	}

}
