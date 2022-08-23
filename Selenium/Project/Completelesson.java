package alchemy.project.lms;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Completelesson extends LmsProjectSetup{

	@Test
	public void completeLesson()
	{
		driver.findElement(By.linkText("All Courses")).click();
		driver.findElement(By.xpath("//*[@id=\"post-69\"]/div[2]/p[2]/a")).click();
		driver.findElement(By.xpath("(//span[text()='Expand'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='This is the First Topic']")).click();
		String title = driver.getTitle();
		System.out.println("Title of the page is " +title);
	}
}
