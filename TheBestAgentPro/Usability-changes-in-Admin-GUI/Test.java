package pageAgency;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		// Open a browser
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		
		// open website
		driver.get("http://consortiums.b2b-staging.thebestagent.pro");
		Thread.sleep(3000);
		
		// log in with not existing user credentials
		driver.findElement(By.id("login-email")).sendKeys("test.measana+AgencyAd18@gmail.com");
		driver.findElement(By.id("login-password")).sendKeys("123321");
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/form/button")).click();
		Thread.sleep(2000);
		
		// checking if log in is successful
		String errorMessage = driver.findElement(By.xpath("/html/body/div[2]/div[1]/form/div[1]/div")).getText();
		if (errorMessage.equalsIgnoreCase("This email is not registered")) 
		{
		   System.out.println("This email is not registered");
		   // Open Register Agency page
		   driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/a[2]")).click();
		   Thread.sleep(2000);
		   
		   // create new user
		   driver.findElement(By.id("agency-email")).sendKeys("test.measana+AgencyAd20@gmail.com");
		   driver.findElement(By.id("agency-password")).sendKeys("123321");
		   driver.findElement(By.id("agency-name")).sendKeys("AgencyAd16");
		   driver.findElement(By.id("agency-fname")).sendKeys("AgencyAd16");
		   driver.findElement(By.id("agency-lname")).sendKeys("AgencyAd16");
		   driver.findElement(By.id("agency-phone")).sendKeys("1253259852");
		   driver.findElement(By.id("agency-hear")).sendKeys("test");
		   driver.findElement(By.xpath("/html/body/div[7]/form/button")).click();
		   Thread.sleep(2000);
		   
		   // log in as new agency
		   driver.findElement(By.xpath("/html/body/div[7]/div[2]/a[1]")).click();
		   driver.findElement(By.id("login-email")).sendKeys("test.measana+AgencyAd17@gmail.com");
		   driver.findElement(By.id("login-password")).sendKeys("123321");
		   driver.findElement(By.xpath("/html/body/div[2]/div[1]/form/button")).click();
			Thread.sleep(2000);
		   
		// Looking for H1 "Rules" when clicked link page is opened
			try {
				WebDriverWait h1title = new WebDriverWait(driver,3);
				h1title.until(ExpectedConditions.textToBePresentInElementLocated(By.className("Index__title"), "Rules"));
				System.out.println("H1 title 'Rules' found. As expected. PASS");
				}
			   
			   catch(Exception fieldname) {
				   System.out.println("H1 title not found. FAIL");
			    }
		}
		else {
			System.out.println("Successfull sign in");
			}
		
		 // Following code captures the screenshot and place it in specified location
	    TakesScreenshot ts = (TakesScreenshot)driver;
		File scrFile = ts.getScreenshotAs(OutputType.FILE);
		
		String desiredName = "D:/AlexP/Trash/00.png";
		File dstFile = new File(desiredName);
	    int i = 0;
		while (dstFile.exists ()) {
		      i += 1;
		      desiredName = "D:/AlexP/Trash/00"+ i +".png";
		      dstFile = new File(desiredName);
		    
		   	}
		System.out.println("Screenshot 00* is taken, please check");
		Files.copy(scrFile, dstFile);  	
		
		
		

	}

}
