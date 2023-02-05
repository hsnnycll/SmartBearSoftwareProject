package smartBearProject.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import smartBearProject.utilities.ConfigurationReader;

public class LoginPage extends BasePage {

    @FindBy(id = "ctl00_MainContent_username")
    WebElement usernameInputBox;

    @FindBy(id = "ctl00_MainContent_password")
    WebElement passwordInputBox;

    @FindBy(id = "ctl00_MainContent_login_button")
    WebElement loginButton;

    @FindBy(id = "ctl00_MainContent_status")
    WebElement errorMessageElement;

    public void setUsernameInputBox(String username){
        usernameInputBox.sendKeys(username);
    }

    public void setPasswordInputBox(String password){
        passwordInputBox.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public String getErrorMessage(){
        return errorMessageElement.getText();
    }

    public void login(){
        String usernameValue = ConfigurationReader.getProperty("username");
        String passwordValue = ConfigurationReader.getProperty("password");
        usernameInputBox.sendKeys(usernameValue);
        passwordInputBox.sendKeys(passwordValue, Keys.ENTER);
    }
}
