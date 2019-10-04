// CODE NOT READY, ALL TDs FOUND NOT SET UP
            // Task_Name: "37 Usability changes in Admin GUI"
			// Task_URL: https://typeable.atlassian.net/browse/B2B-397?atlOrigin=eyJpIjoiZjNjNGYzNTdlNjY1NDU3YzgzZWMxMmU5MGE5OTI2MWMiLCJwIjoiaiJ9
			// Task_ScreenShots_URL: https://drive.google.com/open?id=12IHzl5d4Kc8_8i592e6AEyHbZ-K9Rnbw
			// TCs_URL: https://docs.google.com/spreadsheets/d/15wLl0osh8BKv4rEjJlXZPM2Ameff7Uf1Lzjkl4c4Ebo/edit#gid=0
			// TC_ID: TC_46
			// TC_Scenario: B2B-Admin acc -> Agency tab -> TicketingFeePreset column -> LookUp funnel click -> returns list of agencies w/ the same fee (if list returns = pass, otherwise = fail)

package pageAgency;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;

public class TicketingFeeLookupFunnel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// Open a browser
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		
		// open website
		driver.get("https://adminfrontend.b2b-staging.thebestagent.pro/");
		Thread.sleep(2000);
		
		// log in
	    driver.findElement(By.id("login-email")).sendKeys("admin@antorica.com");
	    driver.findElement(By.id("login-password")).sendKeys("cba321");
	    driver.findElement(By.cssSelector(".auth__login .button")).click();
	    Thread.sleep(4000);
		
		// open Agencies page
		driver.findElement(By.linkText("Agencies")).click();
		Thread.sleep(3500);
	
		// Column Fee Preset Look Up, Funnel
		driver.findElement(By.xpath("/html/body/div[2]/section[2]/div/div/table/tbody/tr[2]/td[2]/a")).click();
	    Thread.sleep(2000);
	
		// Looking for all tds with the specific fee preset
        WebElement k = driver.findElement(By.xpath("//*[text() = '$15 alluytyuouiypiuyiturituyoiu']"));
        System.out.println(k);

		
		  // Following code captures the screenshot and place it in specified location
	    TakesScreenshot ts = (TakesScreenshot)driver;
		File scrFile = ts.getScreenshotAs(OutputType.FILE);
		
		String desiredName = "D:/AlexP/Trash/TicketFeeFunnelClickListAgencies.png";
		File dstFile = new File(desiredName);
	    int i = 0;
		while (dstFile.exists ()) {
		      i += 1;
		      desiredName = "D:/AlexP/Trash/TicketFeeFunnelClickListAgencies"+ i +".png";
		      dstFile = new File(desiredName);
		    
		   	}
		System.out.println("Screenshot 00* is taken, please check");
		Files.copy(scrFile, dstFile);  	
		
		
	}

}
