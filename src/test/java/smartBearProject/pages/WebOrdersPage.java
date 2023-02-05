package smartBearProject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import smartBearProject.utilities.Driver;

public class WebOrdersPage extends BasePage{

    @FindBy(xpath = "//div[@class='login_info']")
    WebElement welcomeMessageElement;

    @FindBy(xpath = "//h1")
    WebElement headerOfPageElement;

    @FindBy(xpath = "//a[normalize-space()='View all orders']")
    WebElement viewAllOrdersButton;

    @FindBy(xpath = "//a[normalize-space()='View all products']")
    WebElement viewAllProductsButton;

    @FindBy(xpath = "//a[normalize-space()='Order']")
    WebElement orderButton;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement logoutButton;

    public String getCurrentURL(){
        return Driver.getDriver().getCurrentUrl();
    }

    public String getWelcomeMessageText(){
        return welcomeMessageElement.getText();
    }

    public String getHeaderOfPage(){
        return headerOfPageElement.getText();
    }

    public boolean isVerticalMenuItemsDisplayed(String itemName){
        boolean result = false;
        switch (itemName){
            case "View all orders":
                result = viewAllOrdersButton.isDisplayed();
                break;
            case "View all products":
                result = viewAllProductsButton.isDisplayed();
                break;
            case "Order":
                result = orderButton.isDisplayed();
                break;
            default:
                System.out.println("Wrong Item Name");
                break;
        }
        return result;
    }

    public void clickLogoutButton(){
        logoutButton.click();
    }

    public void clickOrderButton(){
        orderButton.click();
    }

}
