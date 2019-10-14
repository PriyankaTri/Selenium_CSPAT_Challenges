package selenium_assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class task2 {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	
	@Before
	public void openFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver" , "drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		wait=new WebDriverWait(driver, 20);
		driver.get("https://www.cii.in/OnlineRegistration.aspx");
	}
	
	@Test
	public void selectAttendees() {
		WebElement ddlist = driver.findElement(By.id("drpAttendee"));
		Select s = new Select(ddlist);
		s.selectByValue("3");
		List<WebElement> list = driver.findElements(By.xpath("//table[@id='Gridview1']/tbody/tr/td[1]"));
		int rowcount = list.size();
		System.out.println(rowcount);
		Assert.assertEquals(rowcount, 3);
	
	}
	
	@Test
	public void selectFirstRow() throws Exception {
		WebElement ddlist = driver.findElement(By.id("drpAttendee"));
		Select s = new Select(ddlist);
		s.selectByValue("3");
		Thread.sleep(3000);
		WebElement ddlist1 = driver.findElement(By.id("Gridview1_ctl02_drpTitle"));
		Select s1 = new Select(ddlist1);
		s1.selectByValue("Admiral");
	
	}
	
	@Test
	public void selectSecondRow() throws Exception {
		WebElement ddlist = driver.findElement(By.id("drpAttendee"));
		Select s = new Select(ddlist);
		s.selectByValue("3");
		Thread.sleep(3000);
		WebElement ddlist1 = driver.findElement(By.id("Gridview1_ctl03_drpTitle"));
		Select s1 = new Select(ddlist1);
		s1.selectByValue("CA");
	}
	
	@Test
	public void selectThirdRow() throws Exception {
		WebElement ddlist = driver.findElement(By.id("drpAttendee"));
		Select s = new Select(ddlist);
		s.selectByValue("3");
		Thread.sleep(3000);
		WebElement ddlist1 = driver.findElement(By.id("Gridview1_ctl04_drpTitle"));
		Select s1 = new Select(ddlist1);
		s1.selectByValue("CS");
	}
	
	@Test
	public void printAllOption() {
		WebElement ddlist = driver.findElement(By.id("drpRegTitle"));
		Select s = new Select(ddlist);
		List<WebElement> alloptions = s.getOptions();
		int count = alloptions.size();
		for(int i=0; i<count;i++) {
			System.out.println(alloptions.get(i).getText());
		}
	}
	
	@After
	public void closeBrowser() {
		driver.close();
	}
}
