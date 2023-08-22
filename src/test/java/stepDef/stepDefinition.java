package stepDef;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.AuthLoginPage;
import pageObject.ProfileAndSettingPage;





public class stepDefinition {

	public WebDriver driver;
	public AuthLoginPage alp;
	public ProfileAndSettingPage pasp;
	
	@Before
	public void setup() {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}

	@Given("I launch Browser")
	public void i_launch_browser() {
		
		alp=new AuthLoginPage(driver);
		pasp=new ProfileAndSettingPage(driver);
	}


	@When("I am logged in with Nino {string} and on Chocs service page")
	public void i_am_logged_in_with_nino(String nino) {
		
		alp.Login(nino.replaceAll("\\s",""));
	}

	@Then("I should see the below details on {string} page")
	public void i_should_see_the_below_details_on_page(String string,DataTable dataTable) {

		//System.out.println("Inside Then"+string + "----"+ dataTable);

		List<Map<String, String>> data =  dataTable.asMaps();
		for(Map map:data) {
			String details=(String) map.get("Personal Details");
			String value=(String) map.get("Value");
			//System.out.println(value);
			Assert.assertTrue(pasp.getDetails(details).equals(value));
			// pasp.getDetails(details).equals(value);
			}
	

	}

	@Then("I close the browser")
	public void tearDown() {
		driver.close();
	}
}

