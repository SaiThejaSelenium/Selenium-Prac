package browser_Launch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ExcelHandling_Facebook {

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
		driver.findElement(By.xpath("//div[@id='bluebarRoot']/div/div/div/div[2]/div/div/div[@class='_1k67 _cy7']"))
				.click();

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

		for (int i = 0; i < list.size(); i++) {

			String friendName = list.get(i).getText();
			File f = new File("E:\\SeleniumClass\\Selenium_Prac\\Facebook_Friends.xlsx");
			FileInputStream fis = new FileInputStream(f);
			XSSFWorkbook book = new XSSFWorkbook(fis);

			XSSFSheet sheet = book.getSheet("Friends");

			sheet.createRow(i).createCell(0).setCellValue(friendName);
//			sheet.getRow(5).createCell(0).setCellValue("Chennai");

//			sheet.createRow(0).createCell(2).setCellValue("Hello");

			FileOutputStream fo = new FileOutputStream(f);
			book.write(fo);
			fo.flush();
			fo.close();
//			System.out.println("No : " + i + " - My friend name is : " + friendName);
		}

		for (int i = 0; i < list.size(); i++) {

			String friendName = list.get(i).getText();
			System.out.println("No : " + i + " - My friend name is : " + friendName);
		}

	}

}
