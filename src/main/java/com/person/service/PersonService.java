package com.person.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.person.entity.Person;
import com.person.exceptions.PersonNotfoundException;
import com.person.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository; 
	
	
	public Person save( Person p) {
		return personRepository.save(p);
	}
	
	public List<Person> getAllPerson() {
		return personRepository.findAll();
	}
	
	public Person getPersonById(Long id) throws PersonNotfoundException {
		
		Optional<Person> optPerson = personRepository.findById(id);
		
		if(optPerson.isEmpty()) {
			throw new PersonNotfoundException(id); 
		}
		
		return personRepository.findById(id).get();
	}
	

	public void update(Long id, Person person) throws PersonNotfoundException {
		    getPersonById(id);
			save(person);	
	}
	
	public void delete(Person p) {
		personRepository.delete(p);
	}
	
}
