package FITA.SeleniumFramework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import FITA.SeleniumFramework.pageObjects.CartPage;
import FITA.SeleniumFramework.pageObjects.CheckoutPage;
import FITA.SeleniumFramework.pageObjects.LandingPage;
import FITA.SeleniumFramework.pageObjects.ProductsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrder {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
	    //LandingPage
		LandingPage Lp= new LandingPage(driver);
		driver.manage().window().maximize();
		Lp.goTo();
		Lp.loginApplication("qaakramsheriff@gmail.com", "Test@123");
		//Productspage
		ProductsPage products = new ProductsPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));		
		products.selectingProduct();	
		//GO to Cart Page
		CartPage cart = new CartPage(driver);
		cart.Clickcartcheckout();
		//CheckoutPage
		CheckoutPage cp= new CheckoutPage(driver);
		cp.checkout();
	}	
	
	
	
	}

