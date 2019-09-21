package browser_Launch;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelExe {

	@Test
	@Parameters("UserName")
	public void Test_bro1(String UserName) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "Library\\chromedriver.exe");
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(Options);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(UserName);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("$@!thejagupthamucheli");
		driver.findElement(By.xpath("//input[@data-testid='royal_login_button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='userNavigationLabel']")).click();
		driver.findElement(By.xpath("//div[@class='uiContextualLayer _5v-0 _53il uiContextualLayerBelowRight']/div/div/div/div/div/div/ul/li[9]/a[@class='_54nc']")).click();
		driver.close();
	}
	
	@Test
	public void Test_bro2() throws Throwable {

		System.setProperty("webdriver.chrome.driver", "Library\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Web browser launched");

		driver.get("https://netbanking.hdfcbank.com/");
		Thread.sleep(2000);

		WebElement frame = driver.findElement(By.xpath("//frame[@name='login_page']"));

		driver.switchTo().frame(frame);

		WebElement user = driver
				.findElement(By.xpath("//table[@class='label']/tbody/tr[3]/td[2]/table/tbody/tr[2]/td[2]//input"));

		user.sendKeys("2654651");

		driver.findElement(By.xpath("//img[@alt='continue']")).click();

		driver.findElement(By.xpath("//a[text()='Forgot IPIN (Password)?']")).click();
		
		String mainWindow = driver.getWindowHandle();
		System.out.println(mainWindow);

		Set<String> windows = driver.getWindowHandles();
		int size = windows.size();
		System.out.println("Number of windows : " + size);
		int c = 0;

		for (String childwindow : windows) {
			System.out.println(childwindow);
			c++;
			if (c == 2) {
				driver.switchTo().window(childwindow);
			}

		}

		driver.findElement(By.xpath("//p[@class='note']/a")).click();
		windows = driver.getWindowHandles();
		c = 0;
		for (String childwindow : windows) {
			System.out.println("The new child :" + childwindow);
			c++;
			if (c == 3) {
				driver.switchTo().window(childwindow);
				Thread.sleep(2000);
				System.out.println(driver.getTitle());
				driver.close(); // closing the third window
			}
		}
//		closing the second window
		c = 0;

		for (String childwindow : windows) {
			c++;

			if (c == 2) {
				driver.switchTo().window(childwindow);
				Thread.sleep(2000);
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		Thread.sleep(2000);
		driver.quit();

	}


}
