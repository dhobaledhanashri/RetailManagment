package com.demo.convertor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import com.fasterxml.jackson.databind.ObjectMapper;




public class AddressConverter {

	private static final String URL = "http://maps.googleapis.com/maps/api/geocode/json";
	public GoogleResponse convertToLatLong(String fullAddress) throws IOException {

		  URL url = new URL(URL + "?address="
		    + URLEncoder.encode(fullAddress, "UTF-8") + "&sensor=false");
		  // Open the Connection
		  URLConnection conn = url.openConnection();

		  InputStream in = conn.getInputStream() ;
		  ObjectMapper mapper = new ObjectMapper();
		  GoogleResponse response = (GoogleResponse)mapper.readValue(in,GoogleResponse.class);
		  in.close();
		  return response;
		  

		 }
		 

	public GoogleResponse convertFromLatLong(String latlongString) throws IOException {

		
		  URL url = new URL(URL + "?latlng="
		    + URLEncoder.encode(latlongString, "UTF-8") + "&sensor=false");
		  // Open the Connection
		  URLConnection conn = url.openConnection();

		  InputStream in = conn.getInputStream() ;
		  ObjectMapper mapper = new ObjectMapper();
		  GoogleResponse response = (GoogleResponse)mapper.readValue(in,GoogleResponse.class);
		  in.close();
		  return response;
		  

		 }
	public static void main(String[] args) throws IOException {
			  
		/*  GoogleResponse res = new AddressConverter().convertToLatLong("mahalaxmi vihar,vishrantwadi");
		  if(res.getStatus().equals("OK"))
		  {
		   for(Result result : res.getResults())
		   {
		    System.out.println("Lattitude of address is :"  +result.getGeometry().getLocation().getLat());
		    System.out.println("Longitude of address is :" + result.getGeometry().getLocation().getLng());
		    System.out.println("Location is " + result.getGeometry().getLocation_type());
		    System.out.println("Address is " + result.getFormatted_address());
		   }
		  }
		  else
		  {
		   System.out.println(res.getStatus());
		  }*/
		  String a= "18.5717177,73.8780629";
		  System.out.println("\n now will find address from longtiude and lattitude...");
		  GoogleResponse res1 = new AddressConverter().convertFromLatLong(a);
		  if(res1.getStatus().equals("OK"))
		  {
		   for(Result result : res1.getResults())
		   {
		    System.out.println("address is :"  +result.getFormatted_address());
		    //System.out.println(" postal code is : "+result);
		   }
		  }
		  else
		  {
		   System.out.println(res1.getStatus());
		  }
		  
		
	}

}
