package selenium_assignment;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class task3 {

	public WebDriver driver;
	public WebDriverWait wait;
	
	
	@Before
	public void openFirefoxBrowser() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver" , "drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		wait=new WebDriverWait(driver, 20);
		driver.get("https://www.premierleague.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='btn-primary cookies-notice-accept']")).click();
	
	}
	
	@Test
	public void clickTable() throws Exception {
		
		driver.findElement(By.xpath("//li[@data-nav-index='3']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Actions ac =new Actions(driver);
		WebElement element=driver.findElement(By.xpath("//a[@href='/clubs/1/Arsenal/overview'][1]"));
		Thread.sleep(3000);
		//ac.keyDown(Keys.SHIFT).click(element).build().perform();
		
	      ac.contextClick(element).perform();
	      Robot robo = new Robot();
	     robo.keyPress(KeyEvent.VK_DOWN);
	     robo.keyPress(KeyEvent.VK_DOWN);
	     robo.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);

		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
        String parentId = it.next();
        String childId = it.next();
		driver.switchTo().window(childId);
		String officialsite=driver.findElement(By.xpath("//a[contains(text(),'www.arsenal.com')]")).getText();
		System.out.println(officialsite);
		String title = driver.getTitle();
		System.out.println(title);
		Thread.sleep(3000);
		driver.switchTo().window(parentId);
		String maintitle = driver.getTitle();
		System.out.println(maintitle);
	}
	
	@After
	public void closeBrowser() {
		driver.close();
	}
	
}
