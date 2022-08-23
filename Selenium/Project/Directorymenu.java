package alchemy.project.hrms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Directorymenu extends HrmProjectSetup{
	
	@Test//(dependsOnMethods = "alchemy.project.hrms.Editemployee.editEmployee")
	public void directoryMenuVerification()
	{
		WebElement directory = driver.findElement(By.id("menu_directory_viewDirectory"));
		boolean displayed = directory.isDisplayed();
		System.out.println("Directory menu is displayed "+displayed);
		wait.until(ExpectedConditions.visibilityOf(directory));
		directory.click();
		String text = driver.findElement(By.xpath("//h1[text()='Search Directory']")).getText();
		Assert.assertEquals(text, "Search Directory");
		System.out.println("Heading of the page matches --> Search Directory");
		
	}
}
