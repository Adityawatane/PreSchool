package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.ReadData;

public class LoginPage  extends TestBase
{
	
	@FindBy(xpath="//button[text()='Student']")
	private WebElement student;

	@FindBy(xpath = "//input[@name='email']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Login']")
    private WebElement loginButton;

    public LoginPage() {
    	PageFactory.initElements(driver, this);
    }
    
    public String verifyURLOfLOoginPage() {
    	return driver.getCurrentUrl();
    }
    
    public String verifyTitleOfPage() {
    	return driver.getTitle();
    }
    
    public String verifyDashboardPageURL() throws IOException, InterruptedException {
    	student.click();
    	usernameInput.sendKeys(ReadData.readPropertyFile("UserName"));
    	passwordInput.sendKeys(ReadData.readPropertyFile("Password"));
    	
    	loginButton.click();
    	Thread.sleep(3000);
    	return driver.getCurrentUrl();
    }
}

