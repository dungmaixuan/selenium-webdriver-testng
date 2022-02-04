package webdriver;

import java.awt.Dimension;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Element_Part_I {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}

	@Test
	public void TC_01_Browser() {
		WebElement element = driver.findElement(By.xpath(""));
		element.clear();
		element.sendKeys("");
		element.click();
		
		driver.getCurrentUrl();
		driver.getPageSource();
		driver.getTitle();
		driver.getWindowHandle();
		driver.getWindowHandles();
		
		driver.manage().window().getPosition();
		driver.manage().window().getSize();
		
		//lay ra gia tri cua attribute
		element.getAttribute("placeholder");
		//lay ra text cua element
		element.getText();
		//thuong dung de test GUI: font/color/size/location/position..
		element.getCssValue("");
		//
		element.getLocation();
		//
		element.getRect();
		//
		org.openqa.selenium.Dimension elementSize = element.getSize();
		//
		String base64Image = element.getScreenshotAs(OutputType.BASE64);
		//chup hinh cua element lai luu bang format nao do
		element.getScreenshotAs(OutputType.BYTES);
		element.getScreenshotAs(OutputType.FILE);
		//lay ra ten the (html) cua element
		element = driver.findElement(By.xpath("//input[@id='email']"));
		element = driver.findElement(By.cssSelector("input[id='email']"));
		String elementTagname = element.getTagName();
		
		//ktra 1 element co hien thi hay ko - tat ca cac loai element
		//user co the thay
		//mong doi no hien thi
		Assert.assertTrue(element.isDisplayed());
		//mong doi no ko hien thi
		Assert.assertFalse(element.isDisplayed());
		
		//ktra 1 element co the thao tac dc ko
		//read-only hoac disable element
		
		//mong doi no thao tac dc (enable)
		Assert.assertTrue(element.isEnabled());
		
		//mong doi no bi disable/read-only/ ko thao tac dc
		Assert.assertFalse(element.isEnabled());
		
				
		//Ktra 1 element da dc chon hay chua
		//radio button/Checkbox/Dropdown
		element.isSelected();
		
		//mong doi no dc chon roi 
		Assert.assertTrue(element.isSelected());
				
		//mong doi no chua chon/bo chon
		Assert.assertFalse(element.isSelected());

		//tuong ung voi hanh dong la nhan ENTER 
		// chi dung vs element la form hoac nam trong form
		element.submit();
	}

	@Test
	public void TC_02_Element() {
		
		
		
		
		
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}