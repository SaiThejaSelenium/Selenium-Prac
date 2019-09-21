package browser_Launch;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Facebook_Screenshot {
	static WebDriver driver;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		File f=new File("E:\\SeleniumClass\\Selenium_Prac\\Facebook_crid.properties");
		FileInputStream File_out=new FileInputStream(f);
		
		Properties prop=new Properties();
		
//		prop.store(File_out, "");		
		FileInputStream file_input=new FileInputStream(f);
		prop=new Properties();
		
		prop.load(file_input);
		
		String Username= prop.getProperty("Username");
		String Password=prop.getProperty("Password");
		
					

		System.setProperty("webdriver.chrome.driver", "Library\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		folder();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@data-testid='royal_login_button']")).click();
		Thread.sleep(2000);
		screenshot();
		

	}
	
	public static String datescreen() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String date = dtf.format(now);
		date = date.replace(" ", "_");
		date = date.replace("/", "_");
		date = date.replace(":", "_");
		return date;
		
	}
	
	public static void screenshot() {

		TakesScreenshot Screen_shot = (TakesScreenshot) driver;

		File screenshot = Screen_shot.getScreenshotAs(OutputType.FILE);

		String date = datescreen();
		File Dest = new File("Screenshots\\" + date + ".png");

		try {
			FileUtils.copyFile(screenshot, Dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void folder() {
		File f = new File("E:\\SeleniumClass\\Selenium_Prac\\Screenshots");

		System.out.println(f.exists());
		if (!f.exists()) {
			f.mkdir();
			System.out.println("Folder creted");
		} else {
			System.out.println("Folder existed");
		}
		System.out.println(f.getAbsoluteFile());
	}

}
