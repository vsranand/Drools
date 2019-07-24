package com.nttdata.cto.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.cto.model.Person;
import com.nttdata.cto.service.PersonService;

@RestController
@RequestMapping("/api/v1/person")
public class PersonRestDroolsController {

	@Autowired
	public PersonService personService;

	@GetMapping("/discount")
	public Person getDiscount(@RequestParam String name,@RequestParam Integer age) {
		Person person = new Person();
		person.setName(name);
		person.setAge(age);
		return personService.getDiscount(person);
	}

}
