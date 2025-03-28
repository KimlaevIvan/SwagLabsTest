package org.example.steps;

import io.cucumber.java.bg.И;
import io.cucumber.java.en.When;
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

    @И("нажать на \"Корзина\"")
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

    @И("ввести в поле {string} данными {string}")
    public void userFillInfoInputFirstName(String nameInput, String testText) {
        CheckoutPage checkoutPage = new CheckoutPage(appTest.getPage());
        checkoutPage.fillInputCheckoutInput(nameInput, testText);
    }

    @И("ввести в поле {string} данными {string}")
    public void userFillInfoInputSecondName(String nameInput, String testText) {
        CheckoutPage checkoutPage = new CheckoutPage(appTest.getPage());
        checkoutPage.fillInputCheckoutInput(nameInput, testText);
    }

    @И("ввести в поле \"{string}\" данными \"{string}\"")
    public void userFillInfoPostalCode(String nameInput, String testText) {
        CheckoutPage checkoutPage = new CheckoutPage(appTest.getPage());
        checkoutPage.fillInputCheckoutInput(nameInput, testText);
    }

    @И("нажать на \"Continue\"")
    public void userClickButtonContinue() {
        CheckoutPage checkoutPage = new CheckoutPage(appTest.getPage());
        checkoutPage.clickButtonContinue();
    }

    @И("нажать на \"Finish\"")
    public void userClickButtonFinish() {
        CheckoutPage checkoutPage = new CheckoutPage(appTest.getPage());
        checkoutPage.clickButtonFinish();
    }

    @И("проверить, что открылась страница \"Успешная покупка\"")
    public void CheckFinishPage() {
        FinishPage finishPage = new FinishPage(appTest.getPage());
        finishPage.checkPage();
    }
}


