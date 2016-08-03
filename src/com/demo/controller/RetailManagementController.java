package com.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bean.Retailer;
import com.demo.bean.ShopAddress;
import com.demo.service.RetailService;

@RestController
public class RetailManagementController {
	RetailService rs = new RetailService();

	//public static transient HashMap<Integer, Retailer> shopMap = new HashMap<Integer, Retailer>();

	@RequestMapping(value = "/addShop", method = RequestMethod.POST, headers = "Accept=application/json")
	public Retailer addShopDetails(@RequestBody Retailer r) {
		return RetailService.addShop(r);
	}
	/*@RequestMapping(value = "/findNearestShop1", method = RequestMethod.POST, headers = "Accept=application/json")
	public String getNearestShopDetails( double lattitude, double longtitude) {
		List<Retailer> listOfShop = rs.getNearestShop(lattitude,longtitude);
		return "method8 with id= "+lattitude+" and longtitude="+longtitude;
	}
	*/
	@RequestMapping(value="/findNearestShop/{lattitude}/{longtitude}/" ,method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public List<Retailer> getNearestShopDetails(@PathVariable("lattitude") double lattitude, @PathVariable("longtitude") double longtitude){
		System.out.println("inside getNearestShopDetails..");
		//String s = rs.getNearestShop(lattitude, longtitude);
		List<Retailer> nearestShop = rs.getNearestShop(lattitude, longtitude);
		//return "method8 with id= "+lattitude+" and longtitude="+longtitude+"shopname= "+s;
		return nearestShop;
	}
	
	
	@RequestMapping(value = "/getShopDetails", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Retailer> getShopDetails() {
		List<Retailer> listOfShop = rs.getAllShopDetails();
		return listOfShop;
	}

}
