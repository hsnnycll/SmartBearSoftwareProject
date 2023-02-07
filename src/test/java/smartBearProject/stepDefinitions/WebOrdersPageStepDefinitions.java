package smartBearProject.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import smartBearProject.utilities.BrowserUtils;

public class WebOrdersPageStepDefinitions extends BaseStep{
    SoftAssert softAssert = new SoftAssert();

    @Given("the user is on the web orders page")
    public void user_is_on_the_web_orders_page(){
        BrowserUtils.wait(1);
        softAssert.assertEquals(pages.getWebOrdersPage().getCurrentURL(), "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");
    }

    @Given("the user logged in with valid credentials, {string} as username and {string} as password")
    public void user_logged_in_with_valid_credentials(String usernameValue, String passwordValue){
        pages.getLoginPage().setUsernameInputBox(usernameValue);
        pages.getLoginPage().setPasswordInputBox(passwordValue);
        pages.getLoginPage().clickLoginButton();
    }

    @Then("the user views the header is displayed as {string}")
    public void user_views_the_header_is_displayed(String expectedHeader){
        softAssert.assertEquals(pages.getWebOrdersPage().getHeaderOfPage(), expectedHeader);
    }

    @Then("the user should be able to see {string} section in vertical menu")
    public void user_should_be_able_to_see_items_in_vertical_menu(String itemName){
        softAssert.assertTrue(pages.getWebOrdersPage().isVerticalMenuItemsDisplayed(itemName));
    }

    @When("the user clicks on the logout button")
    public void user_clicks_on_the_logout_button(){
        pages.getWebOrdersPage().clickLogoutButton();
    }

    @Then("the user logs out and navigates to the login page")
    public void user_navigates_to_login_page(){
        softAssert.assertEquals(pages.getWebOrdersPage().getCurrentURL(), "http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");
    }
}
