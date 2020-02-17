package com.mt.steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps 
{
	WebDriver driver;
	
	@When("^user opens \"(.*)\" browser$")
	public void openBrowser(String browsernm)
	{
		
		if(browsernm.equalsIgnoreCase("chrome"))
		{
			System.out.println("Chrome browser");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\amit\\Desktop\\chromedriver_win32 (4)\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Chrome browser is opened successfully");
		}else if(browsernm.equalsIgnoreCase("ie"))
		{
			System.out.println("IE browser");
			System.setProperty("webdriver.ie.driver", "F:\\Selenium Setup\\setup1\\29062019\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
			driver =new InternetExplorerDriver();
			System.out.println("IE browser is opened succesfully");
		}else
		{
			System.out.println("Firefox browser");
			System.setProperty("webdriver.gecko.driver", "F:\\Selenium Setup\\setup1\\29062019\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			System.out.println("Firefox browser is opened successfully");
		}
	}
	
	@And ("^user enters application url \"(.*)\"$")
	public void enterApplicationURL(String url)
	{
		driver.get(url);
		System.out.println("Application URL is entered successfully");
	}
	
	@And ("^user waits \"(.*)\" seconds to load login page$")
	public void waittillLoginpageloaded(int seconds)
	{
		driver.manage().timeouts().pageLoadTimeout(seconds, TimeUnit.SECONDS);
		
	}
	
	@And ("^user maximizes chrome browser$")
	public void maximizeBrowser()
	{
		driver.manage().window().maximize();
	}
	
	@Then ("^user is on login screen of Mercury Tours application$")
	public void verifyLoginpage()
	{
		String act_title=driver.getTitle();
		System.out.println("Title of Welcome screen is:"+act_title);
		String exp_title="Welcome: Mercury Tours";
		Assert.assertEquals(exp_title, act_title);			
	}
	
	@Given ("^user access login screen of Mercury Tours application$")
	public void verifyLoginimg()
	{
		boolean act_flag=driver.findElement(By.xpath("//img[@src='/images/featured_destination.gif']")).isDisplayed();
	    System.out.println("ARUBA image is displayed"+act_flag);
		boolean exp_flag=true;
		Assert.assertEquals(exp_flag, act_flag);
	    
	}
	
	@When ("^user enters \"(.*)\" as username$")
	public void enterUsername(String username)
	{
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
	}
	
	
	@And ("^user enters \"(.*)\" as password$")
	public void enterPassword(String passwd)
	{
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passwd);
	}
	
	@And ("^user clicks on Signin button$")
	public void clickonSignin()
	{
		driver.findElement(By.xpath("//input[@name='login']")).click();
	}
	
	@Then ("^user is on Flight Finder screen$")
	public void verifyFlightFinderimg()
	{
		boolean act_flag1=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
		System.out.println("Flight finder image is displayed: "+act_flag1);
		boolean exp_flag=true;
		Assert.assertEquals(exp_flag, act_flag1);
	}
	
	@When ("^user clicks on Signoff link$")
    public void clickonSignoff()
    {
    	driver.findElement(By.linkText("SIGN-OFF")).click();
    }
	
	@Then ("^user is on Signon screen$")
	public void verifySignOn()
	{
		boolean act_flag2=driver.findElement(By.xpath("//img[@src='/images/masts/mast_signon.gif']")).isDisplayed();
		System.out.println("SignOn image is displayed: "+act_flag2);
		boolean exp_flag2=true;
		Assert.assertEquals(exp_flag2, act_flag2);
	}
	
}
