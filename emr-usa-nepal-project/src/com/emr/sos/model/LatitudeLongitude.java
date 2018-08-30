/*
 * @AUTHOR: Prakash Shiwakoti
 */

package com.emr.sos.model;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathConstants;
import org.w3c.dom.Document;
public class LatitudeLongitude {

	private String latitude;
	private String longitude;
	private String city;
	private String postalCode;
	
	//constructors
	public LatitudeLongitude() throws Exception{
		
	}
	public LatitudeLongitude( String postalCode,String city) throws Exception{
		this.city = city;
		this.postalCode=postalCode;
	}
		
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
public static String[] getLatLongPositions(String postalCode, String city) throws Exception
	  {
	    int responseCode = 0;
	    String api = "http://maps.googleapis.com/maps/api/geocode/xml?address=" + URLEncoder.encode(postalCode, "UTF-8") + "&sensor=true";
	    URL url = new URL(api);
	    HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
	    httpConnection.connect();
	    responseCode = httpConnection.getResponseCode();
	    if(responseCode == 200)
	    {
	      DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();;
	      Document document = builder.parse(httpConnection.getInputStream());
	      XPathFactory xPathfactory = XPathFactory.newInstance();
	      XPath xpath = xPathfactory.newXPath();
	      XPathExpression expr = xpath.compile("/GeocodeResponse/status");
	      String status = (String)expr.evaluate(document, XPathConstants.STRING);
	      if(status.equals("OK"))
	      {
	         expr = xpath.compile("//geometry/location/lat");
	         String latitude1 = (String)expr.evaluate(document, XPathConstants.STRING);
	         LatitudeLongitude ll = new LatitudeLongitude();
	         ll.setLatitude(latitude1); 
	         expr = xpath.compile("//geometry/location/lng");
	         String longitude1 = (String)expr.evaluate(document, XPathConstants.STRING);
	         ll.setLongitude(longitude1);
	         return new String[] {latitude1, longitude1};
	      }
	      else
	      {
	         throw new Exception("Error from the API - response status: "+status);
	      }
	    }
	    return null;
	  }
	  
	  
}