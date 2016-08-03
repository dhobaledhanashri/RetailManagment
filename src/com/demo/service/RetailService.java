package com.demo.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.omg.CORBA.TRANSIENT;

import com.demo.bean.Retailer;
import com.demo.controller.RetailManagementController;
import com.demo.convertor.AddressConverter;
import com.demo.convertor.GoogleResponse;
import com.demo.convertor.Result;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class RetailService {
	
	 static transient HashMap<Integer,Retailer> shopMap=getShopMap();
	
	public static HashMap<Integer, Retailer> getShopMap() { 
		return shopMap; 
		}
	
	public static int getMaxId() {
		int max=0; 
		for (int id:shopMap.keySet()) 
		{ 
			if(max<=id) max=id; 
		} 
		return max; 
		}
	
	public RetailService() { 
		super(); 
		if(shopMap==null) 
		{ 
			shopMap=new HashMap<Integer,Retailer>(); 
			/*shopMap.put(1,new Retailer("HariOm",1,"mahalaxmi vihar Vishrantwadi",411015));
			shopMap.put(2,new Retailer("Dmart",2," Kalayninagr",411014));
			shopMap.put(3,new Retailer("SmartBAZAaR",3,"  Dhanori Rd",411015));
			shopMap.put(4,new Retailer("Bigbazar",4,"chinchwad",411019));*/
			shopMap.put(1, new Retailer(1,"Dmart", 11, "kalyaninagar", 411014,
					18.5574028, 73.92830049999999));
			shopMap.put(2, new Retailer(2,"Monginis", 12,
					"near FC Road, Shivajinagar", 411005, 18.5308225, 73.8474647));
			shopMap.put(3, new Retailer(3,"MechD", 10, "jm road,pune", 411005,
					18.5293345, 73.8528475));
			shopMap.put(4, new Retailer(4,"Agatya Restaurant", 13,
					"Porwal Road, Lohgaon", 411047, 18.6147319, 73.91206079999999));
			shopMap.put(5,
					new Retailer(5,"Abhiruchi Restaurant", 14,
							"Airport Road, Yerawada", 411006, 18.5598098,
							73.89160869999999));
			shopMap.put(6, new Retailer(6,"The Westin", 15, " Koregaon Park, Pune",
					411047, 18.5308902, 73.9119329));
			shopMap.put(7, new Retailer(7,"Bigbazar", 16, " chinchwad, Pune",
					411019, 18.645919, 73.80073399999999));
			shopMap.put(8, new Retailer(8,"SmartBazaar", 20, "Dhnaori road, Pune",
					411015,  18.5968742, 73.8991259));
		} 
		}
		
	public static Retailer addShop(Retailer r) 
	{ 
		try {
			System.out.println("addshop method/......");
		r.setShopId((getMaxId()+1)); 
		
		System.out.println("Calling geocode........");
		 GoogleResponse res = new AddressConverter().convertToLatLong(r.getAddressName());
		  if(res.getStatus().equals("OK"))
		  {
		   for(Result result : res.getResults())
		   {
		    System.out.println("1.Lattitude of address is :"  +result.getGeometry().getLocation().getLat());
		    r.setLattitude(result.getGeometry().getLocation().getLat());
		    System.out.println("2.Longitude of address is :" + result.getGeometry().getLocation().getLng());
		    r.setLongtitude(result.getGeometry().getLocation().getLng());
		    System.out.println("Location is " + result.getGeometry().getLocation_type());
		    System.out.println("Address is " + result.getFormatted_address());
		   }
		  }
		  else
		  {
		   System.out.println(res.getStatus());
		  }
		  shopMap.put(r.getShopId(), r); 
		} catch (Exception e) {
			// TODO Auto-generated catch block88
			e.printStackTrace();
		}
		return r; 
	}

	public List<Retailer> getAllShopDetails() {
		System.out.println("map size: "+getShopMap().size());
		//List<Retailer> al = new ArrayList<Retailer>(getShopMap().values()); 
		List<Retailer> al = new ArrayList<Retailer>((Collection<? extends Retailer>) getShopMap().entrySet());
		System.out.println("list size is:::"+al.size());
		/*Iterator itr  = al.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}*/
		return al;
	}

	public List<Retailer>  getNearestShop(double custLatitude,double custLongtitude) {
		// TODO Auto-generated method stub
		System.out.println("getNearestShop() method called "+custLatitude+" "+custLongtitude);
		/*double custlat1 = 18.522377;
		double custlng1 = 73.84902;
*/
		int min = Integer.MAX_VALUE;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (Entry<Integer, Retailer> entry : shopMap.entrySet()) {
			System.out.println(entry.getKey() + "-"
					+ entry.getValue().getLattitude() + "-"
					+ entry.getValue().getLongtitude() + "-"
					+ entry.getValue().getShopName());
			int distance = DistanceCalculator.calculateDistance(custLatitude, custLongtitude, entry
					.getValue().getLattitude(), entry.getValue()
					.getLongtitude());
			System.out.println("disatnce between 2 lat n lng in meters is: "
					+ distance + " for shop map name : "
					+ entry.getValue().getShopName());
			hm.put(distance, entry.getKey());
			if (distance < min) {
				min = distance;
			}
			System.out.println("min is: " + min);
			System.out.println("\n");
		}
		System.out.println("Smallest distance is : " + min);
		System.out.println("getshopid for minimum distance calculated:: "
				+ hm.get(min));
		System.out
				.println("get shop details for minimum distance calculated:: "
						+ shopMap.get(hm.get(min)).getShopName() + " "
						+ shopMap.get(hm.get(min)).getAddressName() + " "
						+ shopMap.get(hm.get(min)).getPostalCode() + " "
						+ shopMap.get(hm.get(min)).getLattitude() + " "
						+ shopMap.get(hm.get(min)).getLongtitude());
		Retailer r = new Retailer();
		r.setShopId(hm.get(min));
		r.setShopName(shopMap.get(hm.get(min)).getShopName());
		r.setAddressName(shopMap.get(hm.get(min)).getAddressName());
		r.setPostalCode(shopMap.get(hm.get(min)).getPostalCode());
		r.setLattitude(shopMap.get(hm.get(min)).getLattitude());
		r.setLongtitude(shopMap.get(hm.get(min)).getLongtitude());
	List<Retailer> al = new ArrayList<Retailer>();
	al.add(r);
		return al;
	}
}
