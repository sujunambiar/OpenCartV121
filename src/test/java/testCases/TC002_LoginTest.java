package testCases;

import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	AccountPage ap ;




	@Test(groups={"Sanity","Master"})
	public void verify_Login()
	{
		
		logger.info("*******Starting TC002_LoginTest**********");
		
		try {
		
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		

		
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setEmailPassword(p.getProperty("password"));
		lp.clickLogin();
				
		
		ap= new AccountPage(driver);
		boolean targetPage= ap.isMyAccountExists();
	
		
		Assert.assertEquals(targetPage, true, "Login Failed");
		}
		
		catch(Exception e)
		{
		
		Assert.fail();
		
		}
		ap.clickLogout();
		
		
		
		logger.info("*******Finished TC002_LoginTest**********");
	
	
	}
	
	
}
