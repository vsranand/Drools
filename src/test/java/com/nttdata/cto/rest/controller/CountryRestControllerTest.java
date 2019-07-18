package com.nttdata.cto.rest.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nttdata.cto.dto.CountryDTO;
import com.nttdata.cto.service.CountryService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountryRestControllerTest {

	@InjectMocks
	CountryRestController countryRestController;

	@Mock
	CountryService countryService;

	@Test
	public void getCountryTest() {
		final CountryDTO expectedValue = new CountryDTO();
		final String code = "IND";
		when(countryService.getCountry(anyString())).thenReturn(expectedValue);
		
		CountryDTO actualValue = countryRestController.getCountry(code);
		
		assertEquals("ApplicationName",actualValue,expectedValue);
		
	}
	
}
