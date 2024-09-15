package upload;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class upload {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
		//download
		driver.findElement(By.id("downloadButton")).click();
		//edit excel
		//upload
		WebElement upload = driver.findElement(By.id("fileinput"));
		upload.sendKeys("/Users/priyankaraju/Downloads/download.xlsx");
		
		//wait for success message to show up and disappear
		
		
				

	}

}
