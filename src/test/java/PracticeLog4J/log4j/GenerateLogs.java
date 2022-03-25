package PracticeLog4J.log4j;

import java.time.Duration;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GenerateLogs {
	
	public WebDriver driver;
	
	private static final Logger log=LoggerFactory.getLogger(GenerateLogs.class);
	
	@BeforeTest
	public void beforeTest()
	{
		PropertyConfigurator.configure("log4j.properties");
		
		log.info("Setting the browser");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\graje\\Downloads\\chromedriver_win32\\chromedriver.exe");

		log.info("initializing the browser");
		driver = new ChromeDriver();

		log.info("Maximizing the window");
		driver.manage().window().maximize();

		log.info("Delete All cookies");
		driver.manage().deleteAllCookies();

		log.info("Implicity waiting");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));

		log.info("Opening the URL");
		driver.get("https://www.google.com/");
		
		System.out.println("Opening the google URL");
	}

	@Test
	public void init()
	{

		String actualtitle = driver.getTitle();
		log.error("Title is correct");
		Assert.assertEquals(actualtitle, "Google");
	}
	
	@Test
	public void init2()
	{
		String currenturl = driver.getCurrentUrl();
		log.error("URL is correct");
		System.out.println(currenturl);
		log.trace("Message is Traced in first class");
		System.out.println("Verifying url is correct or not");
		System.out.println("hi hello namasthe addaaab");
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.close();
		System.out.println("closing the browser");
	}

}
