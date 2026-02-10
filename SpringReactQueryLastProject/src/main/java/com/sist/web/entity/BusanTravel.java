package com.sist.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "busantravel")
@Data
public class BusanTravel {

	@Id
	@Column(name="contentid")
	private int contentid;
	
	private int no;
	private String title;
	private String image1;
	private String image2;
	
	private String address;
	private double x,y;
	private int contenttype, hit;
}
