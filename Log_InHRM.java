package orangeHRM_Package;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Log_InHRM {
		WebDriver driver;
		@BeforeTest
		public void setUp() throws Exception {
			System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
			driver  = new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
			Thread.sleep(2000); 
		}
		@Test(dataProvider="dp2")
		public void loginSetup(String usrName, String pasword) throws InterruptedException {
			System.out.println("entered");
			Thread.sleep(1000);
			driver.findElement(By.name("txtUsername")).sendKeys(usrName);
			driver.findElement(By.name("txtPassword")).sendKeys(pasword);
			driver.findElement(By.name("Submit")).click();
			Thread.sleep(2000);
			
			try {
				System.out.println("clicked on welcome");
				driver.findElement(By.partialLinkText("Welcome")).click();
				Thread.sleep(2000);
				driver.findElement(By.linkText("Logout")).click();
				
				}catch(Exception e) {
					System.out.println(usrName + " doesn't exist");
				}
		
		}
		
		@AfterTest
		public void closing() {
			driver.close();
		}
		
		
			
		@DataProvider(name="dp2")
		public Object[][] datObj(){
			return new Object[][] {
				{"Admin","admin123"},
				{"James","javascript"},
				{"Harry", "python"}
			};
		}
		
	}


