package org.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.microsoft.playwright.*;
import org.example.model.*;
import org.junit.jupiter.api.*;

public class AppTest {
    private Playwright playwright;
    private Browser browser;
    private Page page;

    @BeforeEach
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        page.navigate("https://www.saucedemo.com/");
    }

    @AfterEach
    public void tearDown() {
        if (page != null) {
            page.close();
        }
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }

    @Test
    public void testMailRu() {
        try {
            LoginPage entrance = new LoginPage(page);
            entrance.login();
            ShopPage purchase = new ShopPage(page);
            purchase.Shopping();
            CardPage cardPage =new CardPage(page);
            cardPage.CheckBuy();
            CheckoutPage checkoutPage = new CheckoutPage(page);
            checkoutPage.information();
            FinishPage finishPage = new FinishPage();
            //finishPage.CheckingImg();

            page.waitForTimeout(3000);
        } catch (PlaywrightException e) {
            System.out.println("Interaction error: " + e.getMessage());
        }
    }
}