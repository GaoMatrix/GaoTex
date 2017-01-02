package com.gao.test.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gao.test.dao.ITestDao;
import com.gao.test.entity.Person;
import com.gao.test.service.ITestService;

@Service("testService")
public class TestServiceImpl implements ITestService {
	
	@Resource
	ITestDao testDao;

	@Override
	public void say() {
		System.out.println("TestServiceImpl say hi.");
	}

	@Override
	public void save(Person person) {
		testDao.save(person);
	}

	@Override
	public Person findPerson(Serializable id) {
		return testDao.findPerson(id);
	}

}
