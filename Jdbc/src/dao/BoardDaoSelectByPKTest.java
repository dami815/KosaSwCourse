package dao;

import java.sql.Connection;

public class BoardDaoSelectByPKTest {

	public static void main(String[] args) throws Exception {
		
		Connection conn = ConnectionManager.getConnection();
		BoardDao boardDao = new BoardDao(conn);
		Board board = boardDao.selectByPk(22);
		if(board != null) {
			System.out.println("��ȣ: "+ board.getNo());
			System.out.println("����: "+ board.getTitle());
			System.out.println("����: "+ board.getContent());
			System.out.println("��¥: "+ board.getDate());
			System.out.println("�۾���: "+ board.getWriter());
			System.out.println("��ȸ��: "+ board.getHitcount());
		} else {
			System.out.println(22 + "�� �Խù��� �������� �ʽ��ϴ� �Ф�");
		}
		conn.close();
	}

}
