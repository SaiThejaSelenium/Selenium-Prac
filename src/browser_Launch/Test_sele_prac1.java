package browser_Launch;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.GetElementSelected;
import org.openqa.selenium.support.ui.Select;

public class Test_sele_prac1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "Library\\chromedriver.exe");
		WebDriver Launch = new ChromeDriver();
		Launch.manage().window().maximize();
		Launch.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Web brouser launched");

		Launch.get("https://www.facebook.com/");
		WebElement first_name = Launch.findElement(By.xpath("(//input[starts-with(@name,'first')])"));
		first_name.sendKeys("Sai");
		System.out.println("sending element First name");

		WebElement sur_name = Launch.findElement(By.xpath("//input[contains(@name,'last')]"));
		sur_name.sendKeys("Mucheli");
		System.out.println("sending element Last name");

		Launch.findElement(By.xpath("//input[@id='u_0_q' and @type='text']")).sendKeys("saitheja.apps@gmail.com");
		
		String entervalue=Launch.findElement(By.xpath("//input[@id='u_0_q' and @type='text']")).getAttribute("value");
		System.out.println("Enter text is : "+entervalue);

		System.out.println("");
		//// input[normalize-space(@data-type)='text' and
		//// (@name)='reg_email_confirmation__']
		WebElement con_mail = Launch.findElement(
				By.xpath("//input[normalize-space(@data-type)='text' and (@name)='reg_email_confirmation__']"));
		con_mail.sendKeys(entervalue);
		System.out.println("Reenter_mail :" + con_mail);

		Select sc = new Select(Launch.findElement(By.xpath("//select[@id='day']")));
		
		sc.selectByIndex(7);
		
		Thread.sleep(3000);
		sc.selectByValue("20");
		Thread.sleep(3000);
		sc.selectByVisibleText("25");
		Thread.sleep(3000);
				
		WebElement drop=sc.getFirstSelectedOption();
		String text=drop.getText();
		System.out.println(text);
		
		List<WebElement> li=sc.getAllSelectedOptions();
		
		
		
		
		
	}

}
