package FITA.SeleniumFramework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

		
		WebDriver driver;
		
		public LandingPage(WebDriver driver)
		{
//			super(driver);
			//initialization
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		}
			
		//WebElement userEmails = driver.findElement(By.id("userEmail"));
		//PageFactory
		
		
		@FindBy(id="userEmail")
		private WebElement userEmailTest;
		
		@FindBy(id="userPassword")
		private WebElement passwordEle;
		
		@FindBy(id="login")
		private WebElement submit;
		
		@FindBy(css="[class*='flyInOut']")
		private WebElement errorMessage;


		
		public void loginApplication(String email,String password)
		{
			userEmailTest.sendKeys(email);
			passwordEle.sendKeys(password);
			submit.click();
			
		}

		
		public void goTo ()
		{
			driver.get("https://rahulshettyacademy.com/client");
		}

	}


