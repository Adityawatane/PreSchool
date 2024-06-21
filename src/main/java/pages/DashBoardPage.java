package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class DashBoardPage extends TestBase

{

	@FindBy(xpath="//a[text()='My Courses']")
	private WebElement mycources;
	
	@FindBy(xpath="//a[text()='My Teacher']")
	private WebElement myteacher;
	
	@FindBy(xpath="//p[@class='dashboardHeaderProfileText']")
	private WebElement nameofperson;
	
	@FindBy(xpath="//p[text()='Profile']")
	private WebElement profile;
	public DashBoardPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifymycourceURLpage() throws InterruptedException {
		Thread.sleep(5000);
		mycources.click();
		return driver.getCurrentUrl();
	}
	
	public String verifymyteacherURlPage() throws InterruptedException {
		Thread.sleep(5000);
		myteacher.click();
		return driver.getCurrentUrl();
	}
	
	public String verifynameofperson() throws InterruptedException {
		Thread.sleep(5000);
		return nameofperson.getText();
	}
	
	public String veerifyUserProfileURL() throws InterruptedException {
		Thread.sleep(5000);
		nameofperson.click();
		profile.click();
		return driver.getCurrentUrl();
	}
}
