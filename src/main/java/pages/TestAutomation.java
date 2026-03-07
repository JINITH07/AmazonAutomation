package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import utils.CommonUtils;

public class TestAutomation extends TestBase {

    // Locators - Object Repository
    @FindBy(id = "name")
    WebElement name;
    
    @FindBy(id = "email")
    WebElement email;
    
    @FindBy(id = "phone")
    WebElement phone;
    
    @FindBy(id = "male")
    WebElement maleCheckbox;
    
    @FindBy(id = "monday")
    WebElement mondayCheckbox;
    
    @FindBy(id = "country")
    WebElement CountryDropdown;
    
    @FindBy(id = "datepicker")
    WebElement Datepicker;
    
    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']//td")
    List<WebElement> datesselector;

    // Initializing the Page Objects
    public TestAutomation() {
        PageFactory.initElements(driver, this);
    }
    
    CommonUtils util=new CommonUtils();
  	Actions action=new Actions(driver);
    // Actions
    public void Filldetails() throws IOException {
    	
    	///name.sendKeys(util.getTestData("name"));
    	name.sendKeys(util.ReadExcel(0, 1));
    	email.sendKeys("test@email.com");
    	phone.sendKeys("00000007");
    	maleCheckbox.click();
    	mondayCheckbox.click();
    	
    	Select select=new Select(CountryDropdown);
    	select.selectByVisibleText("India");
    	
    	Datepicker.click();

    	for(WebElement date:datesselector)
    	if(date.getText().equals("15"))
    	{
    		date.click();
    		break;
    	}
    	
    	
    }
 }