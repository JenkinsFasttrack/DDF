package fdfdfdf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestMultipleSession {
	public String url="https://opensource-demo.orangehrmlive.com/";
	public String username="Admin",password="admin123";
	
	@Test
	public void executSessionOne(){
	//First session of WebDriver
		        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Venkatesh\\Downloads\\DDF\\drivers\\chromedriver.exe");
	            WebDriver driver = new ChromeDriver();
		        driver.get(url);
			    driver.manage().window().maximize();
			//find user name text box and fill it
	            driver.findElement(By.id("txtUsername")).sendKeys(username); 
	            driver.findElement(By.id("txtPassword")).sendKeys(password);
	            driver.findElement(By.id("btnLogin")).click();
	        }
	
	@Test
	public void executeSessionTwo(){
	//Second session of WebDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Venkatesh\\Downloads\\DDF\\drivers\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();;
	driver.get(url);
			driver.manage().window().maximize();
	//find user name text box and fill it
	driver.findElement(By.id("txtUsername")).sendKeys(username);
	driver.findElement(By.id("txtPassword")).sendKeys(password);
    driver.findElement(By.id("btnLogin")).click();
	        }
	
	@Test
	public void executSessionThree(){
	//Third session of WebDriver
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Venkatesh\\Downloads\\DDF\\drivers\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	driver.get(url);
			driver.manage().window().maximize();
	//find user name text box and fill it
	driver.findElement(By.id("txtUsername")).sendKeys(username);
	driver.findElement(By.id("txtPassword")).sendKeys(password);
    driver.findElement(By.id("btnLogin")).click();
	        }        

}
