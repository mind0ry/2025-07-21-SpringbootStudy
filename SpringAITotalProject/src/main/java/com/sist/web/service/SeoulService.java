package com.sist.web.service;

import java.util.List;

import com.sist.web.vo.SeoulVO;

public interface SeoulService {
	public List<String> seoulGetTitle();
	public SeoulVO seoulData(String title);
}
