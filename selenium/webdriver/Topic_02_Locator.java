package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Locator {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://live.techpanda.org/index.php/customer/account/create/");
	}

	@Test
	public void TC_01() {
		
		driver.findElement(By.id("firstname")).sendKeys("Automation");
		sleepInSecond(1);
		
		driver.findElement(By.name("lastname")).sendKeys("FC");
		sleepInSecond(1);
		
		driver.findElement(By.className("customer-name-middlename")).isDisplayed();
		driver.findElement(By.className("name-middlename")).isDisplayed();
		
		int inputNumber = driver.findElements(By.tagName("input")).size();
		System.out.println(inputNumber);

		driver.findElement(By.linkText("SEARCH TERMS")).click();
		sleepInSecond(1);

		driver.findElement(By.partialLinkText("ADVANCED")).click();
		sleepInSecond(1);
		
		driver.findElement(By.cssSelector("input[id='name']")).sendKeys("iPhone");
		sleepInSecond(1);
		
		driver.findElement(By.cssSelector("input[name='name']")).clear();
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Samsung Note 20");
		sleepInSecond(1);
		
		driver.findElement(By.cssSelector("#name")).clear();
		driver.findElement(By.cssSelector("#name")).sendKeys("Nokia 110i");
		sleepInSecond(1);
		
		driver.findElement(By.xpath("//input[@id='description']")).sendKeys("iPhone 15");
		sleepInSecond(1);

		driver.findElement(By.xpath("//input[@name='description']")).clear();
		driver.findElement(By.xpath("//input[@name='description']")).sendKeys("HQ");
		sleepInSecond(1);
		
		driver.findElement(By.xpath("//label[text()='Description']/following-sibling::div/input")).sendKeys("VN");
		sleepInSecond(1);
	}

	@Test
	public void TC_02() {
		
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}