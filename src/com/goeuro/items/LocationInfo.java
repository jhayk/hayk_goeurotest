package com.goeuro.items;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by hayk on 1/23/15.
 */
public class LocationInfo {
	@JsonProperty(value = "_id")
	private long id;
	private String key;
	private String name;
	private String fullName;
	@JsonProperty(value = "iata_airport_code")
	private String airportCode;
	//will be better to replace type with enum,
	// but as we don't have all types, go with string...
	private String type;
	private String country;
	@JsonProperty(value = "geo_position")
	private GeoPosition geoPosition;
	private long locationId;
	private boolean inEurope;
	private String countryCode;
	private boolean coreCountry;
	private int distance;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public GeoPosition getGeoPosition() {
		return geoPosition;
	}

	public void setGeoPosition(GeoPosition geoPosition) {
		this.geoPosition = geoPosition;
	}

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public boolean isInEurope() {
		return inEurope;
	}

	public void setInEurope(boolean inEurope) {
		this.inEurope = inEurope;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public boolean isCoreCountry() {
		return coreCountry;
	}

	public void setCoreCountry(boolean coreCountry) {
		this.coreCountry = coreCountry;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
}
