package com.mycompany.myapp.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.myapp.dto.Board;
import com.mycompany.myapp.service.BoardService;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/board/list")
	public String list(@RequestParam(defaultValue="1") int pageNo, Model model) {
		logger.info("list()");
		
		//페이징을 위한 변수 선언
		int rowsPerPage = 10;
		int pagesPerGroup = 5;
		
		//전체 게시물 수
		int totalBoardNo = boardService.getTotalBoardNo();
		
		//전체 페이지 수
		int totalPageNo = totalBoardNo / rowsPerPage;
		if(totalBoardNo % rowsPerPage != 0) { totalPageNo++; }
		
		//전체 그룹 수
		int totalGroupNo = totalPageNo / pagesPerGroup;
		if(totalPageNo % pagesPerGroup != 0) { totalGroupNo++; }
		
		//현재 그룹번호, 시작페이지 번호, 끝페이지 번호
		int groupNo = (pageNo-1)/pagesPerGroup + 1;
		int startPageNo = (groupNo-1)*pagesPerGroup + 1;
		int endPageNo = startPageNo + pagesPerGroup - 1;
		if(groupNo == totalGroupNo) { endPageNo = totalPageNo; }
		
		//현재 페이지 게시물 리스트
		List<Board> list = boardService.getPage(pageNo, rowsPerPage);		
		
		//View로 넘길 데이터
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("totalGroupNo", totalGroupNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	@RequestMapping("/board/writeForm")
	public String writeForm() {
		logger.info("writeForm()");
		return "board/writeForm";
	}
	
	@RequestMapping("/board/updateForm")
	public String updateForm() {
		logger.info("updateForm()");
		return "board/updateForm";
	}
	
	@RequestMapping("/board/write")
	public String write(String title, String writer, String content, MultipartFile attach, HttpSession session) {
		logger.info("write()");
		
		//파일 정보 얻기	
		ServletContext application = session.getServletContext();
		String dirPath = application.getRealPath("/resources/uploadfiles");
		String originalFilename = attach.getOriginalFilename();
		String filesystemName = System.currentTimeMillis() + "-" + originalFilename;
		String contentType = attach.getContentType();
		if(!attach.isEmpty()) {
			//파일에 저장하기
			try {
				attach.transferTo(new File(dirPath + "/" + filesystemName));
			} catch (Exception e) { e.printStackTrace(); }
		}
		
		//데이터 베이스에 게시물 정보 저장
		Board board = new Board();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		if(!attach.isEmpty()) {
			board.setOriginalFileName(originalFilename);
			board.setFilesystemName(filesystemName);
			board.setContentType(contentType);
		}
		boardService.add(board);
		
		
		
		return "redirect:/board/list";
	}
	
	@RequestMapping("/board/update")
	public String update() {
		logger.info("update()");
		return "redirect:/board/list";		
	}
	
	@RequestMapping("/board/detail")
	public String detail(int boardNo, Model model) {		
		logger.info("detail()");
		boardService.addHitcount(boardNo);
		Board board = boardService.getBoard(boardNo);
		model.addAttribute("board", board);
		return "board/detail";
	}
}
