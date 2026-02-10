package com.sist.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.service.*;

import lombok.RequiredArgsConstructor;

import com.sist.web.dto.*;
import java.util.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class MainController {

	private final TravelService tService;
	private final MemberService mService;
	
	@GetMapping("/")
	public ResponseEntity<Map> main_page() {
		
		Map map=new HashMap();
		
		try {
			CommonsDTO mainData=tService.seoulMainData();
			List<CommonsDTO> seoulData=tService.seoulListData4();
			List<CommonsDTO> busanData=tService.busanListData4();
			List<CommonsDTO> jejuData=tService.jejuListData5();
			
			map.put("main", mainData);
			map.put("jList", jejuData);
			map.put("sList", seoulData);
			map.put("bList", busanData);
			
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@GetMapping("/member/login/{id}/{pwd}")
	public ResponseEntity<MemberDTO> member_login(@PathVariable("id") String id, @PathVariable("pwd") String pwd) {
		MemberDTO dto=new MemberDTO();
		
		try {
			dto=mService.memberLogin(id, pwd);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
}
