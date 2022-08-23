package alchemy.project.hrms;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Addqualification extends HrmProjectSetup{
	
	@Test
	public void addQualification()
	{
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		driver.findElement(By.linkText("Qualifications")).click();
		driver.findElement(By.id("addWorkExperience")).click();
		driver.findElement(By.id("experience_employer")).sendKeys("IBM");
		driver.findElement(By.id("experience_jobtitle")).sendKeys("Test Manager");
		driver.findElement(By.id("experience_from_date")).click();
		Select fromMonth = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		fromMonth.selectByVisibleText("Jan");
		Select fromYear = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		fromYear.selectByVisibleText("2013");
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[2]/a")).click();
		driver.findElement(By.id("experience_to_date")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[3]/a")).click();
		driver.findElement(By.id("btnWorkExpSave")).click();
		
		
	}

}
