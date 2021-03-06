package com.gao.test.service;

import java.io.Serializable;

import com.gao.test.entity.Person;

public interface ITestService {
	public void say();
	
	/**
	 * 保存Person
	 * @param person
	 */
	public void save(Person person);
	
	/**
	 * 根据id查询人员
	 * @param id
	 * @return
	 */
	public Person findPerson(Serializable id);
}
