package org.spring.controller;

import java.util.ArrayList;

import org.spring.domain.SampleDTO;
import org.spring.domain.TodoDTO;
import org.spring.service.FileService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

// servlet-context.xml에 어느부분을 읽어줄지 입력해둬야 @Controller가 기능함
@Controller
@RequestMapping("/sample/*") // sample/aaa sample/bbb 등의 sample/들은 모두 여기를 거치게 된다.
@Log4j
public class SampleController {
	
	private final FileService fileService;
	
	public SampleController(FileService fileService) {
		this.fileService = fileService;
	}
	
	@RequestMapping("")
	public void basic() {
		log.info("basic..");
	}
	
	@GetMapping("/basicOnlyGet")
	public void basicGet() {
		log.info("basic get..");
	}
	
	// DTO : Data Transfer Object
	// 데이터를 간단한 객체 형태로 표현 및 전달을 위해 사용되는 개념
	@GetMapping("ex01")
	public String ex01(SampleDTO dto) {
		log.info(dto);
		return "ex01";
	}
	
	@GetMapping("ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") String age) {
		log.info("name: "+ name);
		log.info("age: "+ age);
		return "ex02";
	}
	
	// sameple/ex02List?chk="a"&chk="b"
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("chk") ArrayList<String> chk) {
		for(String c : chk) {
			System.out.println(c);
		}
		log.info("chk: "+ chk);
		return "/ex02List";
	}
	
	// list는 get방식으로 전달 불가능(특수문자를 못넣어서). post방식을 사용해야함
	@GetMapping("/ex02ParaList")
	public String ex02ParaList(@RequestParam("n") ArrayList<String> array) {
		log.info(array);
		return "ex02ParaList";
	}
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		log.info(todo);
		return "ex03";
	}
	
	// void : 접속한 url과 동일한 이름의 jsp파일과 연결
	// views/sample/ex04.jsp로 이동함
	// 포워딩 view를 따로 지정할 필요 x
	@GetMapping("/ex04")
	public void ex04() {
		log.info("ex04");
	}
	
	@GetMapping("/exUpload")
	public void exUpload(ArrayList<MultipartFile> files) {
		log.info("exUpload출력");
	}
	
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		files.forEach(file ->{
			log.info("name: "+file.getOriginalFilename());
			log.info("size: "+file.getSize());
			
//			File upfile = new File("C:/fileUpload", file.getOriginalFilename());
//		
//			try {
//				file.transferTo(upfile);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			
			if(file.getSize() > 0) {
				String newFileName = generateFileName(file.getOriginalFilename());
				// 저장할 파일, 경로가 필요함
				try {
					fileService.saveFile(file, "C:/fileUpload/desti/"+newFileName);
				} catch (Exception e) {
					log.error(e.getMessage());
				}
			}
		});
	}
	
	// 새로운 파일 이름 생성(같은 이름의 파일이 올라가면 덮어쓰기가 되기때문에)
	private String generateFileName(String orginalFileName) {
		long uploadTime = System.currentTimeMillis();
		return uploadTime+"_"+orginalFileName;
	}
	
}