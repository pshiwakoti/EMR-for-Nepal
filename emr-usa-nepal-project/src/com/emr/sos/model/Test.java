package com.emr.sos.model;

public class Test {
	public static void main(String[] args) throws Exception {
		AmbulanceProvider ambProvider = new AmbulanceProvider();
		Address address = new Address();
		address.setCityName("New Baneswor");
		address.setPostalCode("100");
		ambProvider.setAddress(address);
		String temp[] = LatitudeLongitude.getLatLongPositions(address.getPostalCode(), address.getCityName());
		address.setLatitudeLongitude(temp);
		ambProvider.getAddress().getDistance();
	}
}
