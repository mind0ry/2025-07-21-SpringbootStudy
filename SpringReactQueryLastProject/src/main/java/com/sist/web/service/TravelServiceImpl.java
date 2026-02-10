package com.sist.web.service;
import java.util.*;

import org.springframework.stereotype.Service;

import com.sist.web.dto.*;
import com.sist.web.repository.BusanTravelRepository;
import com.sist.web.repository.JejuTravelRepository;
import com.sist.web.repository.SeoulTravelRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelServiceImpl implements TravelService {

	private final SeoulTravelRepository sRepo;
	private final BusanTravelRepository bRepo;
	private final JejuTravelRepository jRepo;

	@Override
	public CommonsDTO seoulMainData() {
		// TODO Auto-generated method stub
		return sRepo.seoulMainData();
	}

	@Override
	public List<CommonsDTO> seoulListData4() {
		// TODO Auto-generated method stub
		return sRepo.seoulListData4();
	}

	@Override
	public List<CommonsDTO> jejuListData5() {
		// TODO Auto-generated method stub
		return jRepo.jejuListData5();
	}

	@Override
	public List<CommonsDTO> busanListData4() {
		// TODO Auto-generated method stub
		return bRepo.busanListData4();
	}

	@Override
	public List<AttractionDTO> jejuAttractionData(int start) {
		// TODO Auto-generated method stub
		return jRepo.jejuAttractionData(start);
	}

	@Override
	public int jejuTotalPage(int contenttype) {
		// TODO Auto-generated method stub
		return jRepo.jejuTotalPage(contenttype);
	}

	@Override
	public AttractionDTO jejuAttractionDetail(int contentid) {
		// TODO Auto-generated method stub
		return jRepo.jejuAttractionDetail(contentid);
	}
	
	
	
}
