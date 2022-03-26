package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	// "<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >"
	// Inherit //Object //By the name of the Class

	WebDriver driver;
	
	ExcelReader exlRead = new ExcelReader("testData\\Testdata2.xlsx");
	String userName = exlRead.getCellData("Sheet1", "Username", 2);
	String password = exlRead.getCellData("Sheet1", "Password", 2);

	String USER_NAME = "demo@techfios.com";
	String PASSWORD = "abc123";

	@Test
	public void verifiedUserShoulderBeAbleToLogin() {
		
		driver = BrowserFactory.init();
		System.out.println(driver.getTitle());

		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		
		
		
		login.insertUserName(userName);
		login.insertPassword(password);
		login.clickSignInButton();
		
		DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);
		
		dashboard.verifyDashboard();
		
//		BrowserFactory.tearDown();
	}

}
