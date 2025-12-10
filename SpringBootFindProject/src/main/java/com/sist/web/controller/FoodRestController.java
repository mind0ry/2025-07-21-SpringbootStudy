package com.sist.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
// 화면 변경(X) => 다른 언어와 연동 (데이터 전송 목적) => JSON
// CDN => Spring에 포함
// Component => Vue에 자체 화면 이동 => router
/*
 *   이전 => 유지보수 : SpringFramework
 *                  ---------------- 전자정부프레임워크
 *                  ---------------- 대기업 : 애니프레임워크
 *                  ---------------- 금융권 : 일반 : 스프링
 *   차세대 개발 : AI 탑재
 *      | NodeJS == Vue(nuxt) / React(next)
 *      | Boot == Thymeleaf / vue / react
 *      | CI/CD => AWS / Docker
 *   --------------------------------------
 *   
 *   {{}} => Thymeleaf => 변경 (())
 *   [[]]
 */
// vue연동
import java.util.*;
import com.sist.web.service.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor // 생성자를 이용한 자동 @Autowired
public class FoodRestController {
	private final FoodService fService;
	
	@GetMapping("/food/find_vue/")
	public Map food_find_vue(@RequestParam("page") int page, @RequestParam(name="address", required=false) String address) {
		
		if(address==null)
			address="마포";
		
		Map map=new HashMap();
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		
		map.put("start", start);
		map.put("end", end);
		map.put("address", address);
		
		// WHERE num BETWEEN #{start} AND #{end}
		// #{} => vo:getXxx() , map:get("key")
		List<FoodVO> list=fService.foodListData(map);
		int totalpage=fService.foodTotalPage();
		
		// Block
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		//Vue로 전송
		
		map=new HashMap();
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("address", address);
		
		return map; // 자동으로 JSON 변경 => jackson 
	}
	@GetMapping("/food/detail_vue/")
	public FoodVO food_detail_vue(@RequestParam("fno") int fno) {
		FoodVO vo=fService.foodDetailData(fno);
		return vo;
	}
}
