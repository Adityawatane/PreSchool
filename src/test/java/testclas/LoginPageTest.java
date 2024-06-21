package testclas;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import utility.CaptureScreenshot;

public class LoginPageTest extends TestBase

{

	LoginPage login;
	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		initialization();
		login=new LoginPage();
		
	}
	
	
	@Test
	public void verifyTitleOfApplicationTest() {
		String expTitle="ProSchool";
		String actTitle=login.verifyTitleOfPage();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Title of page "+actTitle);
	}
	@Test
	public void verifyUrlOfApplicationTest() {
		String expUrl="https://proschool.ai/login";
		String actUrl=login.verifyURLOfLOoginPage();
		Assert.assertEquals(expUrl, actUrl);
		Reporter.log("URL of application"+actUrl);
	}
	@Test
	public void verifyDashboardPageURLTest() throws IOException, InterruptedException {
		String expUrl="https://proschool.ai/dashboard/home";
		String actUrl=login.verifyDashboardPageURL();
		Assert.assertEquals(expUrl, actUrl);
		Reporter.log("URl of dashboard page "+actUrl);
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
