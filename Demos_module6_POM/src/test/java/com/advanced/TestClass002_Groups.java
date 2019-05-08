package com.advanced;

import org.testng.annotations.Test;

public class TestClass002_Groups {

	@Test(groups="Smoke")
	public void method1()
	{
		System.out.println("Test method1 -- Smoke Test");
	}
	
	@Test(groups="Smoke")
	public void method2()
	{
		System.out.println("Test method2 -- Smoke Test");
	}
	
	@Test(groups="Regression")
	public void method3()
	{
		System.out.println("Test method3 --  Regression");
	}
	
	@Test(groups="Regression")
	public void method4()
	{
		System.out.println("Test method4 --  Regression");
	}
	
	@Test(groups= {"Smoke","Regression"})
	public void method5()
	{
		System.out.println("Test method5 --  Both Smoke and Regression");
	}
}
