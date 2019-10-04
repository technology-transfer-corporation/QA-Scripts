			// Task_Name: "37 Usability changes in Admin GUI"
			// Task_URL: https://typeable.atlassian.net/browse/B2B-397?atlOrigin=eyJpIjoiZjNjNGYzNTdlNjY1NDU3YzgzZWMxMmU5MGE5OTI2MWMiLCJwIjoiaiJ9
			// Task_ScreenShots_URL: https://drive.google.com/open?id=12IHzl5d4Kc8_8i592e6AEyHbZ-K9Rnbw
			// TCs_URL: https://docs.google.com/spreadsheets/d/15wLl0osh8BKv4rEjJlXZPM2Ameff7Uf1Lzjkl4c4Ebo/edit#gid=0
			// TC_ID: TC_44
			// TC_Scenario: B2B-Admin acc -> Agency tab -> TicketingFee Column -> Tciketing fee name: small, three dots; Column name is full (no contractions)

package pageAgency;


import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class TicketingFeeSmallTextCheck {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		// Open a browser
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		
		// open website
		driver.get("https://adminfrontend.b2b-staging.thebestagent.pro/");
		Thread.sleep(3000);
		
		// log in
	    driver.findElement(By.id("login-email")).sendKeys("admin@antorica.com");
	    driver.findElement(By.id("login-password")).sendKeys("cba321");
		driver.findElement(By.cssSelector(".auth__login .button")).click();
		Thread.sleep(3000);
		
		// open Agencies page
		driver.findElement(By.linkText("Agencies")).click();
		Thread.sleep(1500);
		
		// Looking for Ticketing Fee Small Text font-size value and General font size
		try {
			// Small text value search
     		WebElement e = driver.findElement(By.className("small-text"));
		   	String actualValue = e.getCssValue("font-size");
		   	
		   	// General font size search
		   	WebElement c = driver.findElement(By.xpath("/html/body/div[2]/section[2]/div/div/table/tbody"));
		    String actualValuebody = c.getCssValue("font-size");
		    
		   	System.out.println("1. Ticketing fee font size (should be less than body font-size): " + actualValue + "\n" + "Body font size: " + actualValuebody);
		    }
		
		catch(Exception e) {
			System.out.println("Value not found. FAIL");
	   		
	        }
	   
	   //Checking if the column title is full, not cut 
	   try{
		   WebDriverWait fieldname = new WebDriverWait(driver,3);
		   fieldname.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[2]/section[2]/div/div/table/thead/tr/th[2]"), "Ticketing fee preset"));
		   System.out.println("2. Field title found. Full text. As expected. PASS");
		  }
	   
	   catch(Exception fieldname) {
		   System.out.println("2. Field title not found or name is not full. FAIL");
	      }

	   // Following code captures the screenshot and place it in specified location
	   TakesScreenshot ts = (TakesScreenshot)driver;
		File scrFile = ts.getScreenshotAs(OutputType.FILE);
		
		String desiredName = "D:/AlexP/Trash/TickFeeNameFullSmall.png";
		File dstFile = new File(desiredName);
	    int i = 0;
		while (dstFile.exists ()) {
		      i += 1;
		      desiredName = "D:/AlexP/Trash/TickFeeNameFullSmall(" + i + ").png";
		      dstFile = new File(desiredName);
		    
		   	}
		System.out.println("3. ScreenShot is taken, please check the folder D:/AlexP/Trash/");
		Files.copy(scrFile, dstFile); 
	   
   }
}
