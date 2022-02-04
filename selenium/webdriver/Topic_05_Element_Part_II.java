package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.GetTagName;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Element_Part_II {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	//@Test
	public void TC_01_Url() {
		driver.get("http://live.techpanda.org/index.php/customer/account/create/");
		
		String searchPlaceHolder = driver.findElement(By.id("search")).getAttribute("placeholder");
		System.out.println(searchPlaceHolder);
		
		String instructionText = driver.findElement(By.cssSelector("p.form-instructions")).getText();
		System.out.println(instructionText);	
	}

	//@Test
	public void TC_02_Title() {
		 driver.get("https://www.facebook.com/");
		 WebElement loginButton = driver.findElement(By.name("login"));
		 System.out.println(loginButton.getCssValue("font-size"));
		 System.out.println(loginButton.getCssValue("background-color"));
		 System.out.println(loginButton.getCssValue("width"));
		 System.out.println(loginButton.getCssValue("font-family"));
		
		
	}

	//@Test
	public void TC_03_Navigation() {
		 driver.get("https://www.facebook.com/");
		 
		 WebElement loginButton = driver.findElement(By.name("login"));
		 String loginButtonTagname = loginButton.getTagName();
		 loginButton = driver.findElement(By.xpath("//" + loginButtonTagname + "[@name='login']"));
	}
	
	@Test
	public void TC_04_Page_Source() {
		driver.get("http://live.techpanda.org/index.php/customer/account/login/");
		driver.findElement(By.id("email")).sendKeys("autocc@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("12345655");
		driver.findElement(By.id("send2")).submit();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}