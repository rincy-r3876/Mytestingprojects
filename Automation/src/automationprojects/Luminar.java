package automationprojects;

import org.openqa.selenium.chrome.ChromeDriver;

public class Luminar {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.luminartechnolab.com/");
		String actualtitle=driver.getTitle();
		String exptitle="Luminar";
		if(exptitle.equals(actualtitle))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		

	}

}
