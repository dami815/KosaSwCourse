package dao;

import java.sql.Connection;

public class BoardDaoInsertTest {

	public static void main(String[] args) throws Exception {
		Board board = new Board();
		board.setTitle("오늘은 DAO를 만드는 날");
		board.setContent("DAO가 참 유용하네요. 연습 많이 많이^^");
		board.setWriter("홍길동");
		
		Connection conn = ConnectionManager.getConnection();
		BoardDao boardDao = new BoardDao(conn);
		Integer pk = boardDao.insert(board);
		if(pk!=null) {
			System.out.println(pk + "번 게시물이 저장됨 ^.^");
		} else {
			System.out.println("저장 실패 ㅠㅠ");
		}
		conn.close();
	}

}
