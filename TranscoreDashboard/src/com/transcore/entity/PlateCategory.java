package com.transcore.entity;

public class PlateCategory {
	
	private short plateCategoryId;
	private String plateCategoryDesc;
	private short displayOrder;
	private String plateCategArbDesc;
	
	public short getPlateCategoryId() {
		return this.plateCategoryId;
	}
	
	public void setPlateCategoryId(short id) {
		plateCategoryId = id;
	}
	
	
	
	
	public String getPlateCategoryDesc() {
		return this.plateCategoryDesc;
	}
	
	public void setPlateCategoryDesc(String plateCategoryDesc) {
		this.plateCategoryDesc = plateCategoryDesc;
	}
	
	
	
	
	public short getDisplayOrder() {
		return displayOrder;
	}
	
	public void setDisplayOrder(short displayOrder) {
		this.displayOrder = displayOrder;
	}
	
	
	
	
	
	public String getPlateCategArbDesc(){
		return plateCategArbDesc;
	}
	
	public void setPlateCategArbDesc(String plateCategArbDesc) {
		this.plateCategArbDesc = plateCategArbDesc;
	}
	
}
