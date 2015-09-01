package dao;

import java.sql.Connection;

public class BoardDaoSelectByPKTest {

	public static void main(String[] args) throws Exception {
		
		Connection conn = ConnectionManager.getConnection();
		BoardDao boardDao = new BoardDao(conn);
		Board board = boardDao.selectByPk(22);
		if(board != null) {
			System.out.println("번호: "+ board.getNo());
			System.out.println("제목: "+ board.getTitle());
			System.out.println("내용: "+ board.getContent());
			System.out.println("날짜: "+ board.getDate());
			System.out.println("글쓴이: "+ board.getWriter());
			System.out.println("조회수: "+ board.getHitcount());
		} else {
			System.out.println(22 + "번 게시물이 존재하지 않습니다 ㅠㅠ");
		}
		conn.close();
	}

}
