import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyIndexPage {
	
	public static WebDriver driver;

	@BeforeMethod
	public void OpenBrowser() {
		System.setProperty("webdriver.chrome.driver", "C://seleniumdriver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://akshathapandu.github.io/MyAssignment/index.html");

	}
	
	@Test (priority=2)
	public void VerifySubmitButton() throws InterruptedException {
		
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@id=\"username \"]")).sendKeys("alex");
		driver.findElement(By.xpath("//*[@id=\"useremail \"]")).sendKeys("alex123@gmail.com");
		driver.findElement(By.xpath("/html/body/div[2]/form/input[4]")).sendKeys("regarding selenium training");
		driver.findElement(By.xpath("/html/body/div[2]/form/textarea")).sendKeys("I would like to enroll in this program");
		driver.findElement(By.xpath("/html/body/div[2]/form/input[5]")).click();
		String Actualtitle=driver.getTitle();
		Assert.assertEquals(Actualtitle,"Thank you");
		
	}
	@Test (priority=1)
	public void VerifyIndexPageTitle() throws InterruptedException {
		
	  Thread.sleep(4000);
	  String Actualtitle=driver.getTitle();
	  Assert.assertEquals(Actualtitle,"Contact us");
	  
	}

	
	@AfterMethod()
	public void CloseBrowser()
	{
		driver.close();
	}
	
	
}


