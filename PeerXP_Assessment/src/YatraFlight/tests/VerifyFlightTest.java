package YatraFlight.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import YatraFlight.Pages.FlightBookPage;

public class VerifyFlightTest {

	WebDriver driver;
	FlightBookPage fb;
	File f1;
	FileInputStream fis;
	Properties p;
	
	
	@BeforeTest
	public void setdriver()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium-Workspace\\Selenium_Learning\\Drivers\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		fb=new FlightBookPage(driver);
	}
	
	@Test(priority=1)
	public void laun() throws InterruptedException
	{
		driver.get("https://www.yatra.com/");
		Assert.assertEquals(driver.getTitle(), "Flight, Cheap Air Tickets , Hotels, Holiday, Trains Package Booking - Yatra.com");
		Thread.sleep(2000);
		
	}
	@Test(priority=2)
	public void Departfrom() throws InterruptedException, IOException
	{
		
		// fb.DepartCity("Bangalore");
		
		File f1= new File("DataFile\\flight.properties");
		fis= new FileInputStream(f1);
		p = new Properties();
		p.load(fis);
		fb.DepartCity(p.getProperty("DCity"));
		Thread.sleep(1000);
		System.out.println("The departure city selected is:" +p.getProperty("DCity"));
		
		fb.ArrivalCity(p.getProperty("ACity"));
		Thread.sleep(1000);
		System.out.println("The arrival city Selected is:" +p.getProperty("ACity"));	
	}
	
//	@Test(priority=3)
//	public void ArriveTo() throws InterruptedException
//	{
//		fb.ArrivalCity("New Delhi");
//		
//	}
	
	@Test(priority=3)
	public void Selectdate() throws InterruptedException
	{
		fb.seldate();
		Thread.sleep(1000);
		
	}
	
	@Test(priority=4)
	public void searchbtn()
	{
		fb.cli_btn();

	}
	
	@AfterTest
	public void terminate()
	{
		driver.close();
	}
}
