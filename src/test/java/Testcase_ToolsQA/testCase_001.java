package Testcase_ToolsQA;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Com_PageObject_ToolsQA.toolQA_PageObject;

public class testCase_001 extends BaseClass_ToolsQA {
	String url = read.getUrl();
	String userfirst = read.getFirstname();
	String userLast = read.getLastname();
	public static toolQA_PageObject obj;
	String date ="02-03-2020";

	public static void initElement() {
		obj = new toolQA_PageObject(driver);
	}

	@Test(priority = 1)
	public void launchUrl() {
		driver.get(url);
		log.info("Url Launched Successfully  ");
	}
	
	@Test(priority=2)
	public void partialLinkTestIspresentValidation() {
		initElement();
		SoftAssert softassert1=new SoftAssert();
		softassert1.assertTrue(obj.partialLinkTestIsPresent(), "Partial link test is not  present");
		softassert1.assertAll();
		log.info("Partial LinkText is present");
	}
	@Test(priority=3)
	public void LinkTestIspresentValidation() {
		initElement();
		SoftAssert softassert2=new SoftAssert();
		softassert2.assertTrue(obj.linkTestIsPresent(), "Link test is not present ");
		softassert2.assertAll();
		log.info("LinkText is present");
		
	}
	@Test(priority=4)
	public void userNameValidation() {
		initElement();
		obj.setfirstName(userfirst);
		obj.setLastName(userLast);
		log.info("user first and last name put successfully");
	
	}
	@Test(priority=5)
	public void continentDropDownValidation() {
		initElement();
		Assert.assertTrue(obj.continentDropDown());
		Assert.assertEquals(obj.getcontinentDropDownValues(),read.getExpectedContinents());
		log.info("both expected and actual continent matchched");
	}
	@Test(priority=6)
	public void sexButtonValidation() {
		initElement();
		obj.sexButton();
		log.info("Sendbox click successully");
	}
	@Test(priority=7)
    public void setCurrentDate() {
		initElement();
		obj.date(date);
		log.info("date is selected perfectly");
	}
	@Test(priority=8)
	public void multipleContinentValidation() {
		initElement();
		Assert.assertEquals(obj.getMultipleContinent(), read.getExpectedMultiContinents());
		log.info("MultiSelect box is selected perfectly");
	}
}
