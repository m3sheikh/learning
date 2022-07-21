package orangeHRM_Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Getting_Headings {
	WebDriver driver;
	@BeforeTest
	public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

	driver = new ChromeDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/");
	Thread.sleep(2000);
	//driver.manage().deleteAllCookies();
	//Thread.sleep(2000);
	} 
	@Test
	public void fetchHeading() throws Exception {
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Dashboard")).click();
		Thread.sleep(3000);
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.linkText("Buzz")).click();
		Thread.sleep(3000);
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.linkText("Directory")).click();
		Thread.sleep(3000);
		System.out.println(driver.getCurrentUrl());
		
		
		
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}

}
