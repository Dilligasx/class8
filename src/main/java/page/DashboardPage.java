package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage {	
	WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Dashboard')]") WebElement DASHBOARD_HEADER_ELEMENT;	
	@FindBy(how = How.XPATH, using = "//*[@id='side-menu']/li[3]/a/span[1]") WebElement CUSTOMER_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a") WebElement ADD_CUSTOMER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a") WebElement LIST_CUSTOMER_ELEMENT;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver; 
	}
	public void verifyDashboard() {
		Assert.assertEquals(DASHBOARD_HEADER_ELEMENT.getText(), "Dashboard" , "Wrong Page");
	}
	
	public void clickCustomerButton() {
		CUSTOMER_BUTTON_ELEMENT.click();
	}
	public void clickAddCustomerButton() {
		ADD_CUSTOMER_ELEMENT.click();
	}
	public void clickListCustomerButton() {
		LIST_CUSTOMER_ELEMENT.click();
	}
}
