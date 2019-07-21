package com.nttdata.cto.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "countrylanguage")
@IdClass(CountryLanguageId.class)
public class CountryLanguage {

	@Id
	@Column(name = "CountryCode")
	private String countryCode;

	@Id
	@Column(name = "Language")
	private String language;

	@Enumerated(EnumType.STRING)
	@Column(name = "IsOfficial",length=1)
	private Official isOfficial;

	@Column(name="Percentage",precision=4,scale=1)
	private float percentage;

	public String getCountryCode() {
		return countryCode;
	}

	public CountryLanguage() {
	}

	public CountryLanguage(String countryCode, String language, Official isOfficial, float percentage) {
		this.countryCode = countryCode;
		this.language = language;
		this.isOfficial = isOfficial;
		this.percentage = percentage;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((isOfficial == null) ? 0 : isOfficial.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + Float.floatToIntBits(percentage);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CountryLanguage other = (CountryLanguage) obj;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		if (isOfficial != other.isOfficial)
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (Float.floatToIntBits(percentage) != Float.floatToIntBits(other.percentage))
			return false;
		return true;
	}

}
