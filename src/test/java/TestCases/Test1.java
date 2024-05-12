package TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Test1 
{
	WebDriver driver;
	
  @BeforeMethod
  @Parameters({"browser"})
  public void beforeMethod(String br) 
  {
	  if(br.equals("chrome"))
	  {
	  driver  = new ChromeDriver();
	  }
	  else if(br.equals("firefox"))
	  {
	  driver = new FirefoxDriver();
	  }
		  //WebDriver driver = new SafariDriver();
      
	  //Maximize browser and setting timeout value to get elements on page
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
  
  @Test
  public void Action() 
  {
	//Hit URL
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  
	  //Sending Username, Password and click on login Button
	  driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin"); 
	  WebElement txtPassword = driver.findElement(By.xpath("//input[@placeholder='Password']"));
	  txtPassword.sendKeys("admin123");
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	
	  
	  //Getting text from Homepage
	  String act_Text = null;
	  String exp_Text = "Dashboard";
	  try
	  {
	    act_Text = driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']")).getText();
	  }
	  catch(Exception e)
	  {
		  act_Text = "";
	  }
	 
	  SoftAssert sa = new SoftAssert();
	  AssertJUnit.assertEquals(act_Text,exp_Text);
	  AssertJUnit.assertEquals(act_Text, exp_Text);
	  
	  //Checking text with expectation
	  if(act_Text.equals(exp_Text))
	  {
		  System.out.println("Test Passed");
	  }
	  else
	  {
		  System.out.println("Text Failed");
	  }
  }

  @AfterMethod
  public void afterMethod()
  {
	  //Closing Browser
	  driver.close();
  }

}
