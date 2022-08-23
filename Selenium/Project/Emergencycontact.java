package alchemy.project.hrms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Emergencycontact extends HrmProjectSetup{
	
	@Test
	public void retrieveEmergencyContact()
	{
		
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		driver.findElement(By.linkText("Emergency Contacts")).click();
		List<WebElement> tablerows = driver.findElements(By.xpath("//*[@id=\"emgcontact_list\"]/tbody/tr"));
		for (WebElement webElement : tablerows) {
			List<WebElement> cells = webElement.findElements(By.tagName("td"));
			for (WebElement webElement2 : cells) {
				System.out.print(webElement2.getText() + " ");				
			}
			System.out.println(" ");
			
		}
	}

}
