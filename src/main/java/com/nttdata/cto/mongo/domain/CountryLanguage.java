package com.nttdata.cto.mongo.domain;

import com.nttdata.cto.domain.Official;

public class CountryLanguage {

	private String countryCode;

	private String language;

	private Official isOfficial;

	private float percentage;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Official getIsOfficial() {
		return isOfficial;
	}

	public void setIsOfficial(Official isOfficial) {
		this.isOfficial = isOfficial;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}


}
