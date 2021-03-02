package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class commonfunctions {
	
	
	public static WebDriver driver = null;
	private static Properties properties = null;
	final static Logger log = Logger.getLogger(commonfunctions.class.getName());
	
	public String getPropertyValue(String propertyName) throws IOException {
		properties = new Properties();
		properties.load(new FileInputStream("config.properties"));
		return properties.getProperty(propertyName);
	}

	@BeforeSuite
	public void launchbrowser() throws IOException {
		PropertyConfigurator.configure("log4j.properties");
		String browser = getPropertyValue("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		Reporter.log("Maximize the Browser and clearing all cookies",true);
		log.debug("Maximize the Browser and clearing all cookies");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(getPropertyValue("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(getPropertyValue("implicit_time"))));

	}
		
	@AfterSuite
	public void teardown() {
		Reporter.log("Closing the Browser",true);
		log.debug("Closing the Browser");
		driver.close();
		driver.quit();

	}
}

