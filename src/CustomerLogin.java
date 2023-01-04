import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.dockerjava.api.model.Driver;

public class CustomerLogin extends Parameters {

	@Test
	public void customer_login_harry_potter() throws InterruptedException {

		String value_one = "1000";
		String value_two = "1000";
		String value_three = "1000";

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button")).click();
		WebElement myOptions = driver.findElement(By.xpath("//*[@id=\"userSelect\"]"));
		Select mySelect = new Select(myOptions);
		mySelect.selectByVisibleText("Harry Potter");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/button")).click();

		WebElement myValues = driver.findElement(By.xpath("//*[@id=\"accountSelect\"]"));
		Select sel = new Select(myValues);

		for (int i = 0; i < 2;) {

			sel.selectByIndex(i);
			driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")).sendKeys(value_one);
			Thread.sleep(1000);

			int myActualValue1 = Integer.parseInt(value_one);
			driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button")).click();
			String balance1 = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/strong[2]")).getText();
			int actualBalance1 = Integer.parseInt(balance1);

			i++;
			Thread.sleep(1000);
			sel.selectByIndex(i);
			driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")).sendKeys(value_two);

			int myActualValue2 = Integer.parseInt(value_two);
			driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button")).click();
			String balance2 = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/strong[2]")).getText();
			int actualBalance2 = Integer.parseInt(balance2);
			Thread.sleep(1000);

			i++;
			Thread.sleep(1000);
			sel.selectByIndex(i);
			driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]")).click();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input"))
					.sendKeys(value_three);

			int myActualValue3 = Integer.parseInt(value_three);
			driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button")).click();
			String balance3 = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/strong[2]")).getText();
			int actualBalance3 = Integer.parseInt(balance3);
			Thread.sleep(1000);
			int expectedAddition = myActualValue1 + myActualValue2 + myActualValue3;
			System.out.println("******************");
			System.out.println("expectedAddition = "+expectedAddition);
			System.out.println("******************");
			int actualAddition = actualBalance1 + actualBalance2 + actualBalance3;
			System.out.println("********************");
			System.out.println("actualAddition = "+actualAddition);
			System.out.println("********************");

			mySoftAssert.assertEquals(actualAddition, expectedAddition);

			mySoftAssert.assertAll();

		}
	}

}
