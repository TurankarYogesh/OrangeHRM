package com.Test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.PageObject.LoginPom;
import com.Utility.BaseClass;
import com.Utility.Library;

public class VerifyLogin extends BaseClass {
	boolean dash;
	
  @Test
  public void TC_001() throws Exception {
	  LoginPom login=new LoginPom(driver);
	  
	  Library.custom_Sendkeys(login.username(), excel.getStringData("Sheet1", 0, 0), "Username");
	  Library.custom_Sendkeys(login.password(), excel.getStringData("Sheet1", 1, 0), "Password");
	  Library.custom_click(login.Login_Btn(), "Login_Button");  
	    
	  try {
		  dash=driver.findElement(By.linkText("Dashboard")).isDisplayed();
	  }catch(Exception e) {
		  dash=false;
	  }
	  
	  Assert.assertEquals(dash, true);
	 	
	  }
  }
  
  
  



