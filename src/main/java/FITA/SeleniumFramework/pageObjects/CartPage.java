package FITA.SeleniumFramework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}



	@FindBy(css="[routerlink='/dashboard/cart']")
	private WebElement clickCart;
	
	@FindBy(css=".totalRow button")
	private WebElement clickCartCheckout;
	

	public void Clickcartcheckout() throws InterruptedException
	{
		Thread.sleep(2000);
		clickCart.click();
		clickCartCheckout.click();
	}

	
}
