package base_pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumWrapper;

public class Login_Page extends SeleniumWrapper{
	public WebDriver driver;
	public HomeMenu_Page HomeMenu_Page;

	public Login_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="username")
	WebElement username_txtbox;
	
	@FindBy(name="pwd")
	WebElement password_txtbox;
	
	@FindBy(id="loginButton")
	WebElement login_button;
	

	public HomeMenu_Page loginApplication(String username, String password) {
		waitForElementToAppear(username_txtbox);
		username_txtbox.sendKeys(username);
		password_txtbox.sendKeys(password);
		login_button.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		HomeMenu_Page = new HomeMenu_Page(driver);
		return HomeMenu_Page;
	}


	}
