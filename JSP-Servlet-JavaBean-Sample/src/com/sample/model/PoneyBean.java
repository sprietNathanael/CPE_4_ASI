package com.sample.model;

import java.io.Serializable;

public class PoneyBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String color;
	private String superPower;
	private String name;
	private String imgUrl;

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public PoneyBean() {
		this.color = "";
		this.superPower = "";
		this.name = "";
		this.imgUrl="";
	}
	
	public PoneyBean(String name,String color,String superPower, String imgUrl) {
		this.color = color;
		this.superPower = superPower;
		this.name = name;
		this.imgUrl=imgUrl;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSuperPower() {
		return superPower;
	}

	public void setSuperPower(String superPower) {
		this.superPower = superPower;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;	
	}

}
