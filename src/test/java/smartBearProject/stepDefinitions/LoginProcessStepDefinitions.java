package smartBearProject.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import smartBearProject.utilities.BrowserUtils;
import smartBearProject.utilities.ConfigurationReader;
import smartBearProject.utilities.Driver;

public class LoginProcessStepDefinitions extends BaseStep{

    SoftAssert softAssert = new SoftAssert();

    @Given("the user is on the login page")
    public void user_is_on_the_login_page(){
        String URL = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(URL);
        BrowserUtils.wait(1);
    }

    @When("the user enters username {string}")
    public void user_enters_username(String usernameValue){
        pages.getLoginPage().setUsernameInputBox(usernameValue);
    }

    @When("the user enters password {string}")
    public void user_enters_password(String passwordValue){
        pages.getLoginPage().setPasswordInputBox(passwordValue);
    }

    @When("the user clicks on the login")
    public void user_clicks_loginButton(){
        pages.getLoginPage().clickLoginButton();
    }

    @Then("the user should be logged in")
    public void user_should_be_logged_in(){
        BrowserUtils.wait(1);
        softAssert.assertEquals(pages.getWebOrdersPage().getCurrentURL(), "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");
    }

    @Then("the user arrives at the home page and welcome text containing the username {string}")
    public void user_arrives_at_home_page_and_can_see_welcome_text_containing_username(String enteredUsernameValue){
        softAssert.assertTrue(pages.getWebOrdersPage().getWelcomeMessageText().contains(enteredUsernameValue));
    }

    @Then("the user should not be able to login and see error message {string}")
    public void user_should_not_be_able_to_login_and_see_error_message(String errorMessage){
        softAssert.assertEquals(pages.getLoginPage().getErrorMessage(), errorMessage);
    }
}
