package testclas;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.DashBoardPage;
import pages.LoginPage;
import utility.CaptureScreenshot;

public class DashBoardPageTest  extends TestBase
{

	
	LoginPage login;
	DashBoardPage page;
	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		initialization();
		login=new LoginPage();
		page=new DashBoardPage();
		login.verifyDashboardPageURL();
	}
	@Test
	public void verifymycourceURLpageTest() throws InterruptedException {
		String expURL="https://proschool.ai/dashboard/my-courses/active-courses";
		String actURL=page.verifymycourceURLpage();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("My cource URL "+actURL);
	}
	
	@Test
	public void verifymyteacherURlPageTest() throws InterruptedException {
		String expURL="https://proschool.ai/dashboard/my-teacher";
		String actURL=page.verifymyteacherURlPage();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("My teacher URL "+actURL);
	}
	
	@Test
	public void verifynameofpersonuserTest() throws InterruptedException {
		String expText="Aditya";
		String actText=page.verifynameofperson();
		Assert.assertEquals(expText, actText);
		Reporter.log("Person User Login Name "+actText);
	}
	
	@Test
	public void veerifyUserProfileURL() throws InterruptedException {
		String expURL="https://proschool.ai/settings";
		String actURL=page.veerifyUserProfileURL();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URl of My profile "+actURL);
	}
	@AfterMethod()
	public void closeBrowser(ITestResult it) throws IOException 
	{
		if(it.FAILURE==it.getStatus()) {
			CaptureScreenshot.screenshot(it.getName());
		}
		
		driver.close();
	}
}
