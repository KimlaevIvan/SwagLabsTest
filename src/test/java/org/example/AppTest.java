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

    public Page getPage() {
        return page; // Метод для получения текущей страницы
    }

    @Test
    public void testMailRu() {
        try {

        } catch (PlaywrightException e) {
            System.out.println("Interaction error: " + e.getMessage());
        }
    }
}