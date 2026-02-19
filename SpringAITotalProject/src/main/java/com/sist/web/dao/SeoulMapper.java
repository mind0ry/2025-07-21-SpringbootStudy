package com.sist.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.SeoulVO;

@Mapper
@Repository
public interface SeoulMapper {

	@Select("SELECT title FROM seoultravel")
	public List<String> seoulGetTitle();
	
	@Select("SELECT no,title,x,y,image1 "
			+ "FROM seoultravel "
			+ "WHERE title=#{title}")
	public SeoulVO seoulData(String title);
}
