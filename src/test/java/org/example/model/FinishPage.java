package org.example.model;

import com.microsoft.playwright.Page;
import static org.junit.Assert.*;


public class FinishPage {
    private Page page;

    public FinishPage(Page page) {
        this.page = page;
    }

    private String pageUrl = "https://www.saucedemo.com/checkout-complete.html";

    public void checkPage() {assertEquals(pageUrl,page.url());}
}
