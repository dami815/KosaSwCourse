package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.BoardDao;
import com.mycompany.myapp.dto.Board;


@Component
public class BoardService {
	@Autowired
	private BoardDao boardDao;
	
	public void add(Board board) {
		boardDao.insert(board);
	}
	
	public List<Board> getPage(int pageNo, int rowsPerPage) {
		List<Board> list = boardDao.selectByPage(pageNo, rowsPerPage);		
		return list;
	}
	
	public Board getBoard(int boardNo) {
		Board board = boardDao.selectbyPk(boardNo);		
		return board;
	}
	
	public void modify(Board board) {
		boardDao.update(board);		
	}
	
	public void remove(int boardNo) {
		boardDao.delete(boardNo);
	}
	
	public void addHitcount(int boardNo) {
		boardDao.updateHitcount(boardNo);
		
	}
	
	public int getTotalBoardNo() {
		int rows= boardDao.selectCount();
		return rows;
	}
}
