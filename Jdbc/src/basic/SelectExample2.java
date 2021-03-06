package basic;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectExample2 {

	public static void main(String[] args) {
		int pageNo = 1;
		int rowsPerPage = 10;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://blueskii.iptime.org:3306/team5", 
					"team5", "123456"
					); //연결 문자열(Connection String): IP / Port / DB
			
			String sql = "select*from user8_boards order by board_no desc limit ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNo-1)*rowsPerPage);
			pstmt.setInt(2, rowsPerPage);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
			
				int boardNo = rs.getInt("board_no");
				String boardTitle = rs.getString("board_title");
				String boardContent = rs.getString("board_content");
				Date boardDate = rs.getDate("board_date");
				String boardWriter = rs.getString("board_writer");
				int boardHitcount = rs.getInt("board_hitcount");
				
				System.out.println(boardNo + "\t" + boardTitle + "\t" + boardContent + "\t" + boardWriter);
			}
			
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			try {pstmt.close();} catch (SQLException e1) {}
			try {conn.close();} catch (SQLException e) {}
		}

	}

}
