package browser_Launch;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FileUpload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "Library\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/upload/");
		
		driver.findElement(By.xpath("//input[@id='uploadfile_0']")).click();
		
		try {
			Thread.sleep(2000);
			String[] file=new String[2];
			file[0]="C:\\Users\\praveena\\Desktop\\fileupload.exe";
			file[1]="C:\\Users\\praveena\\Desktop\\lavanya2018.docx";
			
			Runtime.getRuntime().exec(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}

	}

}
