package org.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

@ControllerAdvice
@Log4j
public class CommonsException {
	
	@ExceptionHandler(Exception.class)
	public String except(Exception ex, Model model) {
		log.error("Exception"+ex.getMessage());
		model.addAttribute("exception",ex);
		return "error_page";
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND) // NOT_FOUND를 ctrl+클릭해서 다른것들도 확인가능
	public String handle404(NoHandlerFoundException ex) {
		log.info("404확인");
		return "client404";
	}
}
