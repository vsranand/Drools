package com.nttdata.cto.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.cto.domain.City;
import com.nttdata.cto.domain.Country;
import com.nttdata.cto.domain.CountryLanguage;
import com.nttdata.cto.dto.CityDTO;
import com.nttdata.cto.dto.CountryDTO;
import com.nttdata.cto.dto.CountryLanguageDTO;
import com.nttdata.cto.service.CountryService;

@RestController
@RequestMapping("/api/v1/country")
public class CountryRestController {

	@Autowired
	public CountryService countryService;

	@GetMapping("/{code}")
	public CountryDTO getCountry(@PathVariable String code) {
		Country country = countryService.getCountry(code);
		return getCountryDTO(country);
	}

	@GetMapping("/list")
	public List<CountryDTO> getCountries() {
		List<CountryDTO> countryDTOList = new ArrayList<>();
		List<Country> countryList = countryService.getAllCountries();
		for (Country country : countryList) {
			countryDTOList.add(getCountryDTO(country));
		}
		return countryDTOList;
	}

	//TODO:Later use mapper tool like Dozer
	private CountryDTO getCountryDTO(Country country) {
		CountryDTO countryDTO = new CountryDTO();
		countryDTO.setCode(country.getCode());
		countryDTO.setName(country.getName());
		if (Hibernate.isInitialized(country.getCities())) {
			List<CityDTO> cityDTOs = new ArrayList<CityDTO>();
			List<City> cities = country.getCities();
			if (cities!=null) {
				for (City city : cities) {
					CityDTO cityDTO = new CityDTO();
					cityDTO.setId(city.getId());
					cityDTO.setName(city.getName());
					cityDTO.setCountryCode(city.getCountryCode());
					cityDTO.setDistrict(city.getDistrict());
					cityDTO.setPopulation(city.getPopulation());
					cityDTOs.add(cityDTO);
				}
			}
			countryDTO.setCities(cityDTOs);
		}
		if (Hibernate.isInitialized(country.getLanguages())) {
			List<CountryLanguageDTO> languageDTOs = new ArrayList<>();
			List<CountryLanguage> languages = country.getLanguages();
			if (languages!=null) {
				for (CountryLanguage language : languages) {
					CountryLanguageDTO languageDTO = new CountryLanguageDTO();
					languageDTO.setCountryCode(language.getCountryCode());
					languageDTO.setIsOfficial(language.getIsOfficial());
					languageDTO.setLanguage(language.getLanguage());
					languageDTO.setPercentage(language.getPercentage());
					languageDTOs.add(languageDTO);
				}
			}
			countryDTO.setLanguages(languageDTOs);
		}
		return countryDTO;
	}

}
