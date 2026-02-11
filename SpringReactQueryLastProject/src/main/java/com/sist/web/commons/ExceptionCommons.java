package com.sist.web.commons;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionCommons {

	@ExceptionHandler(Exception.class)
	public void exception(Exception ex) {
		System.out.println("======= 서버 예외 발생 =======");
		ex.printStackTrace();
		System.out.println("===========================");
	}
}
