package com.niit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.dao.PersonDao;
import com.niit.model.Person;

@Controller
public class PersonControllers {
	@Autowired
	private PersonDao personDao;
	@RequestMapping(value="/getallpersons",method=RequestMethod.GET)
	public  ResponseEntity<List<Person>> getAllPersons(){
		List<Person> persons=personDao.getAllPersons();
		if(persons.size()>0)
		return new ResponseEntity<List<Person>>(persons,HttpStatus.OK);
		return new ResponseEntity<List<Person>>(HttpStatus.NO_CONTENT);
	}
	@RequestMapping(value="/saveperson",method=RequestMethod.POST)
	public ResponseEntity<Person> savePerson(@RequestBody Person person){
		personDao.savePerson(person);
		return new ResponseEntity<Person>(person,HttpStatus.CREATED);
	}
	@RequestMapping(value="/getpersonbyid/{id}",method=RequestMethod.GET)
	public ResponseEntity<Person> getPersonById(@PathVariable int id){
		Person person=personDao.getPersonById(id);
		return new ResponseEntity<Person>(person,HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateperson",method=RequestMethod.PUT)
	public ResponseEntity<Person> updatePerson(@RequestBody Person person){
		personDao.updatePerson(person);
		return new ResponseEntity<Person>(person,HttpStatus.OK);
	}
	@RequestMapping(value="/deleteperson/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletePerson(@PathVariable int id)
	{
		personDao.deletePerson(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}


}
