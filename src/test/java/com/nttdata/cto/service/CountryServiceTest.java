package com.nttdata.cto.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.nttdata.cto.domain.Country;
import com.nttdata.cto.dto.CountryDTO;
import com.nttdata.cto.repository.CountryRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CountryServiceTest {

	@InjectMocks
	CountryService countryService;

	@Mock
	CountryRepository countryRepository;

	@Test
	public void getCountryTest() {
		final Optional<Country> expectedValue = Optional.of(new Country());
		when(countryRepository.findById(anyString())).thenReturn(expectedValue);
		final CountryDTO expectedCountry = new CountryDTO();
		CountryDTO country = countryService.getCountry(anyString());
		assertEquals("Country",country,expectedCountry);
	}

	@Test
	public void getAllCountriesTest() {
		final List<Country> expectedList = new ArrayList<>();
		when(countryRepository.findAll()).thenReturn(expectedList);
		List<CountryDTO> countryList = countryService.getAllCountries();
		assertEquals("Country",countryList,expectedList);
	}

}
