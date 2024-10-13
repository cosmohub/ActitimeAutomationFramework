package base_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.SeleniumWrapper;

public class Departments_Page extends SeleniumWrapper {

	public Departments_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[text()='Manage Departments']")
	WebElement manageDepartments_header;
	
	@FindBy(xpath="//td[@class='newGroupInputCell']/input")
	WebElement newDepartment_txtbox;
	
	@FindBy(css="td[class='addGroupButtonCell'] button")
	WebElement addDepartment_button;
	
	@FindBy(xpath="td[class='usernameCell'] label")
	WebElement userName;
	
	@FindBy(xpath="//button[text()='Move To']")
	WebElement moveToDropdown;
	
	@FindBy(id="groupManagementLightBox_clearSelectionButtonImg")
	WebElement clearSelectionOfUsers;
	
	@FindBy(id="groupManagementLightBox_selectAllButtonImg")
	WebElement selectAllUsers;
	
	@FindBy(id="groupManagementLightBox_filterSelectionButtonImg")
	WebElement filterUser;
	
	@FindBy(className="filterFieldInput")
	WebElement searchUserToFilter;
	
	@FindBy(css="td[class='clearFilterButton']")
	WebElement clearFilterButton;
	
	@FindBy(css="td[class='closeFilterPanelButton']")
	WebElement closeFilterPanel;
	
	@FindBy(id="groupManagementLightBox_closeLightbox")
	WebElement closeDepartment;
	
	@FindBy(xpath="(//div[@id='groupManagementLightBox_topGroupNameLabel']/span)[1]")
	WebElement departmentNameHeader;
	
	@FindBy(xpath="(//div[@id='groupManagementLightBox_topGroupNameLabel']/span)[2]")
	WebElement departmentusercountHeader;
	
	@FindBy(id="groupManagementLightBox_emptyGroupMessageTable")
	WebElement departmentMessage;	
	
	
	public void verifyDepartmentUserCount(String department, String userCount) {
		
		String actualUserCount = driver.findElement(By.xpath("//div[@title='"+department+"']/../../../..//td[contains(@class,'counterCell')]")).getText();
		Assert.assertEquals(actualUserCount, userCount);
	}
	
	public void verifyDepartmentDisplay(String department) {
		
		driver.findElement(By.xpath("//div[@title='"+department+"']")).isDisplayed();
	}
	
	public void deleteDepartment(String department) {
		driver.findElement(By.xpath("//div[@title='"+department+"']/../../../..//td[@class='deleteGroupCell']")).click();
	}
	
	public void goToDepartment(String department){
		
		driver.findElement(By.xpath("//div[@title='"+department+"']")).click();
		
	}
	
	public void verifyDepartmentHeaderDisplay(String department) {
		
		waitForElementToAppear(departmentNameHeader);
		String departmentActualValue = departmentNameHeader.getText();
		Assert.assertEquals(departmentActualValue,department);
	}
	
	public void verifyDepartmentUserCountHeaderDisplay(String userCount) {
		
		waitForElementToAppear(departmentusercountHeader);
		String userActualValue = departmentusercountHeader.getText();
		Assert.assertEquals(userActualValue.trim(),userCount);
	}
	
	public void verifyNoUserToDisplayMessage(String department) {
		
		waitForElementToAppear(departmentMessage);
		String actualMessage = departmentMessage.getText();
		String expectedMessage = "There are no users in the \""+department+"\" department";
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	public void selectUsername(String username) {
		driver.findElement(By.xpath("//td[@class='usernameCell']//label[text()='"+username+"']/../../..//input[@type='checkbox']"));
	}
	
	public void enterNewDepartment(String department) {
		waitForElementToAppear(newDepartment_txtbox);
		newDepartment_txtbox.sendKeys(Keys.ENTER);
		newDepartment_txtbox.sendKeys(department);		
	}
	
	public void clickAddDepartment() {
		waitForElementToAppear(addDepartment_button);
		addDepartment_button.click();	
	}
	public void selectDepartmentToMoveUser(String department) {
		driver.findElement(By.partialLinkText(department)).click();
	}
	
	public void clicOnCloseDepartment() {
		waitForElementToAppear(closeDepartment);
		closeDepartment.click();
		
	}
	
	

}
