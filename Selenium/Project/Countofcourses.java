package alchemy.project.lms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Countofcourses extends LmsProjectSetup {
	
	@Test
	public void countcourses()
	{
		driver.findElement(By.linkText("All Courses")).click();
		List<WebElement> noofcourses = driver.findElements(By.xpath("//div[@id='ld_course_list']/div/div/div"));
		System.out.println("The Number of Courses are "+noofcourses.size());
	}

}
