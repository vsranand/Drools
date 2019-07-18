package com.nttdata.cto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nttdata.cto.domain.City;
import com.nttdata.cto.domain.Country;
import com.nttdata.cto.dto.CityDTO;
import com.nttdata.cto.dto.CountryDTO;
import com.nttdata.cto.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	CountryRepository countryRepository;

	@Transactional
	public CountryDTO getCountry(String code) {
		Optional<Country> countryOp = countryRepository.findById(code);
		Country country = countryOp.get();
/*		List<City> cities = country.getCities();
		if (cities!=null) {
			for (City city : cities) {
				System.out.println(city.getName());
			}
		}
*/		return getCountryDTO(country);
	}

	public List<CountryDTO> getAllCountries() {
		List<CountryDTO> countryDTOList = new ArrayList<>();
		List<Country> countryList = (List<Country>) countryRepository.findAll();
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
					cityDTOs.add(cityDTO);
				}
			}
			countryDTO.setCities(cityDTOs);
		}
		return countryDTO;
	}

}
