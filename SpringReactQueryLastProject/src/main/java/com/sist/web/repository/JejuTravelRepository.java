package com.sist.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.dto.AttractionDTO;
import com.sist.web.dto.CommonsDTO;
import com.sist.web.entity.JejuTravel;

public interface JejuTravelRepository extends JpaRepository<JejuTravel, Integer> {

	@Query(value = "SELECT contentid,title,address,image1,hit,contenttype "
			+ "FROM jejutravel "
			+ "ORDER BY hit DESC "
			+ "OFFSET 0 ROWS FETCH NEXT 5 ROWS ONLY", nativeQuery = true)
	public List<CommonsDTO> jejuListData5(); 
	
	@Query(value = "SELECT j.contentid,title,address,image1,hit,j.contenttype,x,y,"
			+ "infocenter,restdate,usetime,parking,DBMS_LOB.SUBSTR(msg,48000,1) AS msg "
			+ "FROM jejutravel j "
			+ "JOIN attraction a "
			+ "ON j.contentid = a.contentid "
			+ "ORDER BY contentid ASC "
			+ "OFFSET :start ROWS FETCH NEXT 12 ROWS ONLY", nativeQuery = true)
	public List<AttractionDTO> jejuAttractionData(@Param("start") int start);
	
	@Query(value="SELECT CEIL(COUNT(*)/12.0) "
			+ "FROM jejutravel "
			+ "WHERE contenttype=:contenttype", nativeQuery = true)
	public int jejuTotalPage(@Param("contenttype") int contenttype);
	
	@Query(value = "SELECT j.contentid,title,address,image1,hit,j.contenttype,x,y,"
			+ "infocenter,restdate,usetime,parking,CAST(DBMS_LOB.SUBSTR(msg,4000,1) AS VARCHAR2(4000)) AS msg "
			+ "FROM jejutravel j "
			+ "JOIN attraction a "
			+ "ON j.contentid = a.contentid AND j.contentid=:contentid ",nativeQuery = true)
	public AttractionDTO jejuAttractionDetail(@Param("contentid") int contentid);
	
}
