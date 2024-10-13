package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SeleniumWrapper {
	public WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public SeleniumWrapper(WebDriver driver)
	{
		this.driver = driver;		
		
	}
		
	
	public void waitForElementToAppear(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));		
		
	}
	
	public void waitForElementToDisAppear(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));		
		
	}
	
	}
