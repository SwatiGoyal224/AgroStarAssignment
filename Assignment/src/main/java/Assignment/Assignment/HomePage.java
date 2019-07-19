package Assignment.Assignment;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


import Assignment.Assignment.PropertyReader;
import Assignment.Assignment.ObjectRepoReader;


public class HomePage {
	
	WebDriver driver= null;
	PropertyReader propertyReader;
	ObjectRepoReader objectRepoReader;
	Map<String, Map<String, String>> AmazonORmap;
	
	String mainWindow;
	Set <String> windows;
	
	public HomePage (WebDriver driver) throws IOException {
		this.driver=driver;
	    propertyReader= new PropertyReader();
		objectRepoReader = new ObjectRepoReader();
		AmazonORmap = objectRepoReader.generateOR();
		System.out.println("Map: "+AmazonORmap);
		
	}
	
	public By getElementLocator(Map<String, Map<String, String>> map2,
            String keyWord) {
        Map<String, String> map3 = map2.get(keyWord);
        System.out.println("map3: "+map3);
        By locator = getWebElementBy(map3);
        return locator;
    }
	
	public By getWebElementBy(Map<String, String> map) {
        By locator = null;
        try {
            if (!map.get("PropertyType").isEmpty()) {
                if (map.get("PropertyType").toLowerCase().equals("id")) {
                    locator = By.id(map.get("PropertyValue"));
                } else if (map.get("PropertyType").toLowerCase().equals("name")) {
                    locator = By.name(map.get("PropertyValue"));
                } else if (map.get("PropertyType").toLowerCase().equals("xpath")) {
                    locator = By.xpath(map.get("PropertyValue"));
                } else if (map.get("PropertyType").toLowerCase().equals("linktext")) {
                    locator = By.linkText(map.get("PropertyValue"));
                } else if (map.get("PropertyType").toLowerCase().equals("css")) {
                    locator = By.cssSelector(map.get("PropertyValue"));
                }

            } else {
                System.out.println("Property type is empty");
            }
        } catch (NullPointerException e) {
        	System.out.println("Element mentioned in OR File NOT Found on the page: " + driver.getTitle() + " and reason is: " + e);
        } catch (Exception e) {
        	System.out.println("Property type is empty or some other error" + e);
        }
        return locator;

    }
	
	public void ValidateLogInFunctionality() throws InterruptedException {
		
		WebElement ele=driver.findElement(getElementLocator(AmazonORmap,"Signin_nav"));
		ele.click();
		//driver.findElement(By.id("ap_email")).sendKeys(propertyReader.getUserName());
		driver.findElement(getElementLocator(AmazonORmap,"Username")).sendKeys(propertyReader.getUserName());
		driver.findElement(getElementLocator(AmazonORmap,"ContinueButton")).click();
		driver.findElement(getElementLocator(AmazonORmap,"Password")).sendKeys(propertyReader.getPassWord());
		driver.findElement(getElementLocator(AmazonORmap,"LoginButton")).click();

	}
	
	
	public void searchItem() throws InterruptedException {
		driver.findElement(getElementLocator(AmazonORmap,"SearchBar")).sendKeys(propertyReader.getItem());
		driver.findElement(getElementLocator(AmazonORmap,"SeachButton")).click();
	}
	
	public void clickonItem() {
		driver.findElement(getElementLocator(AmazonORmap,"item")).click();
		}
	
	public void AddItemtoCart() {
		
	    mainWindow=driver.getWindowHandle();
		
		windows=driver.getWindowHandles();
		System.out.println(windows.size());
		
		Iterator<String> itr=windows.iterator();		
		
        while(itr.hasNext())			
        {		
            String ChildWindow=itr.next();
            if(!mainWindow.equalsIgnoreCase(ChildWindow))			
            {    		
                 
                    // Switching to Child window
                    driver.switchTo().window(ChildWindow);
                    driver.findElement(getElementLocator(AmazonORmap,"AddtoCartButton")).click();
                    
            }
        }
	}
	
	public void validateCartFunctionality() throws InterruptedException {
		driver.findElement(getElementLocator(AmazonORmap,"CartButton")).click();
		Thread.sleep(3000);
		driver.findElement(getElementLocator(AmazonORmap,"Gift_checkbox")).click();
		//driver.switchTo().frame(1);
		driver.findElement(getElementLocator(AmazonORmap,"ProceedtoPayButton")).click();
		
	}
	
	public void enterAddressDetails() {
		driver.findElement(getElementLocator(AmazonORmap,"Pincode")).sendKeys(propertyReader.getPincode());
		driver.findElement(getElementLocator(AmazonORmap,"AddressLine1")).sendKeys(propertyReader.getAddress1());
		driver.findElement(getElementLocator(AmazonORmap,"AddressLine2")).sendKeys(propertyReader.getAddress2());
		driver.findElement(getElementLocator(AmazonORmap,"City")).sendKeys(propertyReader.getCity());
		driver.findElement(getElementLocator(AmazonORmap,"State")).sendKeys(propertyReader.getState());
		
		driver.findElement(getElementLocator(AmazonORmap,"AddressContinueButton")).click();
	}
	
	public void signOut() throws InterruptedException {
		driver.switchTo().window(mainWindow);
		
		Actions action=new Actions(driver);
		WebElement ele=driver.findElement(getElementLocator(AmazonORmap,"Signout_panel"));
		action.moveToElement(ele).perform();
		Thread.sleep(3000);
		driver.findElement(getElementLocator(AmazonORmap,"SignOut")).click();
	}
	

}