package selenium_assignment;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.After;
import org.junit.Assert;



public class task4 {

	public WebDriver driver;
	public WebDriverWait wait;
	
	
	@Before
	public void openFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver" , "drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		wait=new WebDriverWait(driver, 30);
		driver.get("https://www.hometown.in/");
		
	}
	
	@Test
	public void selectBlack() throws Exception {
		System.out.println("test");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='onesignal-popover-cancel-button']")).click();
		Actions ac = new Actions(driver);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Electronics']")).click();
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//button[contains(text(), 'Color')]"));
		ac.moveToElement(element).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[contains(text(), 'Black')]")).click();
		WebElement element1 = driver.findElement(By.xpath("//img[@class='Product__ProductImg-sc-1rop1s7-0 fABMoW'][1]"));
		ac.moveToElement(element1).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='QuickView__QuickViewBtn-sc-1sntg1-0 isPHJW'][1]")).click();
		String str = driver.findElement(By.xpath("//h1[@class='Heading-sc-1xt1x3f-0 efiseG']")).getText();
		System.out.println(str);
		Assert.assertTrue(str, str.contains("Black"));
		driver.findElement(By.xpath("//button[@class='styles_closeButton__20ID4']")).click();
		String str2 = driver.findElement(By.xpath("//div[@class='_1C7t6hCkKmMddDs8HIk_KY']/ul/li[2]")).getText();
		System.out.println(str2);
		Assert.assertEquals("Black",str2);
	}
	
	@After
	public void closeBrowser() {
		driver.close();
	}
	
}
