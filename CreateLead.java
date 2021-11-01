package testcase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends BaseClassTest {

	@DataProvider(name = "sendData")
	private String[][] ProvideData() throws IOException {
		Excel obj = new Excel();
		String[][] data = obj.run("CreateLead");

		return data;
	}

	@Test(dataProvider = "sendData")
	public void run(String company, String firstname, String lastname, String no) {
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(company);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastname);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(no);
		driver.findElement(By.name("submitButton")).click();
	}

	{

	}
}
