package com.mycompany.myapp.controller;

import java.util.*;

import org.slf4j.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.mycompany.myapp.dto.*;

@Controller
public class Chap07Controller {
	private static final Logger logger = LoggerFactory.getLogger(Chap07Controller.class);
	
	
	@RequestMapping("/chap07/index")
	public String index() {
		return "chap07/index";
	}
	
	@RequestMapping(value="/chap07/commandObject", method=RequestMethod.GET)
	public String commandObjectGet() {
		return "chap07/writeForm";
	}
	
	@RequestMapping(value="/chap07/commandObject", method=RequestMethod.POST)
	public String commandObjectPost(Board board) {
		if(board.getTitle()==null||board.getTitle().equals("")) {
			return "chap07/writeForm";
		}
		if(board.getWriter()==null||board.getWriter().equals("")) {
			return "chap07/writeForm";
		}
		if(board.getContent()==null||board.getContent().equals("")) {
			return "chap07/writeForm";
		}
		return "redirect:/board/list";
	}
	
	@ModelAttribute("menuList")
	public List<String> getMenuList() {
		logger.info("getMenuList()");
		List<String> menuList = Arrays.asList("메뉴1","메뉴2","메뉴3","메뉴4","메뉴5");
		return menuList;
	}
	
	@RequestMapping("/chap07/modelAttribute1")
	public String modelAttribute1() {	
		return "chap07/modelAttribute1";
	}
	
	@RequestMapping("/chap07/modelAttribute2")
	public String modelAttribute2() {
		return "chap07/modelAttribute2";
	}
}
