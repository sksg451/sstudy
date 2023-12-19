package org.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.spring.domain.BoardVO;
import org.spring.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor // 기본생성자 자동 호출 -> boardService주입
@Log4j
public class BoardController {
	// 의존성 주입
	// Spring에서 인터페이스 주입시 
	// 해당 인터페이스를 구현한 객체를 주입
	private final BoardService boardService;
	
	@GetMapping("/list")
	public void listAll(Model model) {
		log.info("전체 회원 목록");
		//model : 매핑된 jsp등의 화면으로 이동시에 전달되는 객체
		//바인딩 : name과 value의 쌍으로 저장
		model.addAttribute("boardList",boardService.listAll());
	}
	
	// board/register.jsp로 화면 이동
	@GetMapping("/register")
	public void registerGet() {}
	
	// Ajax, Form으로 controller접근 : 데이터 이동
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		
		int num = boardService.register(board);
		log.info("board: "+board);
		rttr.addFlashAttribute("alert",num+"번글 등록 완료");
		
		// redirect : 클라이언트의 브라우저에게 다른 URL이동하라는 명령
		//			  새로고침으로 인한 중복 요청 방지
		return "redirect:/board/list";
	}
	
	@GetMapping("/remove")
	public String remove(Integer bno,RedirectAttributes rttr) {
		log.info("remove실행 bno: "+bno);
		int count = boardService.remove(bno);
		if(count==1) {
			rttr.addFlashAttribute("alert", "글 삭제 완료");
		}
		return "redirect:/board/list";
	}
	
//	@GetMapping("/get")
//	public void gets(Integer bno , Model model) {
//		log.info("gets실행 bno: "+bno);
//		BoardVO board = boardService.get(bno);
//		model.addAttribute("board",board);
//	}
	@GetMapping({"/get","/modify"})
	public void get(Integer bno , Model model) {
		log.info("get실행 bno: "+bno);
		BoardVO board = boardService.get(bno);
		model.addAttribute("board",board);
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board , RedirectAttributes rttr) {
		log.info("modify실행");
		int count = boardService.modify(board);
		if(count==1) {
			rttr.addFlashAttribute("alert", "글 수정 완료");
		}
		return "redirect:/board/list";
	}
	
	@PostMapping("/list")
	public void list(Integer bno,Model model) {
		log.info("해당 번호 회원 목록");
		List<BoardVO> listb = new ArrayList<BoardVO>();
		listb.add(boardService.get(bno));
		model.addAttribute("boardList",listb);
		log.info(model);
	}
	


}
