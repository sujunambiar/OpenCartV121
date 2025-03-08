package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage

{

	public HomePage(WebDriver driver)
	{
		super(driver);
			
	}


	@FindBy(xpath="//span[text()='My Account']")
	
	WebElement lnkMyaccount;
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement login;
	
	

	
	public void clickMyAccount()
	
	{
		lnkMyaccount.click();
		
		
	}

	public void clickRegister()
	
	{
		lnkRegister.click();
		
		
	}
	
	public void clickLogin()
	{
		login.click();
		
	}
	

}
