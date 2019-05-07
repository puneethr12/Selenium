package com.test;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class Test_002_manualLogger {

	@Test
	public void method1()
	{
		Logger log = Logger.getLogger("manualLogger");
		
		log.trace("Trace Message!");
		log.debug("Debug Message!");
		log.info("Info Message");
		log.warn("Warn Message");
		log.error("Error Message");
		log.fatal("Fatal Message");		
	}
}