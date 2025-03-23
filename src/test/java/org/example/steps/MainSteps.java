package org.example.steps;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.example.AppTest;
import org.example.model.LoginPage;
import org.example.model.ShopPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "ru.savkk.test",
        tags = "@all",
        dryRun = false,
        strict = false,
        snippets = SnippetType.UNDERSCORE,
        name = "^Успешное|Успешная.*"
)

public class MainSteps {
    private int cartItems;
    private AppTest appTest;
    public MainSteps(){appTest = new AppTest();}

    public void userNavigatesToHomePage(){
        appTest.setUp();
    }

    public void userLogsIn(){
        LoginPage loginPage = new LoginPage(appTest.getPage());
        loginPage.login();
    }

    public void userAddProductToCartHiLo(){
        ShopPage shopPage = new ShopPage(appTest.getPage());
        shopPage.clickHiLoButtonSort();
    }

    public void userAddProductToCartLoHi(){
        ShopPage shopPage = new ShopPage(appTest.getPage());
        shopPage.clickHiLoButtonSort();
    }

    public void checkSumBuy(){

    }
}
