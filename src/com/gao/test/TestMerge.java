package com.gao.test;

import static org.junit.Assert.*;

import javax.enterprise.inject.New;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gao.test.entity.Person;
import com.gao.test.service.ITestService;

public class TestMerge {

	private ClassPathXmlApplicationContext context;

	@Before
	public void loadContext() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(context);
	}
	
	@Test
	public void testSpring() {
		ITestService testService = (ITestService) context.getBean("testService");
		testService.say();
	}
	
	@Test
	public void testHibernate() {
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(new Person("员工1"));
		transaction.commit();
		session.close();
	}

}
