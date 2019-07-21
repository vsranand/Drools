package com.nttdata.cto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nttdata.cto.domain.City;
import com.nttdata.cto.domain.Country;
import com.nttdata.cto.domain.CountryLanguage;
import com.nttdata.cto.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	CountryRepository countryRepository;

	@Transactional(readOnly=true)
	public Country getCountry(String code) {
		Optional<Country> countryOp = countryRepository.findById(code);
		Country country = countryOp.get();
		//This private method code is executed to load all the child objects.
		//If this method is not called then none of the child objects will be available in result
		loadCities(country);
		loadLangauges(country);

		return country;
	}

	@Transactional(readOnly=true)
	public List<Country> getAllCountries() {
		List<Country> countryList = (List<Country>) countryRepository.findAll();
		for (Country country : countryList) {
			loadCities(country);
			loadLangauges(country);
		}
		return countryList;
	}

	private void loadLangauges(Country country) {
		List<CountryLanguage> languages = country.getLanguages();
		if (languages!=null) {
			for (CountryLanguage language : languages) {
				//Do Something
			}
		}		
	}

	private void loadCities(Country country) {
		List<City> cities = country.getCities();
		if (cities!=null) {
			for (City city : cities) {
				//Do Something
			}
		}
	}

}
