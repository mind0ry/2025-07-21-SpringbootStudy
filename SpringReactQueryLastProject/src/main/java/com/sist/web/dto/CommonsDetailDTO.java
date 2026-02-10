package com.sist.web.dto;
/*
 * private int contentid;
	
	private int no;
	private String title;
	private String image1;
	private String image2;
	
	private String address;
	private double x,y;
	private int contenttype, hit;
 */
public interface CommonsDetailDTO {
	public int getContentid();
	public String getTitle();
	public String getImage1();
	public String getAddress();
	public double getX();
	public double getY();
	public int getContenttype();
	public int getHit();
	
}
