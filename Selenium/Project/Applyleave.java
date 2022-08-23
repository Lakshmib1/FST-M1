package alchemy.project.hrms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Applyleave extends HrmProjectSetup{

	@Test
	public void applyLeave() {
		
		driver.findElement(By.id("menu_leave_viewLeaveModule")).click();
		driver.findElement(By.id("menu_leave_applyLeave")).click();
		Select type = new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
		type.selectByVisibleText("DayOff");
		driver.findElement(By.id("applyleave_txtFromDate")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[3]/a")).click();
		driver.findElement(By.id("applyleave_txtComment")).sendKeys("Planned Vacation");
		driver.findElement(By.id("applyBtn")).click();
		driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
		driver.findElement(By.id("calFromDate")).click();
		Select fromMonth = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		fromMonth.selectByVisibleText("Aug");
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[3]/a")).click();
		driver.findElement(By.id("calToDate")).click();
		Select toMonth = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		toMonth.selectByVisibleText("Aug");
		Select toYear = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		toYear.selectByVisibleText("2022");
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[3]/a")).click();
		driver.findElement(By.name("btnSearch")).click();
		String status = driver.findElement(By.linkText("Pending Approval(1.00)")).getText();
		Assert.assertEquals(status, "Pending Approval(1.00)");
		
		
		
	}
}
