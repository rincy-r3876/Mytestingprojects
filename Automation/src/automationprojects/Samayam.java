package automationprojects;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Samayam {
	ChromeDriver driver;
	@Before
	public void launch()
	{
		driver=new ChromeDriver();
		driver.get("https://malayalam.samayam.com/");
	}
	@Test
	public void test1()
	{
		driver.findElement(By.xpath("//*[@id=\"headerWithTopAtf\"]/header/div[1]/div/div[2]/div/span"));
		//*[@id="headerWithTopAtf"]/header/div[1]/div/div[2]/div/span
		driver.findElement(By.id("emailAndMobile")).sendKeys("7510459129");
		driver.findElement(By.id("signInButton")).click();
		
	}

}
