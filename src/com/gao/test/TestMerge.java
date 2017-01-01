package com.gao.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gao.test.service.ITestService;

public class TestMerge {

	@Test
	public void testSpring() {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		ITestService testService = (ITestService) context.getBean("testService");
		testService.say();
	}

}
