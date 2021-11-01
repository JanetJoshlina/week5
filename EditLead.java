package testcase;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EditLead extends BaseClassTest {

	@DataProvider(name = "sendData")
	public String[][] send() throws Throwable {
		Excel obj = new Excel();
		String[][] run = obj.run("EditLead");
		return run;
	}

	@Test(dataProvider = "sendData")
	public void editRun(String company, String phonenum) throws InterruptedException {
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phonenum);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(company);
		driver.findElement(By.name("submitButton")).click();
	}
}
