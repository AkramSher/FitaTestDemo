package FITA.SeleniumFramework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

	WebDriver driver;
	
	public ProductsPage(WebDriver driver)
	{
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	
	@FindBy(xpath="(//button[@class='btn w-10 rounded'])[3]")
	private WebElement Iphone13AddtoCart;
	
	@FindBy(xpath="(//button[@class='btn w-10 rounded'])[2]")
	private WebElement AdidasAddtoCart;
	
	@FindBy(xpath="(//button[@class='btn w-10 rounded'])[1]")
	private WebElement zaraAddtoCart;
	

	public void selectingProduct()
	{
		Iphone13AddtoCart.click();
	}

	
	
	
	
}
