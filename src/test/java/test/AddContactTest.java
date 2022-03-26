package test;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddContactTest {

	WebDriver driver;

	ExcelReader reader = new ExcelReader("testData\\Testdata.xlsx");
	String fullName = reader.getCellData("AddContactInfo", "FullName", 2);
	String companyName = reader.getCellData("AddContactInfo", "CompanyName", 2);
	String email = reader.getCellData("AddContactInfo", "Email", 2);
	String phone = reader.getCellData("AddContactInfo", "Phone", 2);
	String address = reader.getCellData("AddContactInfo", "Address", 2);
	String city = reader.getCellData("AddContactInfo", "City", 2);
	String state = reader.getCellData("AddContactInfo", "State", 2);
	String zip = reader.getCellData("AddContactInfo", "Zip", 2);
	String country = reader.getCellData("AddContactInfo", "Country", 2);

	@Test
	public void validUSerShouldBeAbleToAddCustomer() {
		driver = BrowserFactory.init();

		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.insertUserName("demo@techfios.com");
		login.insertPassword("abc123");
		login.clickSignInButton();

		DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);
		dashboard.verifyDashboard();
		dashboard.clickCustomerButton();
		dashboard.clickAddCustomerButton();
//		Assert.assertEquals(DASHBOARD_HEADER_ELEMENT.getText(), "Dashboard" , "Wrong Page");
		AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);

		addContactPage.insertFullName(fullName);
		addContactPage.selectCompany(companyName);
		addContactPage.insertEmail(email);
		addContactPage.insertPhone(phone);
		addContactPage.insertAddress(address);
		addContactPage.insertCity(city);
		addContactPage.insertState(state);
		addContactPage.insertZip(zip);
		addContactPage.clickCountry(country);
		addContactPage.clickSubmitButton();
		addContactPage.verifyProfilePage();
		dashboard.clickListCustomerButton();
		addContactPage.verifyEnteredNameAndDelete();
	}

}
