package com.nttdata.cto.repository;

import org.springframework.data.repository.CrudRepository;

import com.nttdata.cto.domain.Country;

public interface CountryRepository extends CrudRepository<Country, String> {

}
