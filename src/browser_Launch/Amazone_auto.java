package browser_Launch;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;

import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

public class Amazone_auto {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "Library\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("launching web browser");

		driver.get("https://www.amazon.in/");

		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("laptops");
		driver.findElement(By.xpath("//input[@class='nav-input']")).click();

		List<WebElement> check = driver.findElements(
				By.xpath("//ul[@aria-labelledby='p_n_feature_browse-bin-title']/li[@class='a-spacing-micro']/span"));
		List<WebElement> check_boxlist=driver.findElements(By.xpath("//div[@id='filters']/ul[2]/li[@class='a-spacing-micro']/span/a/div/label/input"));

		int check_size = check.size();
		System.out.println("number of brands:" + check_size);

		for (int i = 0; i < check_size; i++) {
			Thread.sleep(2000);
			// List<WebElement>
			// checkbox=driver.findElements(By.xpath("//ul[@aria-labelledby='p_n_feature_browse-bin-title']/li[@class='a-spacing-micro']/input"));
			WebElement ta = check.get(i);
			String text = ta.getText();
			System.out.println("control is in if for checking: " + text);
			// WebElement
			// checkbox=driver.findElement(By.xpath("//div[@id='filters']/ul[2]/li/span/a/div/label/input"));
//			if(i<check_size) {
			if (i % 2 == 0) {
				System.out.println("control is in if for checking");
				Thread.sleep(2000);
				System.out.println(ta.isEnabled());
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", ta);

			}
			check = driver.findElements(By
					.xpath("//ul[@aria-labelledby='p_n_feature_browse-bin-title']/li[@class='a-spacing-micro']/span"));
			check_boxlist=driver.findElements(By.xpath("//div[@id='filters']/ul[2]/li[@class='a-spacing-micro']/span/a/div/label/input"));

		}

	}

}
