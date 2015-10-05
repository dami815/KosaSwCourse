package com.mycompany.myapp.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Component
@ControllerAdvice("com.mycompany.myapp.controller")
public class Chap07CommonExceptionHandler {
	@ExceptionHandler(Exception.class)
	public String handleException() {
		//관리자에게 메일/SMS 을 보냄
		//사용자에게 보여줄 JSP 이동
		return "chap07/exception";
	}
	
	
}
