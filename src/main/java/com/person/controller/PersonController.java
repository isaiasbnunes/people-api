package com.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.person.entity.Person;
import com.person.exceptions.PersonNotfoundException;
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

	@GetMapping("/{id}")
	public Person getPersonById(@PathVariable Long id) throws PersonNotfoundException {
		return findPersonById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable  Long id) throws PersonNotfoundException {
		personService.delete(findPersonById(id));
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable  Long id, @RequestBody Person person) throws PersonNotfoundException {
		personService.update(id, person);
	}
	
	private Person findPersonById(Long id) throws PersonNotfoundException {
		return personService.getPersonById(id);
	}
	
}
