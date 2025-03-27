package org.example.steps;

import io.cucumber.java.bg.И;
import io.cucumber.java.en.When;
import org.example.AppTest;
import org.example.model.CardPage;
import org.example.model.LoginPage;
import org.example.model.ShopPage;


public class MainSteps {
    private int cartItems;
    private AppTest appTest;

    public MainSteps() {
        appTest = new AppTest();
    }

    @И("зайти в систему как \"standard_user\"")
    public void userLoginPage(String username) {
        LoginPage loginPage = new LoginPage(appTest.getPage());
        loginPage.login(username);
    }

    @И("добавить в корзину {int} самых дешовых товара")
    public void userAddProductToCartLoHi(int cartItems) {
        ShopPage shopPage = new ShopPage(appTest.getPage());
        shopPage.clickLoHiButtonSort(cartItems);
    }

    @И("добавить в корзину {int} самых дорогих товара")
    public void userAddProductCartHiLo(int cartItems) {
        ShopPage shopPage = new ShopPage(appTest.getPage());
        shopPage.clickHiLoButtonSort(cartItems);
    }

    @И("нажать на \"корзина\"")
    public void userClickButtonShop() {
        ShopPage shopPage = new ShopPage(appTest.getPage());
        shopPage.clickShoppingCartButton();
    }

    @И("убрать из корозины самый дорогой товар")
    public void userDeleteHiProduct() {
        CardPage cardPage = new CardPage(appTest.getPage());
        cardPage.deleteHiProduct();
    }

    @И("убрать из корозины самый дешевый товар")
    public void userDeleteLoProduct() {
        CardPage cardPage = new CardPage(appTest.getPage());
        cardPage.deleteLoProduct();
    }

    @И("нажать на \"Checkout\"")
    public void userClickButtonCheckout() {
        CardPage cardPage = new CardPage(appTest.getPage());
        cardPage.clickButtonCheckout();
    }

    @И("ввести в поле \"First Name\" данными \"Иван\"")

    @И("ввести в поле \"Last Name\" данными \"Иванов\"")

    @И("ввести в поле \"Postal Code\" данными \"00000000\"")


    @И("нажать на \"Continue\"")
    public void userClickButtonContinue() {

    }

    @И("нажать на \"Finish\"")
    public void userClickButtonFinish() {

    }

    @И("проверить, что открылась страница \"Успешная покупка\"")
    public void CheckFinishPage() {

    }
}


