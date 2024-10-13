package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import base_pages.Login_Page;

public class BaseTest {

	public WebDriver driver;
	public Login_Page Login_Page;
	Properties prop = new Properties();

	public void initialize_driver() throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\test_data\\Global_Data.properties");
		prop.load(file);
		String browser = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--disable-notification");
			driver = new ChromeDriver(opt);

		}

		else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		else if (browser.equalsIgnoreCase("edge")) {
			EdgeOptions opt = new EdgeOptions();
			opt.addArguments("--guest");
			driver = new EdgeDriver(opt);
		}

	}
	
	@BeforeMethod
	public Login_Page launchApplication() throws IOException {
		initialize_driver();
		String url = prop.getProperty("url");
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Login_Page = new Login_Page(driver);
		return Login_Page;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	public List<HashMap<String, String>> getJsonData(String filePath) throws IOException {
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		ObjectMapper map = new ObjectMapper();
		List<HashMap<String,String>> data = map.readValue(jsonContent,new TypeReference<List<HashMap<String,String>>>(){});
		return data;
	}
	
	public String takeScreenshot(String fileName, WebDriver driver) throws IOException {
		String date = new SimpleDateFormat("dd-MM-yyyy_hms").format(new Date());
		String filePath = System.getProperty("user.dir")+"Screenshots"+fileName+date+".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(filePath);
		FileUtils.copyFile(source, dest);
		return filePath;
	}

	public String getDataFromGobalProperties(String data) throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\test_data\\Global_Data.properties");
		Properties prop = new Properties();
		prop.load(file);
		return (String) prop.get(data);
	}
}
