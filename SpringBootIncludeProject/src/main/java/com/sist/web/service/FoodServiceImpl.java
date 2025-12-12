package com.sist.web.service;
import java.util.*;
import com.sist.web.mapper.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {
	private final FoodMapper mapper;

	@Override
	public List<FoodVO> foodListData(int start) {
		// TODO Auto-generated method stub
		return mapper.foodListData(start);
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

	@Override
	public List<FoodVO> foodFindData(Map map) {
		// TODO Auto-generated method stub
		return mapper.foodFindData(map);
	}

	@Override
	public int foodFindTotalPage(Map map) {
		// TODO Auto-generated method stub
		return mapper.foodFindTotalPage(map);
	}
}
