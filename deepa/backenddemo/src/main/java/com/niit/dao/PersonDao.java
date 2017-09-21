package com.niit.dao;

import java.util.List;

import com.niit.model.Person;

public interface PersonDao {
	
		List<Person> getAllPersons();
		void savePerson(Person person); 
		void updatePerson(Person person); //update person set firstname=?,... where id=?
		void deletePerson(int id); //delete from person where id=?
		Person getPersonById(int id);
		
		}

