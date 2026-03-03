package pages;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import base.TestBase;
import utils.CommonUtils;

public class AmazonHomePage extends TestBase {

    // Locators - Object Repository
    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    WebElement searchBtn;
    
    @FindBy(xpath = "//span[contains(text(), 'iPhone 17 Pro Max')][1]")
    WebElement iphone15Pro;
    
    @FindBy(xpath = "//span[contains(@class,'a-price aok-align-center reinventPricePriceToPayMargin priceToPay apex-pricetopay-value')]//span[2]//span[2][contains(@class,'a-price-whole')]")
    WebElement iphonePrize;
    
    @FindBy(xpath = "//span[contains(text(), 'iPhone Air')][1]")
    WebElement iphone16ProMax;

    // Initializing the Page Objects
    public AmazonHomePage() {
        PageFactory.initElements(driver, this);
    }
    
    CommonUtils util=new CommonUtils();

  	Actions action=new Actions(driver);
    // Actions
    public void searchForProduct(String product) {
        searchBox.sendKeys(product);
        searchBtn.click();
    }
    public void selectProduct() throws InterruptedException {
  
    	action.moveToElement(iphone15Pro);
    	
    	Thread.sleep(1000);
    	iphone15Pro.click();
    	
    	String parentWindow = driver.getWindowHandle();
    	Set<String> allWindows = driver.getWindowHandles();
    	
    	for (String handle : allWindows) {
    	    if (!handle.equals(parentWindow)) {
    	        driver.switchTo().window(handle);
    	        String prize=iphonePrize.getText();
    	       System.out.println("Prize of phone 17 pro max is :"+prize);
    	       driver.close();
    	    }
    	}
    	driver.switchTo().window(parentWindow);
    	
    }
    public void searchForProductnew(String product) throws InterruptedException, IOException {
    	searchBox.clear();
        searchBox.sendKeys(product);
        searchBtn.click();
        
        action.moveToElement(iphone16ProMax);
    	
    	Thread.sleep(1000);
    	iphone16ProMax.click();
    	
    	String parentWindow = driver.getWindowHandle();
    	Set<String> allWindows = driver.getWindowHandles();
    	
    	for (String handle : allWindows) {
    	    if (!handle.equals(parentWindow)) {
    	        driver.switchTo().window(handle);
    	        String prize=iphonePrize.getText();
    	       System.out.println("Prize of phone 17 air is: "+prize);
    	       
    	       System.out.println("Prize of phone 17 air is: "+prize);
    	       
    	       util.takeScreenshotAtEndOfTest();
    	       
    	       driver.close();
    	    }
    	}
    	driver.switchTo().window(parentWindow);
        
    }
    public void verifyAPIGet() {
    	baseURI="https://reqres.in/api/test-suite/";
    	given()
            .get("collections/users/records")
    .then()
        .statusCode(200)
        .log().all();
    }
}