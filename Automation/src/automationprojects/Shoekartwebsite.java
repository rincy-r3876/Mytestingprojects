package automationprojects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Shoekartwebsite {


ChromeDriver driver;
int brokenlink=0;
@BeforeTest
public void step1()
{
	driver=new ChromeDriver();
	driver.get("https://www.shoe-kart.com/");
}
@Test
public void brokenlink()  throws IOException
{
List<WebElement>links=driver.findElements(By.tagName("a"));
for(WebElement element:links)
{
	String url=element.getAttribute("href");
	if(url==null || url.isEmpty())
		
	{
		System.out.println("this is an empty link");
		continue;
		
	}
	URL link=new URL(url);
				try {
				HttpURLConnection co=(HttpURLConnection)link.openConnection();	
				co.connect();
				if(co.getResponseCode()>=400)
				{
					System.out.println(co.getResponseCode() + url + " is a brokenlink ");
					brokenlink++;
				}
				else
				{
					System.out.println(co.getResponseCode() + url + " is an active link ");
				}
					
					
					
				} catch (MalformedURLException e) {
					
				}
			}
			System.out.println("number of brokenlinks is "+brokenlink);
		}
		
@Test
public void logoverification()
{
	WebElement logo=driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div/div[1]/div/h1/a/img"));
	org.openqa.selenium.Dimension size=logo.getSize();
	int width=size.getWidth();
	int height=size.getHeight();
	
	String logosrc=logo.getAttribute("src");
	System.out.println(logosrc);
	//logo visibility
	if(logo.isDisplayed())
	{
		System.out.println("logo is visible");
	}
	else
	{
		System.out.println("logo is not visible");
	}
	if(logo!= null)
		System.out.println("logo is present");
	else
		System.out.println("logo not present");
}}


	