package test_cases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base_pages.Login_Page;
import base_pages.HomeMenu_Page;
import base_pages.Users_Page;
import base_pages.Departments_Page;
import utilities.BaseTest;

public class verify_add_department extends BaseTest{
	@Test(dataProvider="getTestData")
	public void addDepartment(HashMap<String, String> input) throws IOException {
		String username = getDataFromGobalProperties("username");
		String password = getDataFromGobalProperties("password");
		String newDepartment = input.get("newDepartment");
		String existingDepartment = input.get("existingDepartment");
		String user = input.get("user");
		
		HomeMenu_Page HomeMenu_Page = Login_Page.loginApplication(username, password);
		Users_Page Users_Page = HomeMenu_Page.goToUsers();
		Departments_Page Departments_Page = Users_Page.goToDepartments();
		Departments_Page.enterNewDepartment(newDepartment);
		Departments_Page.clickAddDepartment();
		Departments_Page.verifyDepartmentDisplay(newDepartment);
		Departments_Page.verifyDepartmentUserCount(newDepartment, "(0)");
		Departments_Page.goToDepartment(newDepartment);
		Departments_Page.verifyDepartmentHeaderDisplay(newDepartment);
		Departments_Page.verifyDepartmentUserCountHeaderDisplay("(0)");
		Departments_Page.verifyNoUserToDisplayMessage(newDepartment);
		Departments_Page.clicOnCloseDepartment();
		HomeMenu_Page.logoutApplication();
			}
	
	@DataProvider
	public Object[][] getTestData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"\\src\\main\\resources\\test_data\\Actitime_add_department.json");
		return new Object[][] {{data.get(0)}};
	}

}
