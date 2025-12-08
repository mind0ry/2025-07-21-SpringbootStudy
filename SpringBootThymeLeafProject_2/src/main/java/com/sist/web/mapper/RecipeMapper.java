package com.sist.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.RecipeVO;

@Repository
@Mapper
public interface RecipeMapper {
	public List<RecipeVO> recipeListData(Map map);
	
	public int recipeTotalPage();
	
	public List<RecipeVO> recipeTop10(); // AOP
}
