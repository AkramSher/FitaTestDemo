package FITA.SeleniumFramework.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckoutPage {
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
//	
//	Actions a = new Actions(driver);
//	a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
	
	
	
	
//	driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	
//	WebElement element = wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector(".action__submit"))));
//	element.click();
	
//	WebElement element = driver.findElement((By.cssSelector(".action__submit")));
//	((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//	
//	
//	String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
//	System.out.println(confirmMessage);
//	Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	
	
	@FindBy(css="[placeholder='Select Country']")
	private WebElement selectcountry;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	private WebElement taitem2;
	
	@FindBy(css=".action__submit")
	private WebElement placeorder;
	

	public  void checkout()
	{
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
//		selectcountry.sendKeys("india");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		taitem2.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", placeorder);
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		System.out.println(confirmMessage);
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	}

}
