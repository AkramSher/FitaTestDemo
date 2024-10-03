package FITA.SeleniumFramework;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FITA.SeleniumFramework.pageObjects.CartPage;
import FITA.SeleniumFramework.pageObjects.CheckoutPage;
import FITA.SeleniumFramework.pageObjects.LandingPage;
import FITA.SeleniumFramework.pageObjects.ProductsPage;
import FITA.TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderDataProvider1 extends BaseTest {

	@Test(dataProvider="Passdata")
	public void DataproviderTest(HashMap<String, String> inputData) throws InterruptedException {
		ProductsPage products = new ProductsPage(driver);		
		products.selectingProduct();	
		//GO to Cart Page
		CartPage cart = new CartPage(driver);
		cart.Clickcartcheckout();
		//CheckoutPage
		CheckoutPage cp= new CheckoutPage(driver);
		cp.checkout();
	}	
	
//	@DataProvider(name = "Passdata")
//	public Object[][] Passdata()
//	{
//      {
//
//      return new Object[][]  {{"qaakramsheriff@gmail.com","Test@123"}, {"qaakramsheriff@gmail.com","Iamking@000" },{"username@gmail.com","test"} };
//	}
//	}
	
	
	
	@DataProvider(name = "Passdata")
	public Object[][] Passdata() throws IOException {
		
	    List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//FITA//data//PurchaseOrder.json");
	    return new Object[][] {{data.get(0)}, {data.get(1)}};
	}
	
	
	@Test(dependsOnMethods= {"DataproviderTest"})
	public void OrderHistoryTest()
	{
	System.out.println("This block will be executed only after DataproviderTest");
	}
}

