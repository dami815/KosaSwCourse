package com.mycompany.myapp.controller;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

@Controller
public class Chap09Controller {
	private static final Logger logger = LoggerFactory.getLogger(Chap09Controller.class);
	
	
	@RequestMapping("/chap09/index")
	public String index() {
		return "chap09/index";
	}
	
	@RequestMapping("/chap09/echo")
	public String echo() {
		return "chap09/echo";
	}
	
	@RequestMapping("/chap09/chat")
	public String chat() {
		return "chap09/chat";
	}
	
	@RequestMapping("/chap09/chatColor")
	public String chatColor() {
		return "chap09/chatColor";
	}
	
	@RequestMapping("/chap09/chatGroup")
	public String chatGroup() {
		return "chap09/chatGroup";
	}
	
	@RequestMapping("/chap09/fileUploadForm")
	public String fileUploadForm(){
		return "chap09/fileUploadForm";
	}
	
	//DB를 사용해서 필드값을 써야하는데 지금은 그냥 하는중
	@RequestMapping("/chap09/fileUpload")
	public String fileUpload(String desc, MultipartFile attach) throws IOException{
		logger.info("desc: " + desc);
		logger.info("fileName: " + attach.getOriginalFilename());
		
		originalFilename = attach.getOriginalFilename();
		fileType = attach.getContentType();
		
		saveFilename = originalFilename + System.currentTimeMillis();
		saveFilename = servletContext.getRealPath("/resources/uploadfiles/"+saveFilename);
		File saveFile = new File(saveFilename);
		
		//how1
		/*InputStream is = attach.getInputStream();
		FileOutputStream fos = new FileOutputStream(saveFile);
		
		byte[] data = new byte[1024];
		int byteNum;
		while((byteNum = is.read(data)) != -1) {		
			fos.write(data, 0, byteNum);
		}
		
		fos.flush();
		fos.close();
		is.close();*/
		
		//how2
		attach.transferTo(saveFile);
		
		return "redirect:/chap09/index";
	}
	
	@RequestMapping("/chap09/fileInfo")
	public String fileInfo() {
		return "chap09/fileInfo";
	}
	
	String originalFilename;
	String saveFilename;
	String fileType;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping("/chap09/fileDownload")
	public void fileDownload(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//응답헤더(3개: 순수파일이름, 파일타입, 파일크기)
		String originalFilename = this.originalFilename;
		String saveFilename = this.saveFilename;		
		
		String fileType = this.fileType;
		File file = new File(saveFilename);
		long fileSize = file.length();
		
		//1)순수 파일 이름 설정
		String userAgent = request.getHeader("User-Agent");
		if(userAgent.indexOf("MSIE") != -1) {
			originalFilename = URLEncoder.encode(originalFilename, "UTF-8");
		} else {
			originalFilename = new String(
					originalFilename.getBytes("UTF-8"),
					"ISO-8859-1"
			);
		}
		response.setHeader("Content-Disposition", "attachment; filename=\""+ originalFilename + "\";");
		
		//2)파일 타입
		response.setContentType(fileType);
		
		//3)파일 크기
		response.setContentLengthLong(fileSize);
		
		//응답본문(파일의 데이터)
		response.setHeader("Content-Transfer-Encoding", "binary");
		FileInputStream fis = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		
		//how1
		/*byte[] data = new byte[1024];
		int byteNum;
		while((byteNum = fis.read(data)) != -1) {
			os.write(data, 0, byteNum);
		}
		
		os.flush();
		os.close();
		fis.close();*/
		
		//how2
		FileCopyUtils.copy(fis, os);
		os.flush();
		os.close();
		fis.close();
	}
}

