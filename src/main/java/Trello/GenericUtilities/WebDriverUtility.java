package Trello.GenericUtilities;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	/**
	 * This method will maximize window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will wait for 20 seconds for page load
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	/**
	 * This method will wait till element is visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This meyhod will wait till element is clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will handle dropdown by index
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * This method will handle dropdown by value
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element, String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * This method will handle dropdown by visible text
	 * @param text
	 * @param element
	 */
	public void handleDropdown(String text, WebElement element)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	
	/**
	 * This method will select all the options from dropdown
	 * @param ele
	 */
	public void multiSelect(WebElement ele)
	{
		Select s=new Select(ele);
		List<WebElement> option =s.getOptions();
		int count=option.size();
			for(int i=0; i<count; i++)
			{
				s.selectByIndex(i);
			}

	}
	/**
	 * This method will right click on page
	 * @param driver
	 */
	public void rightClickOnPage(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method will right click on web element
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).contextClick().perform();
	}
	
	/**
	 * This method will perform mouse hover action on web element
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).click().perform();
	}
	
	/**
	 * This method will double click on web element
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This method will press enter key
	 * @throws Throwable
	 */
	public void pressEnterKey() throws Throwable
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This method will copy text
	 * @throws Throwable
	 */
	public void copyText() throws Throwable
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		
		r.keyRelease(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}
	
	
	/**
	 * This method will paste copied text
	 * @throws Throwable
	 */
	public void pasteText() throws Throwable
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_V);
		
		r.keyRelease(KeyEvent.VK_V);
	}
	
	/**
	 * This method will take screenshot
	 * @param driver
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver driver, String screenShotName) throws IOException
	{
		TakesScreenshot screenShot=(TakesScreenshot) driver;
		File src = screenShot.getScreenshotAs(OutputType.FILE);
		File dest=new File(".\\ScreenShots\\"+screenShotName+".png");
		FileUtils.moveFile(src, dest);
		
		return dest.getAbsolutePath(); //For Extent Reports
	}
	
	/**
	 * This method will scroll down randomly downwards
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	
	/**
	 * This method will scroll downwards till perticular webElement
	 * @param driver
	 * @param ele
	 */
	public void scrollAction(WebDriver driver, WebElement ele)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y=ele.getLocation().getY();
		js.executeScript("window.scrollBy(0, "+y+")", ele);
	}
}

