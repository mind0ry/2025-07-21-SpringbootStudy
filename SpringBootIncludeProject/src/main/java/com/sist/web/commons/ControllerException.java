package com.sist.web.commons;

import org.springframework.web.bind.annotation.ControllerAdvice;
// @RestController는 처리할 수 없다
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
 * 		Object
 *         |
 *      Throwable
 *         |
 *    --------------------------------
 *    |								  |
 *   Error                         Exception
 */

@ControllerAdvice
// 모든 요청기능 처리 => catch사용
public class ControllerException {
	@ExceptionHandler(Exception.class)
	public void exception(Exception ex) {
		System.out.println("===== Controller에서 예외 발생 =====");
		ex.printStackTrace();
		System.out.println("=================================");
	}
	
	@ExceptionHandler(Throwable.class)
	public void throwable(Throwable ex) {
		System.out.println("===== Controller에서 오류 발생 =====");
		ex.printStackTrace();
		System.out.println("=================================");
	}
}
