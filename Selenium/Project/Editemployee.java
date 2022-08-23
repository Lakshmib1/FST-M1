package alchemy.project.hrms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Editemployee extends HrmProjectSetup{

	@Test//(dependsOnMethods = "alchemy.project.hrms.Addemployee.addEmployee")
	public void editEmployee()
	{
		driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']")).click();
		driver.findElement(By.xpath("//input[@value='Edit']")).click();
		WebElement firstName = driver.findElement(By.id("personal_txtEmpFirstName"));
		firstName.clear();
		firstName.sendKeys("Lakshmi");
		WebElement lastName = driver.findElement(By.id("personal_txtEmpLastName"));
		lastName.clear();
		lastName.sendKeys("Balakrishnan");
		driver.findElement(By.id("personal_optGender_2")).click();
		driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
		
		
	}
}
