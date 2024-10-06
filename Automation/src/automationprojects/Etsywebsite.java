package automationprojects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Etsywebsite {
	ChromeDriver driver;
	@BeforeTest
    public void setUp() {
        
        driver = new ChromeDriver();
        driver.get("https://www.etsy.com");
    }
    @Test(priority = 6)
    public void registration()
    {
    	WebElement signin=driver.findElement(By.xpath("//*[@id=\"gnav-header-inner\"]/div[3]/nav/ul/li[1]/button"));
    	signin.click();
    }

   @Test(priority = 1)
    public void testUserRegistrationAndLogin() {
        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"gnav-header-inner\"]/div[4]/nav/ul/li[1]/button"));
        signInButton.click();

        WebElement emailField = driver.findElement(By.name("email"));
        WebElement passwordField = driver.findElement(By.name("password"));
        emailField.sendKeys("rincyreji@gmail.com");
        passwordField.sendKeys("abcd@123");

        WebElement submitButton = driver.findElement(By.name("submit_attempt"));
        submitButton.click();

       WebElement profileIcon = driver.findElement(By.xpath("//span[@class='wt-avatar__img']"));
     Assert.assertTrue(profileIcon.isDisplayed(), "Login failed!");
    }

     @Test(priority = 2)
    public void testSearchFunctionality() {
        WebElement searchField = driver.findElement(By.name("search_query"));
        searchField.sendKeys("handmade jewelry");

        WebElement searchButton = driver.findElement(By.xpath("//button[@value='Search']"));
        searchButton.click();

        WebElement firstResult = driver.findElement(By.xpath("//ul[@data-search-results]//li[1]"));
        Assert.assertTrue(firstResult.isDisplayed(), "Search results are not displayed.");
    }

    @Test(priority = 3)
    public void testProductListings() {
        WebElement searchField = driver.findElement(By.name("search_query"));
        searchField.sendKeys("handmade jewelry");
        WebElement searchButton = driver.findElement(By.xpath("//button[@value='Search']"));
        searchButton.click();

        WebElement firstProduct = driver.findElement(By.xpath("//ul[@data-search-results]//li[1]//a"));
        firstProduct.click();

        WebElement productTitle = driver.findElement(By.xpath("//h1[@data-buy-box-listing-title]"));
        WebElement productPrice = driver.findElement(By.xpath("//p[@data-buy-box-region='price']"));
        Assert.assertTrue(productTitle.isDisplayed() && productPrice.isDisplayed(), "Product details are not displayed.");
    } 

   @Test(priority = 4)
    public void testShoppingCart() {
        WebElement searchField = driver.findElement(By.name("search_query"));
        searchField.sendKeys("handmade jewelry");
        WebElement searchButton = driver.findElement(By.xpath("//button[@value='Search']"));
        searchButton.click();

        WebElement firstProduct = driver.findElement(By.xpath("//ul[@data-search-results]//li[1]//a"));
        firstProduct.click();

        WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]"));
        addToCartButton.click();

        WebElement cartIcon = driver.findElement(By.xpath("//span[@data-cart-count]"));
        Assert.assertEquals(cartIcon.getText(), "1", "Product not added to cart.");
    }

    @Test(priority = 5)
    public void testCheckoutProcess() {
        WebElement searchField = driver.findElement(By.name("search_query"));
        searchField.sendKeys("handmade jewelry");
        WebElement searchButton = driver.findElement(By.xpath("//button[@value='Search']"));
        searchButton.click();

        WebElement firstProduct = driver.findElement(By.xpath("//ul[@data-search-results]//li[1]//a"));
        firstProduct.click();

        WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]"));
        addToCartButton.click();

        WebElement checkoutButton = driver.findElement(By.xpath("//button[contains(text(),'Proceed to checkout')]"));
        checkoutButton.click();

        WebElement shippingAddress = driver.findElement(By.id("shipping-address"));
        shippingAddress.sendKeys("123 Main St, City, Country");
        WebElement paymentMethod = driver.findElement(By.id("payment-method"));
        paymentMethod.sendKeys("Credit Card");

        WebElement confirmOrderButton = driver.findElement(By.xpath("//button[contains(text(),'Confirm order')]"));
        confirmOrderButton.click();

        WebElement orderConfirmation = driver.findElement(By.xpath("//h1[contains(text(),'Thank you for your order')]"));
        Assert.assertTrue(orderConfirmation.isDisplayed(), "Order placement failed.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    } 
}





