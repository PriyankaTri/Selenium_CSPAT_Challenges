package selenium_assignment;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class task1 {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver" , "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		wait=new WebDriverWait(driver, 20);
		driver.get("https://www.meripustak.com/");
	}
	
	@Test(priority=1)
	public void printHeightWidth() {
	WebElement Image = driver.findElement(By.xpath("//img[@title='Meripustak Online bookstore']"));
	
	//Get width of logo.
    int ImageWidth = Image.getSize().getWidth();
    System.out.println("Image width Is "+ImageWidth+" pixels");
    
    //Get height of logo.
    int ImageHeight = Image.getSize().getHeight();
    System.out.println("Image height Is "+ImageHeight+" pixels");
    
	}
	
	@Test(priority=2)
	public void getTwitterHref() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		String href= driver.findElement(By.xpath("//a[@href='https://twitter.com/meripustak']")).getAttribute("href");
		System.out.println(href);
	}
	
	@Test(priority=3)
	public void clickCart() {
		if(driver.findElement(By.xpath("//span[@id='lblNoCartItem']")).getText().contains("0 Item"))
		driver.findElement(By.xpath("//a[@href='https://www.meripustak.com/cart']")).click();
	}
	
	@Test(priority=4)
	public void assertCart() throws Exception {
		if(driver.findElement(By.xpath("//span[@id='lblNoCartItem']")).getText().contains("0 Item"))
		driver.findElement(By.xpath("//a[@href='https://www.meripustak.com/cart']")).click();
		Thread.sleep(3000);
		String assertmsg = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_gvCartTable']")).getText();
		Assert.assertEquals("No Item is Added In Cart yet.Cart is Empty!!!", assertmsg);
		
	}
	
	@Test(priority=5)
	public void addCart() throws Exception {
		driver.findElement(By.xpath("//input[@id='txtsearch']")).sendKeys("Java Book");
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='pimg']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_AddtoCart']")).click();
		String str = driver.findElement(By.xpath("//span[@id='lblNoCartItem']")).getText();
		System.out.println(str);
		Assert.assertTrue(!str.contains("No Item is Added In Cart yet.Cart is Empty!!!"));
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
