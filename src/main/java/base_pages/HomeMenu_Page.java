package base_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumWrapper;

public class HomeMenu_Page extends SeleniumWrapper{
	
	public WebDriver driver;
	public Users_Page Users_Page;

	public HomeMenu_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[text()='Time-Track']")
	WebElement timeTrack_menu;
	
	@FindBy(xpath="//div[text()='Tasks']")
	WebElement tasks_menu;
	
	@FindBy(xpath="//div[text()='Reports']")
	WebElement reports_menu;
	
	@FindBy(xpath="//div[text()='Users']")
	WebElement users_menu;
	
	@FindBy(id="logoutLink")
	WebElement logoutLink;
	
	public void goToTimeTrack() {
		waitForElementToAppear(timeTrack_menu);
		timeTrack_menu.click();
	}
	
	public void goToTasks() {
		waitForElementToAppear(tasks_menu);
		tasks_menu.click();
	}
	
	public void goToReports() {
		waitForElementToAppear(reports_menu);
		reports_menu.click();
	}
	
	public Users_Page goToUsers() {
		waitForElementToAppear(users_menu);
		users_menu.click();
		Users_Page = new Users_Page(driver);
		return Users_Page;
	}
	
	
	public void logoutApplication() {
		logoutLink.click();
	}
	
}
