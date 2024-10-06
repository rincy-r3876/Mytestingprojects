package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpagefb {
	WebDriver driver;
	
By fbemail=By.name("email");
By fbpswd=By.name("pass");
By loginbtn=By.name("login");


public Loginpagefb(WebDriver driver)
{
	this.driver=driver;
}

public void enterusername(String username)
{
	WebElement usernameelement=driver.findElement(fbemail);
	usernameelement.clear();
	usernameelement.sendKeys(username);
}
public void enterpassword(String Password)
{
	WebElement passwordelement=driver.findElement(fbpswd);
	passwordelement.clear();
	passwordelement.sendKeys(Password);
}
public void clicklogin()
{
	driver.findElement(loginbtn).click();
	
}
}
