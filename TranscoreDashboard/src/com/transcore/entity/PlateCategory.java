package com.transcore.entity;

public class PlateCategory {
	
	private short tiPlateCategoryID;
	private String vcPlateCategoryDesc;
	private short tiDisplayOrder;
	private String nvcPlateCategArbDesc;
	
	public short getPlateCategoryID() {
		return this.tiPlateCategoryID;
	}
	
	public void setPlateCategoryID(short id) {
		tiPlateCategoryID = id;
	}
	
	public String getPlateCategoryDesc() {
		return this.vcPlateCategoryDesc;
	}
	
	public void setPlateCategoryDesc(String plateCategoryDesc) {
		vcPlateCategoryDesc = plateCategoryDesc;
	}
	
	public short getDisplayOrder() {
		return tiDisplayOrder;
	}
	
	public void setDisplayOrder(short displayOrder) {
		tiDisplayOrder = displayOrder;
	}
	
	
	public String getPlateCategoryArbDesc(){
		return nvcPlateCategArbDesc;
	}
	
	public void setPlateCategoryArbDesc(String desc) {
		nvcPlateCategArbDesc = desc;
	}
	
}
