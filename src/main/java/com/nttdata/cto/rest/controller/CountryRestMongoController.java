package com.nttdata.cto.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.cto.mongo.domain.Country;
import com.nttdata.cto.service.CountryMongoService;

@RestController
@RequestMapping("/api/v1/mongo/country")
public class CountryRestMongoController {

	@Autowired
	public CountryMongoService countryMongoService;

	@GetMapping("/{code}")
	public Country getCountry(@PathVariable String code) {
		Country country = countryMongoService.getCountry(code);
		return country;
	}

	@GetMapping("/list")
	public List<Country> getCountries() {
		List<Country> countryList = countryMongoService.getAllCountries();
		return countryList;
	}

}
