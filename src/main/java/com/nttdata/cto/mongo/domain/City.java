package com.nttdata.cto.mongo.domain;

public class City {

	private Integer cityId;

	private String name;

	private String countryCode;

	private String district;

	private Float population;

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Float getPopulation() {
		return population;
	}

	public void setPopulation(Float population) {
		this.population = population;
	}

}
