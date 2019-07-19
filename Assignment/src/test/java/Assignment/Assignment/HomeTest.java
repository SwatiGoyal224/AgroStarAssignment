package Assignment.Assignment;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import Assignment.Assignment.HomePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomeTest {
	
	WebDriver driver;
	HomePage homePage;

	
	@BeforeClass
	
	public void setUp() throws IOException {
		
	System.setProperty("webdriver.chrome.driver", "/Users/sgoyal/Documents/AgroStar/AgroStarAssignment/Assignment/src/main/resources/Drivers/ChromeDriver/chromedriver");
	
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://www.amazon.in//");
	
	homePage=new HomePage(driver);
	
	}
	
	@Test(priority=0)
	public void validateSignIn() throws InterruptedException {
		homePage.ValidateLogInFunctionality();
	}
	
	@Test(priority=1)
	
	public void validateAddtoCartFunctionality() throws InterruptedException {
		
		homePage.searchItem();
		homePage.clickonItem();
		homePage.AddItemtoCart();
		
	}
	
	@Test(priority=2)
	public void validateCart() throws InterruptedException {
		homePage.validateCartFunctionality();
	}
	
	@Test(priority=3)
	public void ValidateAddressPage() throws InterruptedException {
		homePage.enterAddressDetails();
		homePage.signOut();
	}
	
	
	@AfterClass
	public void cleanUp(){
		
		driver.close();
	}
	
}
