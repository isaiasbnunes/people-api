package com.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.person.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
