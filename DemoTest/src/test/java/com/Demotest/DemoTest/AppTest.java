package com.Demotest.DemoTest;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Unit test for simple App.
 */
public class AppTest {
public static void main(String args[]){
	    
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "S:\\studyparts\\Drivers\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		String username = "Linda Jane Anderson";
		HttpURLConnection huc;
		int respCode = 200;
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		driver.findElement(By.xpath("//b[text()='Admin']")).click();
		
		Select select = new Select(driver.findElement(By.id("searchSystemUser_userType")));
		select.selectByVisibleText("Admin");
		driver.findElement(By.name("_search")).click();
		
		// Username and Employee name Match
		List<WebElement> listofUsername = driver.findElements(By.xpath("//table[@class='table hover']//td[2]//a"));
		List<WebElement> listofEmpname = driver.findElements(By.xpath("//table[@class='table hover']//td[4]"));
		List<String> usernameregx = new ArrayList<String>();
		
		Iterator<WebElement> it = listofUsername.iterator();
		Iterator<WebElement> itemp = listofEmpname.iterator();
		
		while(it.hasNext()&&itemp.hasNext()){
			String userName = it.next().getText();
			String EmpName = itemp.next().getText();
			String replaceUsername = userName.replaceAll("[^_-.]*", " ");
			if(EmpName.equals(replaceUsername)){
			usernameregx.add(replaceUsername);
			}
			else{
				usernameregx.add("Nothing to Add");
			}
		}
		
		Iterator<String> it1 = usernameregx.iterator();
		
		while(it1.hasNext()){
			System.out.println(it1.next());
		}
		
		
		
//		String beforexpath = "//div[@Id='customerList']//tbody//descendant::td[contains(text(),'"+username+"')]";
//		String result = driver.findElement(By.xpath(beforexpath)).getText();
//		System.out.println(result);
		
//		List<WebElement> listofAdmin = driver.findElements(By.xpath("//table[@class='table hover']//td[2]//a"));
//		for(int i = 1; i<=listofAdmin.size();i++){
//			System.out.println(listofAdmin.get(i).getText());
//			
//		}
		
		/* To check for Broken links in WebPage */
//		WebDriverWait wait = new WebDriverWait(driver,5);
//		WebElement expliwait = wait.until(ExpectedConditions.prs)
//		List<WebElement> listofAdmin = driver.findElements(By.xpath("//table[@class='table hover']//td[2]//a"));
//		for(int i = 0; i<listofAdmin.size();i++){
//			String url = listofAdmin.get(i).getAttribute("href");
//			if(url==null||url.isEmpty()){
//				System.out.println("Anchor tag is empty");
//				continue;
//			}
//		try{
//			huc = (HttpURLConnection)(new URL(url).openConnection());
//			huc.setRequestMethod("HEAD");
//			huc.connect();
//			respCode = huc.getResponseCode();
//			if(respCode>=400){
//				System.out.println("Link is broken");
//			}
//			else{
//				System.out.println("Link is working Fine!!");
//			}
//		}catch (Exception e) {
//			System.out.println("Exception occured");
//			e.printStackTrace();
//		}
//		}
			
		
		driver.quit();
		}	
	}

