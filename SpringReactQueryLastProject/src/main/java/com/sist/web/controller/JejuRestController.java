package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dto.AttractionDTO;
import com.sist.web.service.TravelService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class JejuRestController {
	
	private final TravelService tService;
	
	@GetMapping("/jeju/attraction_react/{page}")
	public ResponseEntity<Map> jeju_attraction(@PathVariable("page") int page) {
		
		Map map=new HashMap();
		
		try {
			List<AttractionDTO> list=tService.jejuAttractionData((page-1)*12);
			int totalpage=tService.jejuTotalPage(12);
			
			final int BLOCK=10;
			int startPage=((page-1)/BLOCK*BLOCK)+1;
			int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
			
			if(endPage>totalpage)
				endPage=totalpage;
			
			map.put("list", list);
			map.put("totalpage", totalpage);
			map.put("curpage", page);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@GetMapping("/jeju/detail_react/{contentid}")
	public ResponseEntity<Map> jeju_detail(@PathVariable("contentid") int contentid) {
		Map map=new HashMap();
		try {
			AttractionDTO dto=tService.jejuAttractionDetail(contentid);
			map.put("dto", dto);
			// 댓글 첨부
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
}
