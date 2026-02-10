package com.sist.web.service;

import java.util.List;

import com.sist.web.dto.AttractionDTO;
import com.sist.web.dto.CommonsDTO;

public interface TravelService {
	public CommonsDTO seoulMainData();
	public List<CommonsDTO> seoulListData4(); 
	public List<CommonsDTO> jejuListData5(); 
	public List<CommonsDTO> busanListData4(); 
	public List<AttractionDTO> jejuAttractionData(int start);
	public int jejuTotalPage(int contenttype);
	public AttractionDTO jejuAttractionDetail(int contentid);
}
