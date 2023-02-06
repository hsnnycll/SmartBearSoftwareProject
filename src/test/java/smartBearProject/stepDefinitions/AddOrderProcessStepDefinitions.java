package smartBearProject.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import smartBearProject.utilities.ReadExcel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddOrderProcessStepDefinitions extends BaseStep{

    SoftAssert softAssert = new SoftAssert();
    HashMap<String, String> excelData;


    @Given("the user navigates to order page")
    public void user_navigates_to_order_page(){
        pages.getWebOrdersPage().clickOrderButton();
    }

    @When("the user enters product information:")
    public void user_enters_product_information(List<Map<String, String>> dataTable){
        Map<String, String> values = dataTable.get(0);
        pages.getOrderPage().selectProductType(values.get("Product"));
        pages.getOrderPage().setQuantityInputBox(values.get("Quantity"));
    }

    @When("the user click on calculate button")
    public void user_click_on_calculate_button(){
        pages.getOrderPage().clickCalculateButton();
    }

    @Then("the user should verify that total {int} is displayed")
    public void user_should_verify_that_total_is_displayed(int totalValue){
        softAssert.assertEquals(totalValue, pages.getOrderPage().getTotalValue());
    }

    @When("the user enters address information:")
    public void user_enters_address_information(List<Map<String, String>> dataTable){
        Map<String, String> values = dataTable.get(0);
        pages.getOrderPage().enterAddressInformation(
                values.get("Customer Name"),
                values.get("Street"),
                values.get("City"),
                values.get("State"),
                values.get("Zip"));
    }

    @When("the user enters payment information:")
    public void user_enters_payment_information(List<Map<String, String>> dataTable){
        Map<String, String> paymentInfo = dataTable.get(0);
        pages.getOrderPage().setPaymentInformation(
                paymentInfo.get("Card"),
                paymentInfo.get("Card Nr:"),
                paymentInfo.get("Expire date (mm/yy)"));
    }

    @When("the user click on process button")
    public void user_click_on_process_button(){
        pages.getOrderPage().clickProcessButton();
    }

    @Then("the user navigates to View all orders page")
    public void user_navigates_to_view_all_orders_page(){
        pages.getOrderPage().clickViewAllProductsButton();
    }

    @When("the user enters product information: Product {string}, Quantity {string}")
    public void user_enters_product_information_Product_Quantity(String product, String quantity){
        pages.getOrderPage().selectProductType(product);
        pages.getOrderPage().setQuantityInputBox(quantity);
    }

    @When("the user enters address information: Customer Name {string}, Street {string}, City {string}, State {string}, Zip {string}")
    public void user_enters_address_information(String customerName, String street, String city, String state, String zip) {
        pages.getOrderPage().enterAddressInformation(customerName, street, city, state, zip);
    }

    @When("the user enters payment information: Card {string}, Card Number {string}, Expire Date {string}")
    public void user_enters_payment_information(String card, String cardNumber, String expireDate) {
        pages.getOrderPage().setPaymentInformation(card, cardNumber, expireDate);
    }

    @Given("the user wants to tests the scenario {string} by retrieving the test data from Excel Workbook : {string} Sheet : {string}")
    public void user_wants_to_test_scenario_by_retrieving_test_data_from_Excel(String testCase, String excelWorkbook, String sheetName){
        ReadExcel readExcel = new ReadExcel();
        try {
            excelData = readExcel.getDataFromExcel(testCase, excelWorkbook, sheetName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @When("the user enters product information")
    public void user_enters_product_information_from_excel(){
        String productValue = excelData.get("Product");
        String quantityValue = excelData.get("Quantity");
        pages.getOrderPage().selectProductType(productValue);
        pages.getOrderPage().setQuantityInputBox(quantityValue);
    }

    @When("the user enters address and payment information")
    public void user_enters_address_and_payment_information(){
        pages.getOrderPage().enterAddressInformation(
                excelData.get("CustomerName"),
                excelData.get("Street"),
                excelData.get("City"),
                excelData.get("State"),
                excelData.get("Zip"));

        pages.getOrderPage().setPaymentInformation(
                excelData.get("Card"),
                excelData.get("CardNumber"),
                excelData.get("ExpireDate"));
    }

    @Then("the user should verify that total is displayed")
    public void user_should_verify_that_total_is_displayed(){
        softAssert.assertEquals(excelData.get("Total"), pages.getOrderPage().getTotalValue());
    }
}
