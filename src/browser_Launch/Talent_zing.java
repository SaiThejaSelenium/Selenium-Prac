package browser_Launch;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Talent_zing {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "Library\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Chrome Window Launched");

		driver.get("https://www.talentzing.com/");

		Actions sc = new Actions(driver);
		Thread.sleep(2000);
		WebElement Move_to = driver
				.findElement(By.xpath("//div[@class='navbar']/div/div[2]/ul/li[6]//span[@id='lnkRegistration']"));
		sc.moveToElement(Move_to).build().perform();

		driver.findElement(By.xpath("//div[@class='navbar']/div/div[2]/ul/li[6]/div/ul[2]/li[3]/a")).click();

		String mainwindow = driver.getWindowHandle();
		System.out.println(mainwindow);

		Set<String> Windows = driver.getWindowHandles();
		int size = Windows.size();
		System.out.println("Number of Windows:" + size);
//		Switching from main window to child window
		for (String childwindow : Windows) {
			System.out.println("Child window name:" + childwindow);
			if (!mainwindow.equals(childwindow)) {
				driver.switchTo().window(childwindow);
			}
		}

		driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder2_txtfirstname']")).sendKeys("Sai");
		driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder2_txtlastname']")).sendKeys("Theja");
		driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder2_txtemail']"))
				.sendKeys("saitheja.apps@gmail.com");
		driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder2_txtmobile']")).sendKeys("9444653229");
		WebElement pass = driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder2_txtpwd']"));
		pass.sendKeys("$@!theja1");
		String get_val = driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder2_txtpwd']"))
				.getAttribute("value");
		System.out.println(get_val);
		WebElement confpass = driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder2_txtconfirmpwd']"));
		confpass.sendKeys(get_val);
		List<WebElement> city = driver
				.findElements(By.xpath("//select[@id='ctl00_ContentPlaceHolder2_ddlFresherLocation']/option"));

		int city_count = city.size();
		System.out.println("Number of cities: " + city_count);
		int i;
		for (i = 0; i < city_count; i++) {
			WebElement te = city.get(i);

			String text = te.getText();
			if (text.contains("Chennai")) {
				System.out.println("The city name is:" + text);
				te.click();
				break;
			}
		}

		driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder2_rdoGender_0']")).click();
		driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder2_txtdateOfBirth']")).click();

		Select f_mon = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		f_mon.selectByIndex(6);
		Select year = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		year.selectByVisibleText("1990");
		driver.findElement(By.xpath("//a[text()='13']")).click();

		List<WebElement> education = driver
				.findElements(By.xpath("//select[@id='ctl00_ContentPlaceHolder2_ddlEducation']/option"));

		int edu_count = education.size();
		System.out.println("Number of cities: " + edu_count);

		for (i = 0; i < edu_count; i++) {
			WebElement edu = education.get(i);

			String text1 = edu.getText();
			if (text1.contains("MCA")) {
				System.out.println("Education is: " + text1);
				edu.click();
				break;
			}
		}

		driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder2_txtCollegeName']"))
				.sendKeys("Narayana Engineering & PG College");
		;

		driver.findElement(By.xpath("//select[@id='ctl00_ContentPlaceHolder2_ddlyop']/option[text()='2015']")).click();

		driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder2_txtkeywords']")).sendKeys("selenium");

		List<WebElement> auto_sug = driver.findElements(
				By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content']/li"));

		int auto_count = auto_sug.size();
		System.out.println("This is the count of auto_sugg: " + auto_count);

		Thread.sleep(2000);
		for (int k = 0; k < auto_count; k++) {
			WebElement ts = auto_sug.get(k);

			String auto_text = ts.getText();
			if (auto_text.contains("SELENIUM TESTING")) {
				System.out.println("control is at auto sugg if");
				ts.click();

			}
		}

		driver.findElement(By.xpath("//input[@id='chkEmailjobs']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder2_EmailOptionsjobs_0']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder2_WeeklySlotsjobs_1']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='chkTrainingEmail']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder2_TrainingEmailOptions_0']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder2_TrainingWeeklySlots_1']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='chkAccept']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder2_btnSubmit']")).click();

		driver.close();
	}

}
