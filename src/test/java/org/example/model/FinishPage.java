package org.example.model;

import com.microsoft.playwright.Page;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class FinishPage {
    private Page page;

    public FinishPage(Page page) {
        this.page = page;
    }
    private String pageUrl = "https://www.saucedemo.com/checkout-complete.html";
    public void checkPage() {
        String currentUrl = page.url();
        assertEquals(pageUrl,currentUrl);
    }

}
