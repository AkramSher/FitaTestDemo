package FITA.SeleniumFramework;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReport 
{
    ExtentReports extent;

    @BeforeTest
    public void setUp() {
        extent = getReportObject(); // Initialize the extent object before the test
    }

    @Test
    public void StandaloneTest() {
        ExtentTest test = extent.createTest("StandaloneTest");
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        String productName = "ZARA COAT 3";
        driver.get("https://rahulshettyacademy.com/client");
        driver.manage().window().maximize();    
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.findElement(By.id("userEmail")).sendKeys("qaakramsheriff@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Test@123");
        driver.findElement(By.name("login")).click();   
        // Ensure that flush() is called after the test completes
        extent.flush();
    }  
    
    
    @Test
    public void sampleDemo()
    {
    	ExtentTest test = extent.createTest("sampleDemo");
    	System.out.println("Test Data");
    	extent.flush();
    }
    

    public ExtentReports getReportObject() {
    	
        String path = System.getProperty("user.dir") + "//reports//index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results FITA");
        reporter.config().setDocumentTitle("Test Results");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Fita test demo");
        return extent;
    }
}
