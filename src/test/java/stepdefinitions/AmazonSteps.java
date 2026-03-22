package stepdefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import base.TestBase;
import io.cucumber.java.en.*;
import pages.AmazonHomePage;
import utils.CommonUtils;

public class AmazonSteps extends TestBase {
    AmazonHomePage homePage;

    @Given("user launches the browser")
    public void user_launches_the_browser() throws FileNotFoundException {
    	String Browser=CommonUtils.getTestData("browser");
        TestBase.initialization(Browser);
        homePage = new AmazonHomePage();
    }

    @And("user navigates to {string}")
    public void user_navigates_to(String url) {
        driver.get(url);
    }

    @When("user searches for {string}")
    public void user_searches_for(String product) {
        homePage.searchForProduct(product);
    }
    @Then("search results should be displayed and prize displayed for iphone15pro")
    public void search_results_should_be_displayed() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
       // driver.quit();
    	 homePage.selectProduct();
    }
    @Then("user searches for {string} prize printed")
    public void user_searches_and_Prize(String product) throws InterruptedException, IOException {
        homePage.searchForProductnew(product);
    }

    @Then("user verified API Get status")
    public void user_verified_api() {
        homePage.verifyAPIGet();
    }
}