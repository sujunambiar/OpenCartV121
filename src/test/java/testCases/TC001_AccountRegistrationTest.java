package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.Logs;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;


public class TC001_AccountRegistrationTest extends BaseClass


{ 
	@Test(groups={"Regression","Master"})
	public void verify_Account_Registration() throws InterruptedException
	

	{
		logger.info("****Starting TC001_AccountRegistrationTest");
		
		try {
		
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		logger.info("****clicked on MyAccount Link");
		hp.clickRegister();
		logger.info("****clicked on Register Link");
		
		AccountRegistrationPage regPage=new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details.....");
		regPage.setFirstName(randomStringGenerator(5));
		regPage.setLastName(randomStringGenerator(8));
		regPage.setEmail(randomStringGenerator(5)+"@gmail.com");
		regPage.setTelephone(randomNumberGenerator(8));
		
		String password=randomNumberGenerator(8);
		regPage.setPassword(password);
		regPage.reenterPassword(password);
		regPage.policyAgree();
		regPage.clickContinue();
		
		Thread.sleep(10);

		logger.info("Validating expected message");
		String confmsg= regPage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
	}
	catch(Exception e)
	
	{
		
		logger.error("Test Failed....");
		logger.debug("Debug logs.......");
		
		Assert.fail();
		
	}
		logger.info("****Finished testing application**** ");
	}
	

}
