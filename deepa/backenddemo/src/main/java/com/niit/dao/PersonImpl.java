package com.niit.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;


import com.niit.dao.PersonDao;
import com.niit.model.Person;
@Repository
@Transactional
public class PersonImpl implements PersonDao {
	@Autowired
private SessionFactory sessionFactory;
	public List<Person> getAllPersons() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Person");
		return query.list();
	}
	public void savePerson(Person person) {
		Session session=sessionFactory.getCurrentSession();
		session.save(person);
		
	}
	public void updatePerson(Person person) {
		Session session=sessionFactory.getCurrentSession();
		session.update(person);
	}
	public void deletePerson(int id) {
		Session session=sessionFactory.getCurrentSession();
		Person person=(Person)session.get(Person.class, id);
		session.delete(person);//delete from  person where id=?
	}
	public Person getPersonById(int id) {
		Session session=sessionFactory.getCurrentSession();
		Person person=(Person)session.get(Person.class,id);
		return person;
	}
}