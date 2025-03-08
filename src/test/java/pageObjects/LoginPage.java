package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage


{
	public LoginPage(WebDriver driver) 
	
	{
		super(driver);
		
	}
	
	
	@FindBy(id="input-email")
	WebElement userID;
	
	@FindBy(id="input-password")
	WebElement userPassword;
	
	@FindBy(css="input[type='submit']")
	WebElement btnLogin;
	
	
	public void setEmail(String email)
	
	{
		userID.sendKeys(email);
		
	}
	
	
	public void setEmailPassword(String password)
	
	{
		userPassword.sendKeys(password);
		
	}
	
	public void clickLogin()
	
	{
		
		btnLogin.click();
	}

}
