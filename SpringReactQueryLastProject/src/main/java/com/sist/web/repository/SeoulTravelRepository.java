package com.sist.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sist.web.entity.SeoulTravel;
import com.sist.web.dto.*;
import java.util.*;

public interface SeoulTravelRepository extends JpaRepository<SeoulTravel, Integer> {

	// MainData => 1
	@Query(value = "SELECT contentid,title,address,image1,hit,contenttype "
			+ "FROM seoultravel "
			+ "ORDER BY contentid ASC "
			+ "OFFSET 0 ROWS FETCH NEXT 1 ROWS ONLY", nativeQuery = true)
	/*
	 *   SELECT contentid,title,address,image1,hit,contenttype
	 *   FROM seoultravel
	 *   ORDER BY contentid ASC
	 *   LIMIT 0,1
	 */
	public CommonsDTO seoulMainData();
	// runtimeOnly 'com.mysql:mysql-connector-j'
	@Query(value = "SELECT contentid,title,address,image1,hit,contenttype "
			+ "FROM seoultravel "
			+ "ORDER BY hit DESC "
			+ "OFFSET 0 ROWS FETCH NEXT 4 ROWS ONLY", nativeQuery = true)
	public List<CommonsDTO> seoulListData4(); 
	// Seoul => 4
	// Jeju => 4
	// Busan => 10 
}
