package Trello.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(xpath = "//*[@id=\"BXP-APP\"]/header[1]/div/div[1]/div[2]/a[1]")
	private WebElement loginBtn;
	
	@FindBy( id = "username")
	private WebElement emailTxt;
	
	@FindBy(xpath = "//*[@id=\"form-login\"]/div[1]/div[2]/div/div/span/span")
	private WebElement pwdTxt;
	
	@FindBy(id = "login-submit")
	private WebElement loginBtn2;
	
	
	public WebElement getloginBtn() {
		return loginBtn;
	}
	
	public WebElement getemailTxt() {
		return emailTxt;
	}

	public WebElement getpwdTxt() {
		return pwdTxt;
	}


	public WebElement getloginBtn2() {
		return loginBtn2;
	}

	public void loginToApplication(String username,String pwdTxt)
	{
		getloginBtn().click();
		getemailTxt().sendKeys(username);
		getpwdTxt().sendKeys(pwdTxt);
		getloginBtn2().click();
	}

	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
