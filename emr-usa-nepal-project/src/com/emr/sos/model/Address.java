/*
 * @AUTHOR: Prakash Shiwakoti
 */
package com.emr.sos.model;

public class Address {
	
	private String postalCode;
	private String cityName;
	private String streetName;
	private String latitudeLongitude[] ={};
	private long phoneNumber;
	private double distance;
	
	public Address(){
		
	}
	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String[] getLatitudeLongitude() {
		return latitudeLongitude;
	}

	public void setLatitudeLongitude(String[] latitudeLongitude) {
		this.latitudeLongitude = latitudeLongitude;
	}
	
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public double getDistance() throws Exception{
		
		 String sr = "K";
		CalculateDistanceBetweenLatLong calcDist = new CalculateDistanceBetweenLatLong();
		//distance between New Baneswor and Putalisadak
		distance = calcDist.distance(27.69, 85.0, 27.7, 85.3, sr);
		System.out.println(latitudeLongitude[0] + " " + latitudeLongitude[1] +" - " + "27.7" + " 85.3");
		System.out.println("The distance between hospital and ambulance is " + distance + " miles");
		
		return distance;
	}
	
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	
}
