package com.sist.web.commons;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
/*
 *    예외 / 에러
 *           | 수정이 불가능
 *     | 소스상의 수정이 가능
 *     *** 예외처리 : 사전에 에러를 방지하는 프로그램
 *                  프로그램을 정상적으로 동작할 수 있게 만든다
 *                  => 정상 종료를 시킨다
 *         컴파일 예외 : 사전에 검사를 하기 때문에 반드시 예외 처리한다
 *                     java.io / java.net / java.sql ...
 *                     => 개발자 실수
 *         런타임 예외 : 검사를 하지 않는다 필요시에 예외 처리를 한다
 *                     java.util / java.lang
 *                     => 사용자 실수
 */
@ControllerAdvice
public class ControllerException {
	
	// 모든 Controller의 catch을 통합해서 사용
	@ExceptionHandler(Exception.class)
	public void exception(Exception ex) {
		System.out.println("====== Exception 발생 ======");
		ex.printStackTrace();
		System.out.println("===========================");
	}
	
	// 예외+에러
	@ExceptionHandler(Throwable.class)
	public void throwsable(Throwable ex) {
		System.out.println("====== Throwable 발생 ======");
		ex.printStackTrace();
		System.out.println("===========================");
	}
}
