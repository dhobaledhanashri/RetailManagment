package com.demo.bean;

public class ShopAddress {
	
	private int number;
	private int postalCode;
	private String addressName;
	
	
	public ShopAddress(int number,String addressName, int postalCode)
	{
		this.number= number;
		this.addressName=addressName;
		this.postalCode=postalCode;
		
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	
	

}
