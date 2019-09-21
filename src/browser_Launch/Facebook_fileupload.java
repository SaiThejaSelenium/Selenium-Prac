package browser_Launch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Facebook_fileupload {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "Library\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("thejasai.prince@gmail.com");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("$@!thejagupthamucheli");
		driver.findElement(By.xpath("//input[@data-testid='royal_login_button']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@id='bluebarRoot']/div/div/div/div[2]/div/div/div[@class='_1k67 _cy7']")).click();
		driver.findElement(By.xpath("//div[@id='fbTimelineHeadline']/div[2]/ul/li[4]/a[@data-tab-key='photos']")).click();
		driver.findElement(By.xpath("//div[@id='timeline-medley']/div/div/div/div/div/span/div/a")).click();
		
		Thread.sleep(3000);
		String[] facebook_photo= new String[2];
		facebook_photo[0]= "C:\\Users\\praveena\\Desktop\\Facebook_fileupload.exe";
		facebook_photo[1]="C:\\Users\\praveena\\Desktop\\WhatsApp Image 2019-07-13 at 3.00.05 PM.jpeg";	
		
		Runtime.getRuntime().exec(facebook_photo);
		
		System.out.println("Click Post");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-testid='react-composer-footer']/div/div[2]/div/span/button")).click();

	}

}
