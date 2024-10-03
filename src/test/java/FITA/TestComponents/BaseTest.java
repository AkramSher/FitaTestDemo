package FITA.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import FITA.SeleniumFramework.pageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingPage;
	
	public WebDriver initializeDriver() throws IOException {
	    // Load properties
	    Properties prop = new Properties();
	    FileInputStream fis = new FileInputStream("C:\\Users\\Akram\\eclipse-workspace\\SeleniumFramework\\src\\main\\java\\FITA\\resources\\GlobalData.properties");
	    prop.load(fis);

	    String browserName = System.getProperty("browser") != null ?
	                         System.getProperty("browser") : prop.getProperty("browser");

	    if (browserName.equalsIgnoreCase("chromeHeadless")) {
	        ChromeOptions options = new ChromeOptions();
	        WebDriverManager.chromedriver().setup();
	        options.addArguments("headless");
	        driver = new ChromeDriver(options);  // Assign to the instance-level driver
	    } 
	    else if (browserName.equalsIgnoreCase("chrome")) {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();  // Assign to the instance-level driver
	    } 
	    else if (browserName.equalsIgnoreCase("firefox")) {
	        WebDriverManager.firefoxdriver().setup();
	        driver = new FirefoxDriver();  // Assign to the instance-level driver
	    }

	    if (driver != null) {  // Ensure driver is initialized
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	    } else {
	        throw new RuntimeException("Failed to initialize the browser driver");
	    }
	    
	    return driver;
	}
	
	
	 public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
	        
		 // Read JSON to string
	        String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

	        // Convert String to HashMap using Jackson ObjectMapper
	        ObjectMapper mapper = new ObjectMapper();
	        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {});
	        return data;
	    }
	 
	 
		public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
			FileUtils.copyFile(source, file);
			return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";	
		}
		
//		public ExtentReports getReportObject()
//		{
//			String path =System.getProperty("user.dir")+"//reports//index.html";
//			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
//			reporter.config().setReportName("Web Automation Results");
//			reporter.config().setDocumentTitle("Test Results");
//
//			ExtentReports extent =new ExtentReports();
//			extent.attachReporter(reporter);
//			extent.setSystemInfo("Tester", "Rahul Shetty");
//			return extent;
//		}
	 
	
	@BeforeMethod()
	public LandingPage launchapplication() throws IOException
	{
		driver=initializeDriver();
		LandingPage landingPage= new LandingPage(driver);
		landingPage.goTo();
//		Lp.loginApplication("qaakramsheriff@gmail.com", "Test@123");
		return landingPage;
	}
	
	
	
	@AfterMethod
	public void tearDOwn()
	{
		driver.close();
	}

}