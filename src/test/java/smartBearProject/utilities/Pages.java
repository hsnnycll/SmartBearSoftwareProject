package smartBearProject.utilities;

import smartBearProject.pages.LoginPage;
import smartBearProject.pages.OrderPage;
import smartBearProject.pages.WebOrdersPage;

public class Pages {

    private LoginPage loginPage;
    private WebOrdersPage webOrdersPage;
    private OrderPage orderPage;


    public Pages(){
        this.loginPage = new LoginPage();
        this.webOrdersPage = new WebOrdersPage();
        this.orderPage = new OrderPage();
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public WebOrdersPage getWebOrdersPage() {
        return webOrdersPage;
    }

    public OrderPage getOrderPage() {
        return orderPage;
    }
}
