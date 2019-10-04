			// Task_Name: "37 Usability changes in Admin GUI"
			// Task_URL: https://typeable.atlassian.net/browse/B2B-397?atlOrigin=eyJpIjoiZjNjNGYzNTdlNjY1NDU3YzgzZWMxMmU5MGE5OTI2MWMiLCJwIjoiaiJ9
			// Task_ScreenShots_URL: https://drive.google.com/open?id=12IHzl5d4Kc8_8i592e6AEyHbZ-K9Rnbw
			// TCs_URL: https://docs.google.com/spreadsheets/d/15wLl0osh8BKv4rEjJlXZPM2Ameff7Uf1Lzjkl4c4Ebo/edit#gid=0
			// TC_ID: TC_47
			// TC_Scenario: B2B-Admin acc -> Agency tab -> Column Agents Count -> We need to find picture and find title -> Mouseover (if title takes place = pass, otherwise = fail)

package pageAgency;


import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;

public class ColumnAgentsCountPicture {

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
		Thread.sleep(5000);
		
		// open Agencies page
		driver.findElement(By.linkText("Agencies")).click();
		Thread.sleep(1500);
		
		// Looking for Picture Agents count 
		Actions actions = new Actions(driver);
		
		// Retrieve WebElement 'chelovechek' to perform mouse over
		WebElement chelovechek = driver.findElement(By.xpath("/html/body/div[2]/section[2]/div/div/table/thead/tr/th[6]/div"));
	
		// Move mouse
		actions.moveToElement(chelovechek).perform();
		Thread.sleep(3000);
		
		  // Following code captures the screenshot and place it in specified location
	   TakesScreenshot ts = (TakesScreenshot)driver;
		File scrFile = ts.getScreenshotAs(OutputType.FILE);
		
		String desiredName = "D:/AlexP/Trash/ChelovechekMouseOverTitle.png";
		File dstFile = new File(desiredName);
	    int i = 0;
		while (dstFile.exists ()) {
		      i += 1;
		      desiredName = "D:/AlexP/Trash/ChelovechekMouseOverTitle(" + i + ").png";
		      dstFile = new File(desiredName);
		    
		   	}
		System.out.println("Screenshot is taken, please check");
		Files.copy(scrFile, dstFile);  	
				

	}

}
