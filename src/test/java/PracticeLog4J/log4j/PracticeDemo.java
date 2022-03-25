package PracticeLog4J.log4j;


import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PracticeDemo {
	
	 public WebDriver driver;
	 private static final Logger log=LoggerFactory.getLogger(PracticeDemo.class);
	  
		
		@Test
		public void beforeTest()
		{
			PropertyConfigurator.configure("log4j.properties");
			
			log.debug("opening chromedriver");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\graje\\Downloads\\chromedriver_win32\\chromedriver.exe");
			
			log.trace("This is tracer message");
			driver = new ChromeDriver();
			
			log.error("maximizing window");
			driver.manage().window().maximize();
			
			log.info("opening apache link in second test case");
			driver.get("https://www.apache.org/dyn/closer.lua/logging/log4j/2.17.1/apache-log4j-2.17.1-bin.zip");
			
			System.out.println(driver.getTitle());
		}
		
}
