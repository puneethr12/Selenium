package com.test;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class Test_001_log4j_rootlogger {

	@Test
	public void method1()
	{
		Logger log = Logger.getRootLogger();
		
		log.trace("Trace Message!");
		log.debug("Debug Message!");
		log.info("Info Message");
		log.warn("Warn Message");
		log.error("Error Message");
		log.fatal("Fatal Message");
	
		
	}
}
