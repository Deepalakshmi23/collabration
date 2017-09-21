package com.niit.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.job;
@Repository
@Transactional
public class jobdaoimpl implements Jobdao
{

	@Autowired
	private SessionFactory sessionFactory;

	public void saveJob(job job) {
		Session session=sessionFactory.getCurrentSession();
		session.save(job);
}
}