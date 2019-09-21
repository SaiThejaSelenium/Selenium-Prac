package browser_Launch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserLaunch {
	
	static WebDriver driver;
	
	public static void LaunchBrowser(String browserName) {
		browserName = browserName.toLowerCase();
		
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "Library\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Launching Chrome Browser");
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", "Library\\IEdriverServer.exe");
			driver= new InternetExplorerDriver();
			driver.manage().window().maximize();
			System.out.println("Launching IE browser");
			
			break;
		}
	}
	
	public static void launchApp(String URL) {
		
		driver.get(URL);
		System.out.println("Launching Application");
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String URL="http://testingmasters.com/hrm";
		LaunchBrowser("Chrome");
		launchApp(URL);

	}

}
