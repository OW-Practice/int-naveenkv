package Trello.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateBoard {
	//*[@id="header"]/div[1]/div/div[3]/button/p
	
	@FindBy(xpath = "//*[@id=\"header\"]/div[1]/div/div[3]/button/p")
	private WebElement createbtn;   
	
	@FindBy(xpath = "/html/body/div[3]/div/section/div/div/nav/ul/li[1]/button/span[2]")
	private WebElement createbobtn; 
	
	
	
	@FindBy(xpath = "/html/body/div[3]/div/section/div/form/div[1]/label/input")
	private WebElement boardtTitle;
	
	
	@FindBy(xpath = "/html/body/div[3]/div/section/div/form/button")
	private WebElement bordcreateBtn;

	
	@FindBy(xpath = "//*[@id=\"board\"]/div[1]/form/textarea")
	private WebElement createtitle1;
	
	
	
	@FindBy(xpath = "//*[@id=\"board\"]/div[1]/form/div/button[1]")
	private WebElement addTittlebtn1;
	
	@FindBy(xpath = "//*[@id=\"board\"]/div[1]/form/textarea")
	private WebElement createtitle2;
	
	@FindBy(xpath = "//*[@id=\"board\"]/div[1]/form/div/button[1]")
	private WebElement addTittlebtn2;
	
	@FindBy(xpath = "//*[@id=\"board\"]/div[1]/form/textarea")
	private WebElement createtitle3;
	
	@FindBy(xpath = "//*[@id=\"board\"]/div[1]/form/div/button[1]")
	private WebElement addTittlebtn3;
	
	//*[@id="board"]/li[1]/div/div[2]/button[1]  Test1
	
	@FindBy(xpath = "//*[@id=\"board\"]/li[1]/div/div[2]/button[1]")
	private WebElement addcardbtn1;
	
	@FindBy(xpath = "//*[@id=\"board\"]/li[1]/div/ol/form/textarea")
	private WebElement cardText1;
	
	@FindBy(xpath = "")
	private WebElement addcardbtn2;
	
	@FindBy(xpath = "//*[@id=\"board\"]/li/div/div[2]/button[1]")
	private WebElement cardText2;
	
	@FindBy(xpath = "//*[@id=\"board\"]/li[1]/div/div[2]/button[1]")
	private WebElement addcardbtn3;
	
	@FindBy(xpath = "//*[@id=\"board\"]/li[1]/div/ol/form/textarea")
	private WebElement cardText3;
	
	//--------------------------------------
	
	@FindBy(xpath = "//*[@id=\"board\"]/li[2]/div/div[2]/button[1]")
	private WebElement addcardbtnB1;
	
	@FindBy(xpath = "//*[@id=\"board\"]/li[2]/div/ol/form/textarea")
	private WebElement cardTextB1;
	
	@FindBy(xpath = "//*[@id=\"board\"]/li[2]/div/div[2]/button[1]")
	private WebElement addcardbtnB2;
	
	@FindBy(xpath = "//*[@id=\"board\"]/li[2]/div/ol/form/textarea")
	private WebElement cardTextB2;
	
	@FindBy(xpath = "//*[@id=\"board\"]/li[2]/div/div[2]/button[1]")
	private WebElement addcardbtnB3;
	
	@FindBy(xpath = "//*[@id=\"board\"]/li[2]/div/ol/form/textarea")
	private WebElement cardTextB3;
	
	//---------------------------------------------------
	

	@FindBy(xpath = "//*[@id=\\\"board\\\"]/li[3]/div/div[2]/button[1]")
	private WebElement addcardbtnC1;

	
	@FindBy(xpath = "//*[@id=\"board\"]/li[3]/div/ol/form")
	private WebElement cardTextC1;
	
	@FindBy(xpath = "//*[@id=\"board\"]/li[3]/div/ol/form/div/button[1]")
	private WebElement addcardbtnC2;
	
	@FindBy(xpath = "//*[@id=\"board\"]/li[3]/div/ol/form/textarea")
	private WebElement cardTextC2;
	
	@FindBy(xpath = "//*[@id=\"board\"]/li[3]/div/div[2]/button[1]")
	private WebElement addcardbtnC3;
	
	@FindBy(xpath = "//*[@id=\"board\"]/li[3]/div/ol/form/textarea")
	private WebElement cardTextC3;
	
	
	
	public WebElement getcreatebtn() {
		return createbtn;
	}
	
	public WebElement getcreatebobtn() {
		return createbobtn;
	}
	
	
	
	public WebElement 	getboardtTitle() {
		return 	boardtTitle;
	}
	
	public WebElement 	getbordcreateBtn() {
		return 	boardtTitle;
	}
	
	
	
	
}
