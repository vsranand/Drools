package com.nttdata.cto.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.cto.domain.Country;
import com.nttdata.cto.dto.CountryDTO;
import com.nttdata.cto.service.CountryService;

@RestController
@RequestMapping("/api/v1/country")
public class CountryRestController {

	@Autowired
	public CountryService countryService;

	@GetMapping("/{code}")
	public CountryDTO getCountry(@PathVariable String code) {
		return countryService.getCountry(code);
	}

	@GetMapping("/list")
	public List<CountryDTO> getCountries() {
		return countryService.getAllCountries();
	}

}
