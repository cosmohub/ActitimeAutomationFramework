package base_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumWrapper;

public class Users_Page extends SeleniumWrapper {
	public WebDriver driver;
	public Departments_Page Departments_Page;

	public Users_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(xpath="//tr[@id='pageHeader']//div[contains(text(),'Departments')]")
	WebElement departments_menu;
	
	@FindBy(xpath="//div[text()='New User']")
	WebElement newUser_menu;
	
	public Departments_Page goToDepartments() {
		waitForElementToAppear(departments_menu);
		departments_menu.click();
		Departments_Page = new Departments_Page(driver);
		return Departments_Page;
	}
	
	

}
