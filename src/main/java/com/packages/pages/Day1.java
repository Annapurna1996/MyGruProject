package com.packages.pages;

import java.time.Duration;
import java.util.List;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Day1 {
	static String list1;
	static String list2;

	public static void main(String[] args) {
		//WebDriver driver;
		WebDriver driver = new ChromeDriver();
		driver.get("http://live.techpanda.org/index.php/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String title1=driver.getTitle();
		System.out.println(title1);
		if(title1.equals("Home page")) {
			System.out.println("Title was matched");
		}
		else {
			System.out.println("Title was not matched");
		}
		WebElement mobile=driver.findElement(By.xpath("//a[text()='Mobile']"));
		mobile.click();
		String title=driver.getTitle();
		System.out.println(title);
		List<WebElement> drpdwn = driver.findElements(By.xpath("//div/h2[@class='product-name']"));
		for(int i=0;i<drpdwn.size();i++) {
			 list1=drpdwn.get(i).getText();
			System.out.println(list1);
			
		}
		WebElement dropdown=driver.findElement(By.xpath("(//select[@title='Sort By'])[1]"));
		Select dropdownn = new Select(dropdown); 
		dropdownn.selectByIndex(1); 
		
		List<WebElement> drpdwn1 = driver.findElements(By.xpath("//div/h2[@class='product-name']"));
		System.out.println("size: "+drpdwn1.size());
		for(int i=0;i<drpdwn1.size();i++) {
			  list2=drpdwn1.get(i).getText();
			System.out.println(list2);
			
		}
		if(list1==list2) {
			System.out.println("Moblie sort was not done,fail");
			
		}
		else {
			System.out.println("Mobile sort was done,pass");
		}
	
        
        driver.close();
	}

}
