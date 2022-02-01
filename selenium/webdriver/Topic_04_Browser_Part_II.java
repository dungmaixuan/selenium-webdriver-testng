package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Browser_Part_II {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@Test
	public void TC_01_Url() {
		driver.get("http://live.techpanda.org/index.php/");
		
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		
		String loginPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(loginPageUrl, "http://live.techpanda.org/index.php/customer/account/login/");
		
		
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		
		String registerPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(registerPageUrl, "http://live.techpanda.org/index.php/customer/account/create/");
	}

	@Test
	public void TC_02_Title() {
		driver.get("http://live.techpanda.org/index.php/");
		
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		
		String LoginPageTitle = driver.getTitle();
		Assert.assertEquals(LoginPageTitle, "Customer Login");
		
		
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		
		String RegisterPageTitle = driver.getTitle();
		Assert.assertEquals(RegisterPageTitle, "Create New Customer Account");
	}

	@Test
	public void TC_03_Navigation() {
		driver.get("http://live.techpanda.org/index.php/");
		
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		
		
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		
		String registerPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(registerPageUrl, "http://live.techpanda.org/index.php/customer/account/create/");
		
		driver.navigate().back();
		
		String loginPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(loginPageUrl, "http://live.techpanda.org/index.php/customer/account/login/");
		
		driver.navigate().forward();
		
		String RegisterPageTitle = driver.getTitle();
		Assert.assertEquals(RegisterPageTitle, "Create New Customer Account");
		
	}
	
	@Test
	public void TC_04_Page_Source() {
		driver.get("http://live.techpanda.org/index.php/");
		
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		
		String LoginPageSource = driver.getPageSource();
		Assert.assertTrue(LoginPageSource.contains("Login or Create an Account"));
		
		
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		
		String RegisterPageSource = driver.getPageSource();
		Assert.assertTrue(RegisterPageSource.contains("Create an Account"));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}