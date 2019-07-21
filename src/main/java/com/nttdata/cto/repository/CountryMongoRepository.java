package com.nttdata.cto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.cto.mongo.domain.Country;

@Repository
public interface CountryMongoRepository extends MongoRepository<Country, String> {

	Country findByCode(String code);
}
