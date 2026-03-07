package stepdefinitions;

import java.io.IOException;

import base.TestBase;
import io.cucumber.java.en.*;
import pages.TestAutomation;

public class PracticeAutomation extends TestBase {
    TestAutomation testauto=new TestAutomation();

    @Then("User fills mandatory fields and submit")
    public void fillMandatoryFields() throws IOException {
        testauto.Filldetails();
    }
}