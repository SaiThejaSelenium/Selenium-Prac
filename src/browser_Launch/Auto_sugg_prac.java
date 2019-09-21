package browser_Launch;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Auto_sugg_prac {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "Library\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Web brouser launched");

		driver.get("https://www.flipkart.com/");

		WebElement close_login = driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']"));
		close_login.click();

		driver.findElement(By.xpath("//input[@type='text' and @title='Search for products, brands and more']"))
				.sendKeys("apple");
		Thread.sleep(2000);
		List<WebElement> elem = driver.findElements(By.xpath("//form[@method='GET']/ul/li/div/a"));

		Thread.sleep(2000);
		int autosug = elem.size();
		System.out.println("List of size:" + autosug);

		elem.get(1).click();

		List<WebElement> list = driver
				.findElements(By.xpath("//div[@class='_1HmYoV hCUpcT']/div[2]/div/div/div/div/a/div[2]/div[1]/div[1]"));
		List<WebElement> Price=driver.findElements(By.xpath("//div[@class='bhgxx2 col-12-12']/div/div/div/a/div[2]/div[2]/div/div/div[1]"));

		int listsize = list.size();
		System.out.println("Total names list size is : " + listsize);
		for (int i = 0; i < listsize; i++) {

			String name = list.get(i).getText();
			String price=Price.get(i).getText();
			System.out.println("Mobile names : " + name +"Price : "+price);
			
			
		}
		driver.close();

	}

}
