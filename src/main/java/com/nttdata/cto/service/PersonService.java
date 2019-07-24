package com.nttdata.cto.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.cto.model.Person;

@Service
public class PersonService {

	private final KieContainer kieContainer;

	@Autowired
	public PersonService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}

	public Person getDiscount(Person person) {
		KieSession kieSession = kieContainer.newKieSession("DiscountSession");
		kieSession.insert(person);
		kieSession.fireAllRules();
		kieSession.dispose();
		return person;
	}

}
