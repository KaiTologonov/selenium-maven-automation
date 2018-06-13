package com.dice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceTest {

	public static void main(String[] args) {
		
		//no longer needed to set property 
		WebDriverManager.chromedriver().setup();
//		System.setProperty("webdriver.chrome.driver", 
//				"/Users/kairattologonov/Documents/selenium dependencies/drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.dice.com");
		//start in fullscreen
		driver.manage().window().fullscreen();
		//set universal wait time in case web page is slow
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		if(driver.getTitle().equals("Job Search for Technology Professionals | Dice.com")) {
			System.out.println("Page Test Passed");
		}else {
			System.out.println("Page Test Failed");
			throw new RuntimeException("Fail");
		}
		
		driver.findElement(By.id("search-field-keyword")).clear();
		driver.findElement(By.id("search-field-keyword")).sendKeys("Java developer");
		driver.findElement(By.id("search-field-location")).clear();
		driver.findElement(By.id("search-field-location")).sendKeys("Houston,TX");
		driver.findElement(By.id("findTechJobs")).click();
		
		String count = driver.findElement(By.id("posiCountId")).getText();
		int countResult = Integer.parseInt(count.replace(",", ""));
		if(countResult>0) {
			System.out.println("Search returned " + countResult + " results in Houston, TX");
		}else {
			System.out.println("Test Failed. Search returned " + countResult + " results in Houston, TX");
		}
		
		driver.close();
		
		
		
		
		
		
		
	}

}
