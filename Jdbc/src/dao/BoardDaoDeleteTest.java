package dao;

import java.sql.Connection;

public class BoardDaoDeleteTest {

	public static void main(String[] args) throws Exception {
		
		Connection conn = ConnectionManager.getConnection();	
		BoardDao boardDao = new BoardDao(conn);
		int rows = boardDao.delete(21);
		if(rows == 1) {
			System.out.println(21 + "�� �Խù� ���� �Ϸ� ^.^");
		} else {
			System.out.println(211 + "�� �Խù��� �������� ���� �Ф�");
		}
		conn.close();
	}

}
