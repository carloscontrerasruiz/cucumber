package steps.globalhooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CommonSteps {
	
	WebDriver driver;
	
	
	//sE EJECUTA ANTES DE CUALQUIER ESCENARIO de cualquiera de los features
	@Before(order=1)
	public void setup() {
		System.out.println("Before global");
		System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
		//driver = new ChromeDriver();
		
		//Headless browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
	}
	
	//Se ejecuta despues de cada escenario de cualquier archivo feature
	@After(order=1)
	public void testDown(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] scr = ((TakesScreenshot)driver)
					.getScreenshotAs(OutputType.BYTES);
			scenario.attach(scr, "image/png", scenario.getName());
		}
		System.out.println("After global");
		driver.quit();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	
}
