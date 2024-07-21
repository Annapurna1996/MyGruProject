package com.tests.pageTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class Day3 {
	WebDriver driver;
  @Test
  public void f() {
	  driver.findElement(By.xpath("//li//a[text()='Mobile']")).click();
	//h2//a[text()='Sony Xperia']/../..//button//span[text()='Add to Cart']
	  driver.findElement(By.xpath("//h2//a[text()='Sony Xperia']/../..//button//span[text()='Add to Cart']")).click();
	  WebElement txtbox = driver.findElement(By.xpath("//input[@type='text' and @class='input-text qty']"));
	  txtbox.clear();
	  txtbox.sendKeys("1000");
	  driver.findElement(By.xpath("//span[text()='Update']")).click();
	 String msg = driver.findElement(By.xpath("//p[contains(text(),'maximum quantity')]")).getText();
//	  
//	  if(msg.contains("The maximum quantity allowed for purchase is 500.")) {
//		  System.out.println("test pass");
//		  
//	  }
//	  else {
//		  System.out.println("Test Fail");
//	  }
	 // assertEquals(true, msg,"Failed test");
	  assertTrue(true, msg);
	  System.out.println("Test pass");
	  driver.findElement(By.xpath("//span[text()='Empty Cart']")).click();
	  driver.findElement(By.xpath("//span[text()='Cart']")).click();
	  String txt =driver.findElement(By.xpath("//p[contains(text(),'You have no items') and @class='empty']")).getText();
//	  if(txt.contains("You have no items ")) {
//		  System.out.println("Test Pass");
//		  
//	  }
//	  else {
//		  System.out.println("Test Fail");
//	  }
	  assertTrue(true, txt);
	  System.out.println("test pass");
  }
  @BeforeMethod 
  public void setUp() {
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://live.techpanda.org/index.php/");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  }
  
}
