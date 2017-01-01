package com.gao.test.service.impl;

import org.springframework.stereotype.Service;

import com.gao.test.service.ITestService;

@Service("testService")
public class TestServiceImpl implements ITestService {

	@Override
	public void say() {
		System.out.println("TestServiceImpl say hi.");
	}

}
