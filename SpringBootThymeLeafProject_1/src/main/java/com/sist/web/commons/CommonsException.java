package com.sist.web.commons;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonsException {
	@ExceptionHandler(Exception.class)
	public void exception(Exception ex) { // 예외 처리
		System.out.println("====== 에러 발생 ======");
		ex.printStackTrace();
		System.out.println("=====================");
	}
	@ExceptionHandler(Throwable.class)
	public void throwable(Throwable ex) { // 에러 처리
		System.out.println("====== 에러 발생 ======");
		ex.printStackTrace();
		System.out.println("=====================");
	}
}
