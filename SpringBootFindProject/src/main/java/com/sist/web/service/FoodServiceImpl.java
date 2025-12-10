package com.sist.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.FoodMapper;
import com.sist.web.vo.FoodVO;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
/*
 * 	  Spring + XML
 *             ---
 *             => 불편 => 순수하게 자바로만 코딩
 *                       ----------------
 *                       | => Spring-Boot
 *                 | MyBatis => XML/Annotation => 4.0 (Annotation)
 *      => XML : properties / yml
 *          
 */
public class FoodServiceImpl implements FoodService {
	private final FoodMapper mapper;
	
	/*
	 *  @RequiredArgsConstructor
	 * 			  ||
	@Autowired
	public FoodServiceImpl(FoodMapper mapper) {
		this.mapper=mapper;
	}
	*/
	
	@Override
	public List<FoodVO> foodListData(Map map) {
		// TODO Auto-generated method stub
		return mapper.foodListData(map);
	}

	@Override
	public int foodTotalPage() {
		// TODO Auto-generated method stub
		return mapper.foodTotalPage();
	}

	@Override
	public FoodVO foodDetailData(int fno) {
		// TODO Auto-generated method stub
		mapper.hitIncrement(fno);
		return mapper.foodDetailData(fno);
	}

}
