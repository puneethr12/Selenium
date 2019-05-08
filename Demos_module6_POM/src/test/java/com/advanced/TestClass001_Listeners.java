package com.advanced;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.Listeners.TestListener.class)
public class TestClass001_Listeners {
	
	//Intentionally passing a test case
	@Test
	public void Login1()
	{
		System.out.println("Hello");
		Assert.assertTrue(true);
	}
	
	//intentionally failing a test case
	@Test()
	public void login2()
	{
		System.out.println("Hi");
		Assert.assertTrue(false);
	}
	
	//intentionally skipping a test case
	@Test()
	public void login3()
	{
        throw new SkipException("Bye Bye");
	}
	

}
