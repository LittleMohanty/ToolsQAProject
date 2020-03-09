package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class genericMethods {
	public WebDriver driver;
	
	public genericMethods(WebDriver driver){
		this.driver = driver;
	}
	
	public void  WindowScrollHandle(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].scrollIntoView();",element );
		js.executeScript("window.scrollBy(0,-100)");
		
	}

}
