package alchemy.project.lms;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Contactadmin extends LmsProjectSetup{

	@Test
	public void contactAdmin()
	{
		driver.findElement(By.linkText("Contact")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Lakshmi");
		driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("lakshmi@gmail.com");
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("automation checking");
		driver.findElement(By.xpath("//*[@id=\"wpforms-8-field_2\"]")).sendKeys("automation");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String text = driver.findElement(By.xpath("//*[@id=\"wpforms-confirmation-8\"]/p")).getText();
		System.out.println("Text after submission "+text);
		
	}
}
