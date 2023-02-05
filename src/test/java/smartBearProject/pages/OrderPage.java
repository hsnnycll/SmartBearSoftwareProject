package smartBearProject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class OrderPage extends BasePage{

    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    WebElement productSelectElement;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    WebElement quantityInputBox;

    @FindBy(xpath = "//input[@value='Calculate']")
    WebElement calculateButton;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtTotal")
    WebElement totalBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    WebElement customerNameInputBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    WebElement streetInputBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    WebElement cityInputBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    WebElement stateInputBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    WebElement zipCodeInputBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    WebElement visaCheckBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_1")
    WebElement masterCardCheckBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_2")
    WebElement americanExpressCheckBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    WebElement cardNumberInputBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    WebElement expireDateInputBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    WebElement processButton;

    @FindBy(xpath = "//input[@value='Reset']")
    WebElement resetButton;

    @FindBy(xpath = "//a[normalize-space()='View all orders']")
    WebElement viewAllOrdersButton;

    public void selectProductType(String productName){
        Select select = new Select(productSelectElement);
        select.selectByVisibleText(productName);
    }

    public void setQuantityInputBox(String quantity){
        quantityInputBox.sendKeys(quantity);
    }

    public String getTotalValue(){
        return totalBox.getAttribute("value");
    }

    public void clickCalculateButton(){
        calculateButton.click();
    }

    public void enterAddressInformation(String customerName, String street, String city, String state, String zip) {
        customerNameInputBox.sendKeys(customerName);
        streetInputBox.sendKeys(street);
        cityInputBox.sendKeys(city);
        stateInputBox.sendKeys(state);
        zipCodeInputBox.sendKeys(zip);
    }

    public void setPaymentInformation(String card, String cardNumber, String expirationDate){
        if (card.equalsIgnoreCase("visa")){
            visaCheckBox.click();
        }else if (card.equalsIgnoreCase("master card")){
            masterCardCheckBox.click();
        }else{
            americanExpressCheckBox.click();
        }
        cardNumberInputBox.sendKeys(cardNumber);
        expireDateInputBox.sendKeys(expirationDate);
    }

    public void clickProcessButton(){
        processButton.click();
    }

    public void clickViewAllProductsButton(){
        viewAllOrdersButton.click();
    }
}
