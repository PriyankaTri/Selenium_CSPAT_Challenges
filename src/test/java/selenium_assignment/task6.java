package selenium_assignment;


import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class task6 {
	
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
		driver.get(" https://www.woodlandworldwide.com/");
	}
	
	@Test
	public void useProduct1() throws Exception {
		
		File src = new File("./Assignment_selenium.xlsx");
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet ws=wb.getSheetAt(0);
		String product1=ws.getRow(0).getCell(0).getStringCellValue();
		System.out.println(product1);
		driver.findElement(By.xpath("//div[@class='floatright spirit-bg search-icon searchIcon']")).click();
		driver.findElement(By.xpath("//input[@id='searchkey']")).sendKeys(product1);
		driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//label[@class='spirit-bg radio1'])[1]")).click();
		
		List<WebElement> elements = driver.findElements(By.xpath("//span[@class='mrp']"));
		
		String[] str = new String[8];
		String[] strtrim = new String[8];
		int[] price = new int[8];
		 
		for(int i=0;i<8;i++) {
			str[i]=elements.get(i).getText();
			strtrim[i]=str[i].substring(2, str[i].length());
			price[i]=Integer.parseInt(strtrim[i].toString());
		}
		
		 for(int k=0; k <= 6; k++)
	        {
	            Assert.assertTrue(price[k] >= price[k+1]);
	        }
		wb.close();
		
	}
	
	@Test
	public void useProduct2() throws Exception {
		File src = new File("./Assignment_selenium.xlsx");
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet ws=wb.getSheetAt(0);
		String product2=ws.getRow(1).getCell(0).getStringCellValue();
		
		driver.findElement(By.xpath("//div[@class='floatright spirit-bg search-icon searchIcon']")).click();
		driver.findElement(By.xpath("//input[@id='searchkey']")).sendKeys(product2);
		driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//label[@class='spirit-bg radio1'])[1]")).click();
		
		List<WebElement> elements = driver.findElements(By.xpath("//span[@class='mrp']"));
		
		String[] str = new String[8];
		String[] strtrim = new String[8];
		int[] price = new int[8];
		 
		for(int i=0;i<8;i++) {
			str[i]=elements.get(i).getText();
			strtrim[i]=str[i].substring(2, str[i].length());
			price[i]=Integer.parseInt(strtrim[i].toString());
		}
		
		 for(int k=0; k <= 6; k++)
	        {
	            Assert.assertTrue(price[k] >= price[k+1]);
	        }
		wb.close();
		
	}
	
	@Test
	public void useProduct3() throws Exception {
		File src = new File("./Assignment_selenium.xlsx");
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet ws=wb.getSheetAt(0);
		String product3=ws.getRow(2).getCell(0).getStringCellValue();
		
		driver.findElement(By.xpath("//div[@class='floatright spirit-bg search-icon searchIcon']")).click();
		driver.findElement(By.xpath("//input[@id='searchkey']")).sendKeys(product3);
		driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//label[@class='spirit-bg radio1'])[1]")).click();
		
		List<WebElement> elements = driver.findElements(By.xpath("//span[@class='mrp']"));
		
		String[] str = new String[8];
		String[] strtrim = new String[8];
		int[] price = new int[8];
		 
		for(int i=0;i<8;i++) {
			str[i]=elements.get(i).getText();
			strtrim[i]=str[i].substring(2, str[i].length());
			price[i]=Integer.parseInt(strtrim[i].toString());
		}
		
		 for(int k=0; k <= 6; k++)
	        {
	            Assert.assertTrue(price[k] >= price[k+1]);
	        }
		
		wb.close();
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
