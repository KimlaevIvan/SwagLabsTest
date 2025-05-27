package org.example.steps;

import cucumber.api.java.bg.И;
import cucumber.api.java.en.When;
import org.example.AppTest;
import org.example.model.*;


public class MainSteps {
    private int cartItems;
    private AppTest appTest;

    public MainSteps() {
        appTest = new AppTest();
    }

    @И("зайти в систему как {string}")
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

    @И("нажать на {string} на странице магазина")
    public void userClickButtonShop(String button) {
        ShopPage shopPage = new ShopPage(appTest.getPage());
        shopPage.clickButton(button);
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

    @И("нажать на {string} на странице корзины")
    public void userClickButtonCheckout(String buttonName) {
        CardPage cardPage = new CardPage(appTest.getPage());
        cardPage.clickButton(buttonName);
    }

    @И("ввести в поле {string} данными {string}")
    public void userFillInfoInputFirstName(String nameInput, String testText) {
        CheckoutPage checkoutPage = new CheckoutPage(appTest.getPage());
        checkoutPage.fillInputCheckoutInput(nameInput, testText);
    }

    @И("нажать на {string}")
    public void userClickButtonContinue(String buttonName) {
        CheckoutPage checkoutPage = new CheckoutPage(appTest.getPage());
        checkoutPage.clickButton(buttonName);
    }

    @И("проверить, что открылась страница \"Успешная покупка\"")
    public void CheckFinishPage() {
        FinishPage finishPage = new FinishPage(appTest.getPage());
        finishPage.checkPage();
    }
}


