package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage

{

	public AccountRegistrationPage(WebDriver driver)
	
	{
		super(driver);
		
	}
	
	
	
	@FindBy(id="input-firstname")
	WebElement txtFirstName;
	
	@FindBy(id="input-lastname")
	WebElement txtLastName;
	
	@FindBy(id="input-email")
	WebElement txtEmail;
	
	@FindBy(css="input[name='telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement txtPassword;
	
	@FindBy(id="input-confirm")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[@value='1']")
	WebElement rbtnSubscribeYes;
	
	@FindBy(xpath="//input[@value='0']")
	WebElement rbtnSubscribeNo;
	
	
	
	@FindBy (name="agree")
	WebElement chkPolicyAgree;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstName(String fName)
	
	{
		txtFirstName.sendKeys(fName);
		
	}
	
	public void setLastName(String lName)
	
	{
		txtLastName.sendKeys(lName);
		
	}
	
	public void setEmail(String email)
	
	{
		txtEmail.sendKeys(email);
		
	}
	public void setTelephone(String string)
	
	{
		txtTelephone.sendKeys(string);
		
	}
	
	public void setPassword(String password)
	
	{
		txtPassword.sendKeys(password);
		
	}
	public void reenterPassword(String password)
	
	{
		txtConfirmPassword.sendKeys(password);
		
	}
	
	public void subscribeYes()
	{
		rbtnSubscribeYes.click();
	}
	
	public void subscribeNo()
	{
		rbtnSubscribeNo.click();
	}
	
	public void policyAgree()
	
	{
		chkPolicyAgree.click();
		
	}
	
	public void clickContinue()
	{
		
		btnContinue.click();
	}
	
	
	public String getConfirmationMsg() 
	{
		return (msgConfirmation.getText());
		
		
	}
}
