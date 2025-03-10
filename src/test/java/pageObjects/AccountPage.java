package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage


{
	
	
	public AccountPage(WebDriver driver)
	{
		super(driver);
		
	}

	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement msgHeading;
	
	
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
	WebElement logout;
	
	
	public boolean isMyAccountExists()
	{
	
	try
	{
		return(msgHeading.isDisplayed());
		
	}
	catch(Exception e)
	{
		
		return false;
	}
	}
	
	
	public void clickLogout()
	
	{
		
		logout.click();
	}
}
