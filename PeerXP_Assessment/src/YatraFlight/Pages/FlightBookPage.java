package YatraFlight.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightBookPage {

	WebDriver driver;
	
	@FindBy(id="BE_flight_origin_city")
	WebElement city1;
	
	@FindBy(xpath="//li/div/p[contains(text(), 'Bangalore')]")
	WebElement selectcity1;
	
	@FindBy(name="flight_destination")
	WebElement city2;
	
	@FindBy(xpath="//div/p[contains(text(), 'New Delhi')]")
	WebElement selectcity2;
	
	@FindBy(id="BE_flight_origin_date")
	WebElement date;
	
	@FindBy(xpath="//td[@title='Saturday, 26 June 2021']")
	WebElement Seldate;
	
	@FindBy(id="BE_flight_flsearch_btn")
	WebElement clickS;
	
	public void DepartCity(String name1) throws InterruptedException 
	{
		city1.click();
		
			
			city1.sendKeys(name1);
			Thread.sleep(1000);
			city1.sendKeys(Keys.ENTER);
						
	}
public void ArrivalCity(String name2) throws InterruptedException
{
	city2.click();
	
	city2.sendKeys(name2);
	Thread.sleep(1000);

	city2.sendKeys(Keys.ENTER);
	
//	JavascriptExecutor js = (JavascriptExecutor)driver;
//	js.executeScript("arguments[0].click()", city2);

	
}

public void seldate() throws InterruptedException
{
	date.click();
	Thread.sleep(1000);
	Seldate.click();
	
}

public void cli_btn()
{
	clickS.click();
}
 public FlightBookPage(WebDriver driver)
 {
	 PageFactory.initElements(driver, this);
	 this.driver=driver;
 }
 
}
