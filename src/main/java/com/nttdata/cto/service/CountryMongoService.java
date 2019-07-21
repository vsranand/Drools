package com.nttdata.cto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.cto.mongo.domain.Country;
import com.nttdata.cto.repository.CountryMongoRepository;

@Service
public class CountryMongoService {

	@Autowired
	CountryMongoRepository countryMongoRepository;

	public Country getCountry(String code) {
		Country country = countryMongoRepository.findByCode(code);
		return country;
	}

	public List<Country> getAllCountries() {
		List<Country> countryList = countryMongoRepository.findAll();
		for (Country country : countryList) {
		}
		return countryList;
	}

}
