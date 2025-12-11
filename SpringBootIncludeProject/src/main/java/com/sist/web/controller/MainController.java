package com.sist.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
/*
 *    1. MVC 동작 과정
 *    2. 어노테이션 역할
 *        => 메모리 할당
 *    3. ORM (MyBatis)
 *    4. HttpSesison / Cookie 처리
 *    5. 요청 데이터 => @RequestParam / @ModelAttribute
 *                   Vue, React (JSON) => @ReqiestBody
 *    6. @Controller / @RestController
 *    7. @ControllerAdvice : 예외 처리 공통으로 처리
 *    8. @Aspect : AOP
 *    9.interceptor
 *    10 . FileUpload
 *    ---------------------------------------------------
 *    11. Security / Batch / WebSocket / NodeJS
 *    								   ------------ typeScript
 *    FullStack : Javascript / Jquery / Vue / React
 *                               |       |      |
 *                             Ajax Vuex/pinia redux/tanstackquery
 */
// 화면 변경 => 요청처리 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.service.FoodService;
import com.sist.web.vo.FoodVO;

import lombok.RequiredArgsConstructor;
@Controller
@RequiredArgsConstructor
public class MainController {
	private final FoodService fService;
	
	@GetMapping("/")
	public String main_page(@RequestParam(name="page", required = false) String page, Model model) {
		
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int start=(curpage-1)*12;
		List<FoodVO> list=fService.foodListData(start);
		int totalpage=fService.foodTotalPage();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("list",list);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		// => main에 전송 => include는 request를 공유한다
		
		model.addAttribute("main_html","main/home");
		return "main/main";
	}
}
