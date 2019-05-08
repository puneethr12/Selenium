package com.advanced;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Class003_Dependency {

	@Test(groups="UI",priority=1)
	public void register()
	{
		System.out.println("User Registration");
		Assert.assertTrue(true);
	}
	
	@Test(groups="UI",priority=2,dependsOnMethods="register")
	public void login()
	{
		System.out.println("User Login");
		Assert.assertTrue(false);
	}
	
	@Test(groups="UI",priority=3,dependsOnMethods= {"register","login"})
	public void logout()
	{
		System.out.println("User Logout");
		Assert.assertTrue(true);
	}
}

