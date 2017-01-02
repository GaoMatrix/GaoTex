package com.gao.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class TestLog {
	
	@Test
	public void test() {
		Log log = LogFactory.getLog(getClass());
		try {
			int i = 1/0;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		log.debug("这是debug");
		log.info("这是info");
		log.warn("这是warn");
		log.error("这是error");
		log.fatal("这是fetal");
	}

}
