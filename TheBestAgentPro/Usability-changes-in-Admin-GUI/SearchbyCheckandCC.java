			// Task_Name: "37 Usability changes in Admin GUI"
			// Task_URL: https://typeable.atlassian.net/browse/B2B-397?atlOrigin=eyJpIjoiZjNjNGYzNTdlNjY1NDU3YzgzZWMxMmU5MGE5OTI2MWMiLCJwIjoiaiJ9
			// Task_ScreenShots_URL: https://drive.google.com/open?id=12IHzl5d4Kc8_8i592e6AEyHbZ-K9Rnbw
			// TCs_URL: https://docs.google.com/spreadsheets/d/15wLl0osh8BKv4rEjJlXZPM2Ameff7Uf1Lzjkl4c4Ebo/edit#gid=0
			// TC_ID: TC_03
			// TC_Scenario: B2B-Admin acc -> Agency tab -> SEARCH field -> Enter Check Limit (number) and/or CC limit (number) -> click SEARCH bttn -> look for the search results with the corresponding Check or CC limits (if found = pass, otherwise = fail)


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

public class SearchbyCheckandCC {

	
	// TODO Auto-generated method stub
	public static void main(String[] args) throws Exception {
		
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
				Thread.sleep(4000);
				
				// open Agencies page
				driver.findElement(By.linkText("Agencies")).click();
				Thread.sleep(3500);
				
				// Search by Ticketing fee preset
				driver.findElement(By.id("search_search")).sendKeys("500");
				Thread.sleep(1500);
				
				// Click the button Search
				driver.findElement(By.className("filter-apply-btn")).click();
				Thread.sleep(4000);
			
				try { 
					WebDriverWait wait = new WebDriverWait(driver,2);
					wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[2]/section[2]/div/div/table/tbody"), "500"));
				    System.out.println("Limit Check/CC search found. NOT as expected. FAIL");
				
				} catch (Exception e) {
					System.out.println("Limit Check/CC search not found. PASS");
					
				} 	
				
				  // Following code captures the screenshot and place it in specified location
			   TakesScreenshot ts = (TakesScreenshot)driver;
				File scrFile = ts.getScreenshotAs(OutputType.FILE);
				
				String desiredName = "D:/AlexP/Trash/001.png";
				File dstFile = new File(desiredName);
			    int i = 0;
				while (dstFile.exists ()) {
				      i += 1;
				      desiredName = "D:/AlexP/Trash/001(" + i + ").png";
				      dstFile = new File(desiredName);
				    
				   	}
				System.out.println("the Screenshot 001 is taken, please check");
				Files.copy(scrFile, dstFile);  
										
			
		    }

		}