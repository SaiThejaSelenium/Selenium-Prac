package browser_Launch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Test_sele_prac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "Library\\chromedriver.exe");
		WebDriver Launch= new ChromeDriver();
		Launch.manage().window().maximize();
		Launch.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Launching browser");
		
		Launch.get("http://testingmasters.com/hrm/symfony/web/index.php/auth/login");
		WebElement element= Launch.findElement(By.id("txtUsername"));
		element.sendKeys("user02");
		WebElement ele_pass= Launch.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/form[1]/div[3]/input"));
		ele_pass.sendKeys("TM1234");
		
		WebElement ele_click= Launch.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/form/div[5]/input"));
		ele_click.click();
		
//		WebElement User_drop= Launch.findElement(By.xpath("/html/body/div[1]/div[1]/a[2]"));
//		User_drop.click();
//		
//		WebElement logout=Launch.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]"));
//		logout.click();
		
		
		Actions sc=new Actions(Launch);
		WebElement moveele=Launch.findElement(By.xpath("//*[text()='Leave']"));
		sc.moveToElement(moveele).build().perform();
		
		Launch.findElement(By.xpath("//*[text()='Apply']")).click();
		
		Select Leave_type= new Select(Launch.findElement(By.xpath("//select[@id='applyleave_txtLeaveType']")));
		Leave_type.selectByIndex(2);
		
		WebElement from_date= Launch.findElement(By.xpath("//input[@id='applyleave_txtFromDate']"));
		from_date.click();
		
		Select f_mon= new Select(Launch.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		f_mon.selectByIndex(8);
		Select f_year= new Select(Launch.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		f_year.selectByValue("2019");
		//Select fdate=new Select(Launch.findElement(By.xpath("//*[text()='28']")));
		
		Launch.findElement(By.xpath("//a[text()='28']")).click();;
		
				

	}

}
