package Com_PageObject_ToolsQA;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.genericMethods;

public class toolQA_PageObject extends genericMethods {
	WebDriver driver;

	public toolQA_PageObject(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Partial Link Test")
	WebElement partialLinkTest;
	@FindBy(linkText = "Link Test")
	WebElement linkTest;
	@FindBy(xpath = "//input[@name='firstname']")
	WebElement firstName;
	@FindBy(xpath = "//input[@id='lastname']")
	WebElement lastName;
	@FindBy(id = "continents")
	WebElement continentDropDown;
	@FindBy(id = "sex-1")
	WebElement sex;
	@FindBy(id = "datepicker")
	WebElement date;
	@FindBy(id = "continentsmultiple")
	WebElement multiplecontinent;

	public String title() {
		return driver.getTitle();
	}

	public boolean partialLinkTestIsPresent() {
		boolean partiallink = partialLinkTest.isDisplayed();
		return partiallink;
	}

	public boolean linkTestIsPresent() {
		boolean link = linkTest.isDisplayed();
		return link;

	}

	public void setfirstName(String first) {
		WindowScrollHandle(firstName);
		firstName.sendKeys(first);
	}

	public void setLastName(String last) {
		WindowScrollHandle(lastName);
		lastName.sendKeys(last);
	}

	public boolean continentDropDown() {
		return continentDropDown.isDisplayed();

	}

	public List<String> getcontinentDropDownValues() {
		Select dropDown = new Select(continentDropDown);
		List<WebElement> dp = dropDown.getOptions();
		List<String> continentsList = new ArrayList<String>();
		Iterator<WebElement> it = dp.iterator();
		while (it.hasNext()) {
			continentsList.add(it.next().getText());

		}

		return continentsList;
	}

	public void sexButton() {
		sex.click();
	}

	public void date(String time) {
		date.sendKeys(time);
	}

	public List<String> getMultipleContinent() {
		Select multi = new Select(multiplecontinent);
		List<WebElement> lp = multi.getOptions();
		List<String> ls = new ArrayList<String>();
		Iterator<WebElement> it = lp.iterator();
		while(it.hasNext()) {
			ls.add(it.next().getText());
		}
		return ls;

	}
}
