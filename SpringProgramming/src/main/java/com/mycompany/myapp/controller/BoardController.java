package com.mycompany.myapp.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import com.mycompany.myapp.dto.*;
import com.mycompany.myapp.service.*;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/board/list")
	public String list(@RequestParam(defaultValue="1") int pageNo, Model model, HttpSession session) {
		logger.info("list()");
		
		session.setAttribute("pageNo", pageNo);
		
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
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	@RequestMapping("/board/writeForm")
	public ModelAndView writeForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/writeForm");
		return mav;
	}
	
	@RequestMapping("/board/updateForm")
	public String updateForm(int boardNo, Model model) {
		logger.info("updateForm()");
		Board board = boardService.getBoard(boardNo);
		model.addAttribute("board", board);
		return "board/updateForm";
	}
	
	@RequestMapping("/board/write")
	public String write(Board board, HttpSession session) {
		logger.info("write()");
		
		//파일 정보 얻기	
		ServletContext application = session.getServletContext();
		String dirPath = application.getRealPath("/resources/uploadfiles");
		String originalFilename = board.getAttach().getOriginalFilename();
		String filesystemName = System.currentTimeMillis() + "-" + originalFilename;
		String contentType = board.getAttach().getContentType();
		if(!board.getAttach().isEmpty()) {
			//파일에 저장하기
			try {
				board.getAttach().transferTo(new File(dirPath + "/" + filesystemName));
			} catch (Exception e) { e.printStackTrace(); }
		}
		
		//데이터 베이스에 게시물 정보 저장
		/*Board board = new Board();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);*/
		if(!board.getAttach().isEmpty()) {
			board.setOriginalFileName(originalFilename);
			board.setFilesystemName(filesystemName);
			board.setContentType(contentType);
		}
		boardService.add(board);
		
		
		
		return "redirect:/board/list";
	}
	
	@RequestMapping("/board/update")
	public String update(Board board) {
		logger.info("update()");		
		boardService.modify(board);
		return "redirect:/board/detail?boardNo="+board.getNo();		
	}
	
	/*@RequestMapping("/board/detail")
	public String detail(int boardNo, Model model) {		
		logger.info("detail()");
		boardService.addHitcount(boardNo);
		Board board = boardService.getBoard(boardNo);
		model.addAttribute("board", board);		
		return "board/detail";
	}*/
	
	@RequestMapping("/board/detail")
	public ModelAndView detail(int boardNo) {
		boardService.addHitcount(boardNo);
		Board board = boardService.getBoard(boardNo);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		mav.setViewName("board/detail");
		return mav;
	}
		
	@RequestMapping("/board/delete")
	public String delete(int boardNo) {
		logger.info("delete()");
		boardService.remove(boardNo);
		return "redirect:/board/list";
	}
}
