package Testcase_ToolsQA;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utilities.ReadConfig;
import Utilities.genericMethods;

public class BaseClass_ToolsQA {
	static ReadConfig read = new ReadConfig();
	
	
	public static WebDriver driver;
	public static Logger log;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./Driver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		log=Logger.getLogger("ToolsQA");
		PropertyConfigurator.configure("Log4j.properties");

	}
	public void captureScreen( String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshot/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	

}
