package com.demo.service;

import java.util.HashMap;
import java.util.Map.Entry;
import com.demo.bean.Retailer;

public class DistanceCalculator {
	public final static double AVERAGE_RADIUS_OF_EARTH = 6371;

	public static int calculateDistance(double userLat, double userLng,
			double venueLat, double venueLng) {
		double latDistance = Math.toRadians(userLat - venueLat);
		double lngDistance = Math.toRadians(userLng - venueLng);
		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
				+ Math.cos(Math.toRadians(userLat))
				* Math.cos(Math.toRadians(venueLat))
				* Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		System.out
				.println("dist is ?: " + (AVERAGE_RADIUS_OF_EARTH * c) * 1000);
		// return (int) (Math.round(AVERAGE_RADIUS_OF_EARTH * c));
		return (int) ((AVERAGE_RADIUS_OF_EARTH * c) * 1000);
	}

	public static void main(String[] args) {
		HashMap<Integer, Retailer> shopMap = new HashMap<Integer, Retailer>();
		/*shopMap.put(1, new Retailer("Dmart", 11, "kalyaninagar", 411014,
				18.5574028, 73.92830049999999));
		shopMap.put(2, new Retailer("Monginis", 12,
				"near FC Road, Shivajinagar", 411005, 18.5308225, 73.8474647));
		shopMap.put(3, new Retailer("MechD", 10, "jm road,pune", 411005,
				18.5293345, 73.8528475));
		shopMap.put(4, new Retailer("Agatya Restaurant", 13,
				"Porwal Road, Lohgaon", 411047, 18.6147319, 73.91206079999999));
		shopMap.put(5,
				new Retailer("Abhiruchi Restaurant", 14,
						"Airport Road, Yerawada", 411006, 18.5598098,
						73.89160869999999));
		shopMap.put(6, new Retailer("The Westin", 15, " Koregaon Park, Pune",
				411047, 18.5308902, 73.9119329));*/

		// balgandharv pune
		double custlat1 = 18.522377;
		double custlng1 = 73.84902;

		int min = Integer.MAX_VALUE;
		;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (Entry<Integer, Retailer> entry : shopMap.entrySet()) {
			System.out.println(entry.getKey() + "-"
					+ entry.getValue().getLattitude() + "-"
					+ entry.getValue().getLongtitude() + "-"
					+ entry.getValue().getShopName());
			int distance = calculateDistance(custlat1, custlng1, entry
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
		
	}

}
