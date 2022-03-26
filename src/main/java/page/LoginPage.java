package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	WebDriver driver;

	public LoginPage (WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	
	
	
	//Login data 
		String USER_NAME = "demo@techfios.com";
		String PASSWORD = "abc123";
		
	//Storing elements by class
		By userNameField = By.xpath("//input[@id='username']");
		By passwordField = By.xpath("//*[@id='password']");
		By loginButtonField = By.xpath("/html/body/div/div/div/form/div[3]/button");
	
		@FindBy(how = How.XPATH, using = "//input[@id='username']") WebElement USERNAME_ELEMENT;
		@FindBy(how = How.XPATH, using = "//*[@id='password']") WebElement PASSWORD_ELEMENT;
		@FindBy(how = How.XPATH, using = "/html/body/div/div/div/form/div[3]/button") WebElement SIGNIN_ELEMENT;
		
		public void insertUserName(String userName) {
			USERNAME_ELEMENT.sendKeys(userName);
		}
		public void insertPassword(String password) {
			PASSWORD_ELEMENT.sendKeys(password);
		}
		public void clickSignInButton() {
			SIGNIN_ELEMENT.click();
		}
		public void loginTest(String userName, String password) {
			USERNAME_ELEMENT.sendKeys(userName);
			PASSWORD_ELEMENT.sendKeys(password);
			SIGNIN_ELEMENT.click();
		}
}
