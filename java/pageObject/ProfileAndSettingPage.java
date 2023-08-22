package pageObject;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;


public class ProfileAndSettingPage  {

	public WebDriver ldriver;

	public ProfileAndSettingPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}




	@FindAll(@FindBy(xpath="//dt[@class='govuk-summary-list__key']"))
	List<WebElement> personaldetails;

	@FindAll(@FindBy(xpath="//dd[@class='govuk-summary-list__value']"))
	List<WebElement> values;

	List<String> personalDetails =new ArrayList<String>();
	List<String> Values =new ArrayList<String>();
	Map<String,String> map=new HashMap<>();
	//Action

	public Map<String, String> getPersonalDetails(){

		for(WebElement e:personaldetails) { 
			personalDetails.add(e.getText());
			// System.out.println("personalDetails ="+ e.getText());
		}

		for(WebElement e:values)
		{
			Values.add(e.getText());
		}
		for(int i=0;i<personalDetails.size();i++)
		{ 
			map.put(personalDetails.get(i), Values.get(i));
		}
		return map;

	}
	
	public String getDetails(String details) {
		return getPersonalDetails().get(details).replaceAll("\n"," ");
	}
	public String getTitles() {
		return ldriver.getTitle();
	}

}
