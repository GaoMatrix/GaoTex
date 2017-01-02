package com.gao.test.action;

import javax.annotation.Resource;

import com.gao.test.service.ITestService;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{
	
	@Resource
	ITestService testService;
	
	public String execute(){
		testService.say();
		return SUCCESS;
	}

}
