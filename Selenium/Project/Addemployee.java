package alchemy.project.hrms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Addemployee extends HrmProjectSetup{
 
	@Test
	public void addEmployee()
	{
		// Add Employee
		driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
		driver.findElement(By.name("btnAdd")).click();
		driver.findElement(By.name("firstName")).sendKeys("Lakshmi");
		driver.findElement(By.name("lastName")).sendKeys("Balakrishnan");
		driver.findElement(By.id("btnSave")).click();
		//Navigating back to PIM and search for the added employee
		driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
		driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("Lakshmi",Keys.TAB);
		WebElement searchButton = driver.findElement(By.id("searchBtn"));
		wait.until(ExpectedConditions.elementToBeClickable(searchButton));
		searchButton.click();
		driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[3]/a")).isDisplayed();
		System.out.println("Employee Added successfully");
		
	}
}
