package frameworkdesign.jobapplication;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class applyjob {
	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get(
				"https://careers.veeva.com/job/aca8cd98-e800-45b9-94bc-cb2c3077b49d/associate-quality-engineer-boston-ma/?lever-source=Linkedin");

		driver.findElement(By.linkText("Apply Now")).click();

		Set<String> allWindowsId = driver.getWindowHandles();
		System.out.println(allWindowsId);
		Iterator<String> windows = allWindowsId.iterator();
		//String parentId = windows.next();
		String childId = windows.next();

		driver.switchTo().window(childId);
		driver.manage().deleteAllCookies();
		System.out.println(driver.manage().getCookies());
		// driver.manage().deleteCookieNamed("hCaptcha");

		driver.findElement(By.xpath("//button[text()='Dismiss']")).click();

		driver.findElement(By.id("resume-upload-input"))
				.sendKeys("/Users/priyankaraju/Downloads/priyanka _resume_tester.pdf");

		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Priyanka Raju");

		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("priyankaraju92@gmail.com");

		driver.findElement(By.cssSelector("input[name='location']")).sendKeys("Jersey City, New Jersey");
		driver.findElement(By.cssSelector("input[name='urls[LinkedIn]']"))
				.sendKeys("https://www.linkedin.com/in/priyankaraju92/");

		Select static1 = new Select(driver.findElement(By.name("cards[f164d557-93a6-4a31-bb8f-3f226956f117][field0]")));
		static1.selectByVisibleText("LinkedIn");

		driver.findElement(By.xpath("(//input[@value='No'])[1]")).click();
		driver.findElement(By.xpath("(//input[@value='No'])[2]")).click();
		driver.findElement(By.name("cards[f164d557-93a6-4a31-bb8f-3f226956f117][field4]")).sendKeys("N/A");

		Select static2 = new Select(driver.findElement(By.name("cards[f164d557-93a6-4a31-bb8f-3f226956f117][field5]")));
		static2.selectByVisibleText("QA & Release Engineering");

		driver.findElement(By.xpath("(//input[@value='Yes'])[3]")).click();
		driver.findElement(By.xpath("(//input[@value='No'])[4]")).click();

		driver.findElement(By.xpath("//input[@value='USA']")).click();
		driver.findElement(By.cssSelector("input[value='EST']")).click();
		driver.findElement(By.xpath("//input[@value='0-2']")).click();

		driver.findElement(By.name("cards[b5d809bf-654e-4ab2-a95e-f283dd0d8d0e][field6]")).sendKeys("80000");

		Select gender = new Select(driver.findElement(By.name("eeo[gender]")));
		gender.selectByIndex(2);

		Select race = new Select(driver.findElement(By.name("eeo[race]")));
		race.selectByValue("Asian (Not Hispanic or Latino)");

		Select veteran = new Select(driver.findElement(By.name("eeo[veteran]")));
		veteran.selectByVisibleText("I am not a veteran");

		// driver.findElement(By.name("consent[marketing]")).click();
		driver.findElement(By.id("btn-submit")).click();

	}

}
