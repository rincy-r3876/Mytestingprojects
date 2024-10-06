package test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.Loginpagefb;

public class Loginpagefb2 extends Basecls {
	WebDriver driver;
	public Loginpagefb2(WebDriver driver2) {
		// TODO Auto-generated constructor stub
	}
	@BeforeTest
	public void test1()
	{
		driver=new ChromeDriver();
	}
	@Test
	public void test2() throws IOException
	{
		FileInputStream ob=new FileInputStream("C:\\Users\\91628\\OneDrive\\Documents\\Username.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(ob);
		XSSFSheet sh=wb.getSheet("Sheet1");
		int rowcount=sh.getLastRowNum();
		
		Loginpagefb2 lp=new Loginpagefb2(driver);
		for(int i=1;i<=rowcount;i++)
		{
			try {
				
				XSSFCell user=sh.getRow(i).getCell(0);
				String username=user.getStringCellValue();
				
				XSSFCell pass=sh.getRow(i).getCell(1);
				 String password=pass.getStringCellValue();
				 
				 System.out.println("username"+username);
				 System.out.println("password"+password);
				 
				 driver.findElement(By.name("email")).sendKeys(username);
				 driver.findElement(By.name("pass")).sendKeys(password);
				 driver.findElement(By.name("login")).click();
				
			}catch(Exception e)
			{
				wb.close();
			}
		}
		
	}

}
