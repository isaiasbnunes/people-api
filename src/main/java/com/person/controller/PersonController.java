package com.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.person.entity.Person;
import com.person.repository.PersonRepository;
import com.person.service.PersonService;


@RestController
@RequestMapping("/people")
public class PersonController {

	@Autowired
	private PersonService personService ; 
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Person newPerson(@RequestBody Person p) {
		return personService.save(p);
	}
	
	@GetMapping
	public List<Person> getPerson() {
		return personService.getAllPerson();
	}
	
}
