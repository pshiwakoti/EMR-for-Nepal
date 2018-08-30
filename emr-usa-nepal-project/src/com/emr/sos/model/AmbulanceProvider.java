/*
 * @AUTHOR: Prakash Shiwakoti
 */
package com.emr.sos.model;

public class AmbulanceProvider{
	private String companyName;
	private Address address;
	private boolean availability;
	private int fees;
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


	public AmbulanceProvider() throws Exception{}

public AmbulanceProvider(String companyName, Address address, boolean availability, int fees) {
		super();
		this.companyName = companyName;
		this.address = address;
		this.availability = availability;
		this.fees = fees;
	}
}


	
	
	
