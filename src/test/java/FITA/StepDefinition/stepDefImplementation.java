package FITA.StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepDefImplementation {
	
	public WebDriver driver;
	
    @Before
    public void setUp() {
        // Initialize WebDriver (example using ChromeDriver)
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

	
	@Given("^Logged in with username(.+) and password (.+)")
	public void Logged_in_with_username_and_password(String username,String password)
	{
		driver.findElement(By.id("userEmail")).sendKeys(username);
		driver.findElement(By.id("userPassword")).sendKeys(password);
		driver.findElement(By.name("login")).click();	
	}
	
	@When("I add product to cart")
	public void i_add_product_to_cart() throws InterruptedException {	
		driver.findElement(By.xpath("(//button[@class='btn w-10 rounded'])[3]")).click();
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("[routerlink='/dashboard/cart']")).click();
	}
	
	@And("checkout and submit the order")
	public void checkout_and_submit_the_order() throws InterruptedException {
		// Click the button in the totalRow
		driver.findElement(By.cssSelector(".totalRow button")).click();
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		
	}
	
	
	@Then("Get the confirmation message")
	public void get_the_confirmation_message() {
		
		WebElement element = driver.findElement((By.cssSelector(".action__submit")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		System.out.println(confirmMessage);
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
	
	
	
	}
	
	
