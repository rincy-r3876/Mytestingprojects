package automationprojects;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;



public class Rediffmail {
	ChromeDriver driver;
	@Before
	public void launchwebsite()
	{
		driver=new ChromeDriver();
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
	}
  @Test
public void titleverification()
{
	String actualtitle=driver.getTitle();
	String expectedtitle="Welcome To Rediffmail";
	if(actualtitle.equals(expectedtitle))
	{
		System.out.println("Same title");
	}
	else
	{
		System.out.println("Different title");
	}
}
 
  @Test
  public void createaccoount()
  {
	  driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input")).sendKeys("Anagha");
	  driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]")).sendKeys("anagha123@gmail.com");
	  driver.findElement(By.id("newpasswd")).sendKeys("Anagha@123");
	  driver.findElement(By.id("newpasswd1")).sendKeys("Anagha@123");
	  driver.findElement(By.xpath("//*[@id=\"div_altemail\"]/table/tbody/tr[1]/td[3]/input")).sendKeys("anagha1267@gmail.com");
	  driver.findElement(By.xpath("//*[@id=\"mobno\"]")).sendKeys("7080125656");
	  WebElement day=driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[1]"));
		Select dayelement=new Select(day);
		dayelement.selectByValue("23");
		WebElement month=driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[2]"));
		Select monthelement=new Select(month);
		monthelement.selectByValue("06");
		WebElement year=driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[3]"));
		Select yearelement=new Select(year);
		yearelement.selectByValue("1999");
		WebElement city=driver.findElement(By.xpath("//*[@id=\"div_city\"]/table/tbody/tr[1]/td[3]/select"));
		  Select cityname=new Select(city);
		  cityname.selectByValue("Bangalore");

        // and select a radio button
        WebElement maleRadioButton = driver.findElement(By.xpath("//input[@value='m']"));
        maleRadioButton.click();

        // Locate and select a checkbox
        WebElement termsCheckbox = driver.findElement(By.id("checkbox_id")); // Replace with actual ID
        termsCheckbox.click();

        // Verify if the radio button is selected
        if (maleRadioButton.isSelected()) {
            System.out.println("Male radio button is selected.");
        }

        // Verify if the checkbox is selected
        if (termsCheckbox.isSelected()) {
            System.out.println("Terms and conditions checkbox is selected.");
            driver.findElement(By.xpath("//*[@id=\"Register\"]")).click();
            
        }}
        
        @Test
        public void links()
        {
        	List<WebElement>li=driver.findElements(By.tagName("a"));
        	int link=li.size();
        	System.out.println(link );
        	for(WebElement s:li)
        	{
        		String value=s.getAttribute("href");
        		System.out.println(value);
        	}}
        @Test
        public void retreivingtext()
        {
        	WebElement button=driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[2]"));
        	String text=button.getAttribute("value");
        	System.out.println(text);
        	String exptext="Check availability";
        	if(text.equals(exptext))
        	{
        		System.out.println("matching");
        	}
        	else
        	{
        		System.out.println("not matching");
        	}
        }
        @Test
        public void brokenlinks() throws MalformedURLException
        {
        	int brokenlinks=0;	
        	List<WebElement>links=driver.findElements(By.tagName("a"));
        	for(WebElement element:links)
        	{
        		String url=element.getAttribute("href");
        		if(url==null || url.isEmpty())
        		{
        			System.out.println("this url is empty");
        		}
        		URL link=new URL(url);
        		try {
        			
        		HttpURLConnection co=(HttpURLConnection)link.openConnection();	
        			
        			co.connect();
        			if(co.getResponseCode()>=400)
        			{
        				System.out.println(co.getResponseCode() + url + "this is a broken link");
        				brokenlinks++;
        			}
        			else
        			{
        				System.out.println(co.getResponseCode() + url + "this is an active link");
        			}
        		} catch (Exception e) {
        			
        		}
        	}
        	System.out.println(" number of brokenlinks is "+ brokenlinks);
        }

        
        @Test
        public void loginTest() {
            // Navigate to the login page after account creation
            driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

            // Perform actions to login
            driver.findElement(By.id("login1")).sendKeys("Anagha123");
            driver.findElement(By.id("password")).sendKeys("anagha@123");
            driver.findElement(By.name("proceed")).click();

        }
        @After
        public void tearDown()
        {
        	driver.quit();
        }
}
  

	  
  

