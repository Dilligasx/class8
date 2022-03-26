package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddContactPage extends BasePage {

	WebDriver driver;
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]") WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]") WebElement COMPANY_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]") WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]") WebElement PHONE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='address']") WebElement ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]") WebElement CITY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]") WebElement STATE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]") WebElement ZIP_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"select2-country-container\"]") WebElement COUNTRY__ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[@type='submit'] [@id='submit']") WebElement SUBMIT_BUTTON__ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"summary\"]") WebElement SUMMARY_ON_PROFILE__ELEMENT;
	
		
	String generatedName;
	
	public AddContactPage(WebDriver driver) {
		this.driver = driver;
	}
	public void insertFullName(String fullname) {
		generatedName = fullname + generateRandomNo(999);
		FULL_NAME_ELEMENT.sendKeys(generatedName);
	}
	
	public void selectCompany(String company) {
		
		selectFromDropDown(COMPANY_NAME_ELEMENT, company);
	}
	public void insertEmail(String email) {
		EMAIL_ELEMENT.sendKeys(generateRandomNo(999) + email);
	}
	
	public void insertPhone(String phone) {
		PHONE_ELEMENT.sendKeys(phone + generateRandomNo(9999));
	}
	
//	public void selectCountry(String country) {
//		selectFromDropDown(COUNTRY__ELEMENT, country);
//	}
	public void insertAddress(String address) {
		ADDRESS_ELEMENT.sendKeys(address);
	}
	public void insertCity(String city) {
		CITY_ELEMENT.sendKeys(city);
	}
	public void insertState(String state) {
		STATE_ELEMENT.sendKeys(state);
	}
	public void insertZip(String zip) {
		ZIP_ELEMENT.sendKeys(zip);
	}
	public void clickCountry(String countryName) {
		COUNTRY__ELEMENT.click();
		WebElement COUNTRY_NAME_ELEMENT = driver.findElement(By.xpath("//li[contains(text(), '"+ countryName + "')]"));
		COUNTRY_NAME_ELEMENT.click();
	}
	public void clickSubmitButton() {
		SUBMIT_BUTTON__ELEMENT.click();
	}
	public void verifyProfilePage() {
		waitForElement(driver, 5, SUMMARY_ON_PROFILE__ELEMENT);
		Assert.assertEquals(SUMMARY_ON_PROFILE__ELEMENT.getText(), "Summary", "Wrong Page!");
	}
	
	
	String beforeXpath = "//tbody//tr[";
	String afterXpath = "]/td[3]";
	//tbody//tr[1]//td[3]/following-sibling::td[4]/a[2]
	public void verifyEnteredNameAndDelete() {
		for(int i=1; i <= 10 ; i++) {
			String enterName = driver.findElement(By.xpath("//tbody//tr["+ i + "]/td[3]")).getText();
			System.out.println(enterName);
			Assert.assertEquals(enterName, generatedName, "Name mismatch");
			if(enterName.contains(generatedName)) {
				System.out.println("Entered name exists");
				driver.findElement(By.xpath("//tbody//tr["+i+"]//td[3]/following-sibling::td[4]/a[2]")).click();
				driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/button[2]")).click();
			}
			break;
		}
	}
	
	
}
