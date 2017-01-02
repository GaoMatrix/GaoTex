package com.gao.test.dao.impl;

import java.io.Serializable;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gao.test.dao.ITestDao;
import com.gao.test.entity.Person;

public class TestDaoImpl extends HibernateDaoSupport implements ITestDao{

	@Override
	public void save(Person person) {
		getHibernateTemplate().save(person);
	}

	@Override
	public Person findPerson(Serializable id) {
		return getHibernateTemplate().get(Person.class, id);
	}

}
