package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.GetTagName;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Topic_05_Element_Part_III_Login {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String firstName, lastName, fullName, emailAddress, password, nonExistEmailAddress;
	
	By username = By.xpath("//input[@name='login[username]']");
	By pass = By.xpath("//input[@name='login[password]']");
	By MyAccountButton = By.xpath("//div[@class='footer']//a[@title='My Account']");
	By loginButton = By.xpath("//button[@id='send2']");
	By username_e = By.xpath("//div[@id='advice-required-entry-email']");
	By pass_e = By.xpath("//div[@id='advice-required-entry-pass']");
	By username_e1 = By.xpath("//div[@id='advice-validate-email-email']");
	By pass_e1 = By.xpath("//div[@id='advice-validate-password-pass']");
	
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		firstName = "Steve"; 
		lastName = "Job"; 
		fullName = firstName + " " + lastName;
		emailAddress = "stevejob" + getRandomNumber() + "@hotmail.net"; 
		nonExistEmailAddress = "stevejob" + getRandomNumber() + "@live.com"; 
		password = "123456789";
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	
	@BeforeMethod
	public void BeforeMethod() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(MyAccountButton).click();
	}
	
	@Test
	public void TC_01_Login_Empty_Data() {
		driver.findElement(username).clear();
		driver.findElement(pass).clear();
		driver.findElement(loginButton).click();
		
		Assert.assertEquals(driver.findElement(username_e).getText(), "This is a required field.");
		Assert.assertEquals(driver.findElement(pass_e).getText(), "This is a required field.");
		}

	@Test
	public void TC_02_Login_Invalid_Email() {
		driver.findElement(username).sendKeys("123@123.123");
		driver.findElement(pass).sendKeys("123456");
		driver.findElement(loginButton).click();
		
		Assert.assertEquals(driver.findElement(username_e1).getText(), "Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test
	public void TC_03_Login_Invalid_Password() {
		driver.findElement(username).sendKeys("automation@gmail.com");
		driver.findElement(pass).sendKeys("123");
		driver.findElement(loginButton).click();
		
		Assert.assertEquals(driver.findElement(pass_e1).getText(), "Please enter 6 or more characters without leading or trailing spaces.");
		
	}


	@Test
	public void TC_04_Create_New_Acc () {
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(emailAddress);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "Thank you for registering with Main Website Store.");
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div.page-title>h1")).getText(), "MY DASHBOARD");
		Assert.assertEquals(driver.findElement(By.cssSelector("div.welcome-msg strong")).getText(), "Hello, " + fullName + "!");

		String contractInformation = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
		Assert.assertTrue(contractInformation.contains(fullName));
		Assert.assertTrue(contractInformation.contains(emailAddress));
		
		
		
		driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
		driver.findElement(By.xpath("//a[@title='Log Out']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("div.page-title img[src$='logo.png']")).isDisplayed());
}
	@Test
	public void TC_05_Login_Incorrect_Email_Password () {
		driver.findElement(username).sendKeys(emailAddress);
		driver.findElement(pass).sendKeys("123456");
		driver.findElement(loginButton).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("li.error-msg span")).getText(),"Invalid login or password.");
		
		driver.findElement(username).clear();;
		driver.findElement(pass).clear();;
		driver.findElement(username).sendKeys(nonExistEmailAddress);
		driver.findElement(pass).sendKeys(password);
		driver.findElement(loginButton).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("li.error-msg span")).getText(),"Invalid login or password.");
		
	}
	
	
	@Test
	public void TC_06_Login_Valid_Email_Pass () {
		driver.findElement(username).sendKeys(emailAddress);
		driver.findElement(pass).sendKeys(password);
		driver.findElement(loginButton).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div.page-title>h1")).getText(), "MY DASHBOARD");
		Assert.assertEquals(driver.findElement(By.cssSelector("div.welcome-msg strong")).getText(), "Hello, " + fullName + "!");

		String contractInformation = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
		Assert.assertTrue(contractInformation.contains(fullName));
		Assert.assertTrue(contractInformation.contains(emailAddress));
		
	}
	
	
	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}