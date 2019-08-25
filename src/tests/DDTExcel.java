package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelUtil.ReadExcelFile;

public class DDTExcel {
		WebDriver driver;
		Properties properties;
		
	 @Test(dataProvider="testdata")
	 public void DemoProject(String username, String password) throws InterruptedException, Exception
	 {	
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+properties.getProperty("ChromeDriverPath"));
			driver = new ChromeDriver();
			driver.get(properties.getProperty("URL"));
			driver.manage().window().maximize();
	  
		    driver.findElement(By.id("txtUsername")).sendKeys(username);
		 	driver.findElement(By.id("txtPassword")).sendKeys(password);
		 	driver.findElement(By.id("btnLogin")).click();
		 	
			Thread.sleep(6000);
			 Assert.assertEquals(driver.findElement(By.id("welcome")).getAttribute("id"),"welcome","Login Failed");
//			 String Status="Pass";
//			 if(Status.equalsIgnoreCase("Pass")) {
//				 
//			 }else {
//				     File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//					
//					FileUtils.copyFile(srcFile, new File("D:\\StockAccountingVasu\\StockAccounting\\ScreenShots\\"+" "+Description+FunctionLibrary.generateDate()+".png"));
//					excel.setData(TCModule, j, 5, "FAIL");
//					ModuleStatus="false";
//					test.log(LogStatus.FAIL, Description);
//					break;
//			 }
		     System.out.println("Login successful");
	 }
	  
	 @AfterMethod
	 void ProgramTermination() throws Exception
	 {
	   driver.quit();
	 }
	 
	@DataProvider(name="testdata")
	 public Object[][] TestDataFeed() throws Exception
	 {
		FileInputStream file =  new FileInputStream(System.getProperty("user.dir")+"\\DDF.properties");
		properties = new Properties();
		properties.load(file);
		
		String excelPath=System.getProperty("user.dir")+properties.getProperty("TestDataPath");
		 ReadExcelFile config = new ReadExcelFile(excelPath);
		 int rows = config.getRowCount(0);
		 Object[][] credentials = new Object[rows][2];
	 
		for(int i=0;i<rows;i++)
		{
		 credentials[i][0] = config.getData("Login", i, 0);
		 credentials[i][1] = config.getData("Login", i, 1);
		}
		 return credentials;
		 }
}
