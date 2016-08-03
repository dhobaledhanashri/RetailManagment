package com.demo.bean;

public class Retailer {
	
	private int shopId;
	private String shopName;
	//private ShopAddress shopAddress ;
	
	
	/*public Retailer(int shopId,String shopName, ShopAddress shopAddress) {
		super();
		this.shopId= shopId;
		this.shopName = shopName;
		this.shopAddress = shopAddress;
	}*/
	private int number;
	private int postalCode;
	private String addressName;
	
	/*private String longtitude;
	private String lattitude;*/
	private double longtitude;
	private double lattitude;
	
	public Retailer(){
		super();
	}
	public Retailer( String shopName, int number, String addressName,int postalCode) {
		super();
		this.shopName = shopName;
		this.number = number;
		this.addressName = addressName;
		this.postalCode = postalCode;
		
	}
	public Retailer( int shopId,String shopName, int number, String addressName,int postalCode,double lattitude,double longtitude) 
	{
		super();
		this.shopId=shopId;
		this.shopName = shopName;
		this.number = number;
		this.addressName = addressName;
		this.postalCode = postalCode;
		this.lattitude=lattitude;
		this.longtitude = longtitude;
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
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public double getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}
	public double getLattitude() {
		return lattitude;
	}
	public void setLattitude(double lattitude) {
		this.lattitude = lattitude;
	}
	
	/*public String getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}
	public String getLattitude() {
		return lattitude;
	}
	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}*/
	/*public ShopAddress getShopAddress() {
		return shopAddress;
	}
	public void setShopAddress(ShopAddress shopAddress) {
		this.shopAddress = shopAddress;
	}*/
	
}
