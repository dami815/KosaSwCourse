package com.mycompany.myapp.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.myapp.ApplicationContextLoader;
import com.mycompany.myapp.dto.Board;

public class BoardServiceTest extends ApplicationContextLoader {
	
	@Autowired
	private BoardService boardService;
	
	@Test
	public void testAdd() {
		Board board = new Board();
		board.setTitle("테스트1");
		board.setContent("테스트 내용1");
		board.setWriter("글쓴이1");
		boardService.add(board);
	}
	
}
