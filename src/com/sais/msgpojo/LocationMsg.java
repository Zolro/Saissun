package com.sais.msgpojo;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;
import org.hibernate.annotations.GenericGenerator;

@XmlRootElement(name="xml")
@XmlType(propOrder={"even","latitude","longitude","precision"})
public class LocationMsg extends Msg {
	private int pkey;
	private String Event;
	private Double Latitude;
	private Double Longitude;
	private Double Precision;
	public LocationMsg() {
		super();
	}
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@XmlTransient
	public int getPkey() {
		return pkey;
	}
	public void setPkey(int pkey) {
		this.pkey = pkey;
	}
	@XmlElement(name="Event")
	@XmlCDATA
	public String getEvent() {
		return Event;
	}
	@XmlElement(name="Latitude")
	public Double getLatitude() {
		return Latitude;
	}
	@XmlElement(name="Longitude")
	public Double getLongitude() {
		return Longitude;
	}
	@XmlElement(name="Precision")
	public Double getPrecision() {
		return Precision;
	}
	public void setEvent(String event) {
		Event = event;
	}
	public void setLatitude(Double latitude) {
		Latitude = latitude;
	}
	public void setLongitude(Double longitude) {
		Longitude = longitude;
	}
	public void setPrecision(Double precision) {
		Precision = precision;
	}
	
}
