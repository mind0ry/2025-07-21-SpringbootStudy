package com.sist.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.web.service.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class MainRestController {
	private final FoodService fService;
	
	@GetMapping("/main_vue/")
	public ResponseEntity<Map> main_vue(@RequestParam(name="page", required = false) int page) {
		
		Map map=new HashMap();
		try {
			int start=(page-1)*12;
			List<FoodVO> list=fService.foodListData(start);
			int totalpage=fService.foodTotalPage();
			
			final int BLOCK=10;
			int startPage=((page-1)/BLOCK*BLOCK)+1;
			int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
			
			if(endPage>totalpage)
				endPage=totalpage;
			
			map.put("list", list);
			map.put("curpage", page);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
			map.put("totalpage", totalpage);
			
		} catch (Exception ex) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
}
