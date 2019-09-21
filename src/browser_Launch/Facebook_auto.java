package browser_Launch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Facebook_auto {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable-notifications");

		File f=new File("E:\\SeleniumClass\\Selenium_Prac\\Facebook_crid.properties");
		FileInputStream File_out=new FileInputStream(f);
		
		Properties prop=new Properties();
		
//		prop.store(File_out, "");		
		FileInputStream file_input=new FileInputStream(f);
		prop=new Properties();
		
		prop.load(file_input);
		
		String Username= prop.getProperty("Username");
		String Password=prop.getProperty("Password");
		
					
//		FileInputStream file_input=new FileInputStream(f);
//		prop=new Properties();
		
		System.setProperty("webdriver.chrome.driver", "Library\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@data-testid='royal_login_button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='bluebarRoot']/div/div/div/div[2]/div/div/div[@class='_1k67 _cy7']"))
				.click();

		WebElement total_frnds = driver.findElement(By.xpath("//div[@class='_70k']/ul/li[3]/a/span"));

		int total_fnds = 692;
		System.out.println("Total friends Count: " + total_fnds);

		driver.findElement(By.xpath("//div[@id='fbTimelineHeadline']/div[2]/ul/li[3]/a")).click();
		List<WebElement> list = driver
				.findElements(By.xpath("//div[@role='tabpanel']/ul/li/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/a"));
		Boolean status = true;
		while (status) {

			int fnd_size = list.size();
			// i = fnd_size;

//			if(i!=total_fnds) {
//				//j=i+j;
//
//				System.out.println("in if Total friends Count: " + total_fnds);
//				System.out.println("this count of i: " +i);
//				//System.out.println("this count of i: " +j);
//				JavascriptExecutor jse = (JavascriptExecutor) driver;
//				jse.executeScript("window.scrollBy(0,250)");
//			}
//			else {
//				System.out.println("In Else Total friends Count: " + total_fnds);
//				break;
//			}
			
			if (fnd_size == total_fnds) {
				System.out.println(fnd_size);
				break;
			}

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,500)");
			Thread.sleep(5000);
			list = driver.findElements(
					By.xpath("//div[@role='tabpanel']/ul/li/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/a"));

		}
		
		for(int i=0;i<list.size();i++) {
			
			String friendName=list.get(i).getText();
			System.out.println("No : "+i+" - My friend name is : "+friendName);
		}

	}

}
