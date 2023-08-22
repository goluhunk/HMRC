package pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class AuthLoginPage {

	public WebDriver ldriver;

	public AuthLoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	String login_url          =    "https://www.qa.tax.service.gov.uk/auth-login-stub/gg-sign-in";
	String redirect_url          =    "http://qa.tax.service.gov.uk/hmrc-account/update-your-details";
	
	//WebElement
	
	@FindBy(xpath="//input[@id='redirectionUrl']")
	WebElement redirectURL;
	
	@FindBy(xpath="//select[@id='credentialStrength']")
	WebElement credentialStrength;
	
	@FindBy(xpath="//select[@id='confidenceLevel']")
	WebElement credentialLevel;
	
	@FindBy(xpath="//input[@id='nino']")
	WebElement Nino;
	
	@FindBy(xpath="//input[@id='enrolment[0].name']")
	WebElement enrollmentKey;
	
	@FindBy(xpath="//input[@id='input-0-0-name']")
	WebElement identifierName;
	
	@FindBy(xpath="//input[@id='input-0-0-value']")
	WebElement identifierValue;
	
	@FindBy(xpath="//input[@id='submit']")
	WebElement submit;
	
	
	public void Login(String nino) {
		ldriver.get(login_url);
		redirectURL.sendKeys(redirect_url);
		credentialStrength.sendKeys("strong");
		credentialLevel.sendKeys("200");
		Nino.sendKeys(nino);
		enrollmentKey.sendKeys("HMRC-PT");
		identifierName.sendKeys("NINO");
		identifierValue.sendKeys(nino);
		submit.click();
		
	}

}