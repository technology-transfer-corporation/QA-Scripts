			// Task_Name: "37 Usability changes in Admin GUI"
			// Task_URL: https://typeable.atlassian.net/browse/B2B-397?atlOrigin=eyJpIjoiZjNjNGYzNTdlNjY1NDU3YzgzZWMxMmU5MGE5OTI2MWMiLCJwIjoiaiJ9
			// Task_ScreenShots_URL: https://drive.google.com/open?id=12IHzl5d4Kc8_8i592e6AEyHbZ-K9Rnbw
			// TCs_URL: https://docs.google.com/spreadsheets/d/15wLl0osh8BKv4rEjJlXZPM2Ameff7Uf1Lzjkl4c4Ebo/edit#gid=0
			// TC_ID: TC_07, TC_08
			// TC_Scenario: B2B-Admin acc -> Agency tab -> SEARCH field -> Enter date (agency created/updated) -> click SEARCH bttn -> look for the agency/ies with the exact created/updated date (if found = pass, otherwise = fail)

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

public class SearchbyCreatedUpdatedDate {

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
				Thread.sleep(8000);
				
				// open Agencies page
				driver.findElement(By.linkText("Agencies")).click();
				Thread.sleep(3500);
				
				// Search by Created/Updated Time
				driver.findElement(By.id("search_search")).sendKeys("05:06 PM");
				Thread.sleep(1500);
				
				// Click the button Search
				driver.findElement(By.className("filter-apply-btn")).click();
				Thread.sleep(4000);
			
				try { 
					WebDriverWait wait = new WebDriverWait(driver,2);
					wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[2]/section[2]/div/div/table/tbody"), "05:06 PM"));
				    System.out.println("Created Time search found. NOT as expected. FAIL");
				
				} catch (Exception e) {
					System.out.println("Created Time search not found. PASS");
					
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
				Thread.sleep(4000);
				
				
				// New Search by Created/Updated Time
				WebElement searchfield = driver.findElement(By.id("search_search"));
					searchfield.clear();
					searchfield.sendKeys("11/18/2016");
				Thread.sleep(1500);
						
				// Click the button Search
				driver.findElement(By.className("filter-apply-btn")).click();
				Thread.sleep(4000);
					
				try { 
					WebDriverWait wait = new WebDriverWait(driver,2);
					wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[2]/section[2]/div/div/table/tbody"), "11/18/2016"));
				    System.out.println("Created Time search found. NOT as expected. FAIL");
				
				} catch (Exception e) {
					System.out.println("Created Time search not found. PASS");
					
				} 	
						
				 // Following code captures the screenshot and place it in specified location
				TakesScreenshot tss = (TakesScreenshot)driver;
				File scrFile1 = tss.getScreenshotAs(OutputType.FILE);
				
				String desiredName1 = "D:/AlexP/Trash/001.png";
				File dstFile1 = new File(desiredName1);
				int ii = 0;
				while (dstFile1.exists ()) {
				  ii += 1;
				  desiredName1 = "D:/AlexP/Trash/001(" + ii + ").png";
				  dstFile1 = new File(desiredName1);
						    
				}
				System.out.println("the Screenshot 001 () is taken, please check");
				Files.copy(scrFile1, dstFile1);
	}

}
