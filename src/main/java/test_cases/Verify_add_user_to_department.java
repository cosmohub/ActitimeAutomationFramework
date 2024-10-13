package test_cases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base_pages.Departments_Page;
import base_pages.HomeMenu_Page;
import base_pages.Users_Page;
import utilities.BaseTest;

public class Verify_add_user_to_department extends BaseTest{
	
	@Test(dataProvider="getTestData")
	public void addUserToDepartment(HashMap<String, String> input) throws IOException {
		String username = getDataFromGobalProperties("username");
		String password = getDataFromGobalProperties("password");
		String newDepartment = input.get("newDepartment");
		String existingDepartment = input.get("existingDepartment");
		String user = input.get("user");
		
		HomeMenu_Page HomeMenu_Page = Login_Page.loginApplication(username, password);
		Users_Page Users_Page = HomeMenu_Page.goToUsers();
		Departments_Page Departments_Page = Users_Page.goToDepartments();	
		
	}
	@DataProvider
	public Object[][] getTestData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"\\src\\main\\resources\\test_data\\Actitime_add_department.json");
		return new Object[][] {{data.get(0)}};
	}
}
