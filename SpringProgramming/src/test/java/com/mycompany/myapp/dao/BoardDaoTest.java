package com.mycompany.myapp.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.myapp.ApplicationContextLoader;
import com.mycompany.myapp.dto.Board;


public class BoardDaoTest extends ApplicationContextLoader {
	
	@Autowired
	private BoardDao boardDao;
	
	@Test
	public void testInsert() {
		Board board = new Board();
		board.setTitle("테스트1");
		board.setContent("테스트 내용1");
		board.setWriter("글쓴이1");
		Integer bno = boardDao.insert(board);
		Assert.assertNotNull(bno);
	}
	
	@Test
	public void testSelectByPage() {
		List<Board> list = boardDao.selectByPage(1, 10);
		Assert.assertEquals(10, list.size());
	}
	
	@Test
	public void testDelete() {
		Board board = new Board();
		board.setTitle("테스트1");
		board.setContent("테스트 내용1");
		board.setWriter("글쓴이1");
		Integer bno = boardDao.insert(board);
		int row = boardDao.delete(bno);
		Assert.assertEquals(1, row);
	}
	
	@Test
	public void testUpdate() {
		Board board = new Board();
		board.setTitle("테스트1");
		board.setContent("테스트 내용1");
		board.setWriter("글쓴이1");
		Integer bno = boardDao.insert(board);
		
		board.setNo(bno);
		board.setTitle("테스트2");
		board.setContent("테스트 내용2");
		
		int row = boardDao.update(board);
		Assert.assertEquals(1, row);
		
		Board board2 = boardDao.selectbyPk(bno);
		Assert.assertEquals(board.getTitle(), board2.getTitle());
		Assert.assertEquals(board.getContent(), board2.getContent());
		}
	
}
