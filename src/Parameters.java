import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Parameters {

	public WebDriver driver;

	String MyUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";

	SoftAssert mySoftAssert = new SoftAssert();

	@BeforeTest
	public void pre_test() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(MyUrl);
		driver.manage().window().maximize();

	}

}
