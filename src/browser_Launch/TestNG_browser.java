package browser_Launch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNG_browser {

	@BeforeSuite
	public void BeforeSuit() {
		System.out.println("This is before suit");
	}

	@AfterSuite
	public void AfterSuit() {
		System.out.println("This is after suit");
	}

	@BeforeClass
	public void BeforeClass() {
		System.out.println("This is before class");
	}

	@AfterClass
	public void AfterClass() {
		System.out.println("This is After Class");
	}

	@BeforeMethod
	public void BeforeMethod() {
		System.out.println("This is before method");
	}

	@AfterMethod
	public void AfterMethod() {
		System.out.println("This is AfterMethod");
	}

	@Test
	public void Test_bro1() {
		System.setProperty("webdriver.chrome.driver", "Library\\chromedriver.exe");
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(Options);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}

	@Test
	public void Test_bro2() {
		System.setProperty("webdriver.chrome.driver", "Library\\chromedriver.exe");
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(Options);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://netbanking.hdfcbank.com/");
	}

}
