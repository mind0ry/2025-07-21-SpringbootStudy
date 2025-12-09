package com.sist.web.commons;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerException {
	
	// 모든 Controller의 catch을 통합해서 사용
	@ExceptionHandler(Exception.class)
	public void exception(Exception ex) {
		System.out.println("====== Exception 발생 ======");
		ex.printStackTrace();
		System.out.println("===========================");
	}
	
	@ExceptionHandler(Throwable.class)
	public void throwsable(Throwable ex) {
		System.out.println("====== Throwable 발생 ======");
		ex.printStackTrace();
		System.out.println("===========================");
	}
}
