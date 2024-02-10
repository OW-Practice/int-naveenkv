package Trello.GenericUtilities;

import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

//import Trello.ObjectRepository.HomePage;
import Trello.ObjectRepository.LoginPage;

public class BaseClass extends WebDriverUtility
{
	PropertyFileUtility p=new PropertyFileUtility();
	public WebDriver driver;
	public static WebDriver sDriver;
	@BeforeSuite
	public void bSuite()
	{
		
	}
	@BeforeClass
	public void bClass() throws Throwable
	{
		String BROWSER=p.readDataFromPropertyFile("browser");
		String URL=p.readDataFromPropertyFile("url");
		if(BROWSER.contains("chrome"))
		{
	
			driver = new ChromeDriver();
			
		}
		if(BROWSER.contains("firefox"))
		{
			driver=new FirefoxDriver();
		}
		if(BROWSER.contains("edge"))
		{	
			driver=new EdgeDriver();
		}
		sDriver=driver;
		driver.manage().window().maximize();
		driver.get(URL);
	}
	@BeforeMethod
	public void bMethod() throws Throwable
	{
		String USERNAME=p.readDataFromPropertyFile("username");
		String PASSWORD=p.readDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApplication(USERNAME, PASSWORD);
		waitForPageLoad(driver);
	}
	@AfterMethod
//	public void aMethod()
//	{
//		HomePage hp=new HomePage(driver);
//		//hp.logout();
//	}
	@AfterClass
	public void aClass()
	{
		//driver.quit();
	}
	@AfterSuite
	public void aSuite() throws SQLException
	{
		
	}
}

