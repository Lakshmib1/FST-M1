package alchemy.activity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity13_2b {

	@Test
	public void getDataExcel() throws IOException
	{
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.training-support.net/selenium/simple-form");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String filePath = "C:\\TestLeaf\\Eclipse-Workspace\\Selenium\\src\\main\\resources\\sample.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook wbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = wbook.getSheet("Sheet1");
		int rowcount = sheet.getPhysicalNumberOfRows();
		System.out.println(rowcount);
		int cellcount = sheet.getRow(1).getPhysicalNumberOfCells();
		System.out.println(cellcount);
		for (int i=1;i<=rowcount;i++)
		{
			XSSFRow row = sheet.getRow(i);
			
			String firstname = row.getCell(0).getStringCellValue();
			String lastname = row.getCell(1).getStringCellValue();
			String mail = row.getCell(2).getStringCellValue();
			String number = row.getCell(3).getStringCellValue();
			
			driver.findElement(By.xpath("//input[@placeholder = 'First Name']")).sendKeys(firstname);
			driver.findElement(By.xpath("//input[@placeholder = 'Last Name']")).sendKeys(lastname);
			driver.findElement(By.id("email")).sendKeys(mail);
			driver.findElement(By.id("number")).sendKeys(number);
			driver.findElement(By.xpath("//input[@value='submit']")).click();
			
			driver.switchTo().alert().accept();
			
		
		}
		
		
		driver.close();
		
				
		
	}
}
