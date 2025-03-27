package org.example.model;

import com.microsoft.playwright.Page;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FinishPage {
    private Page page;

    public FinishPage(Page page) {
        this.page = page;
    }

    public void сheckIMG() {
        String imgUrl = "";
        boolean img = page.locator("//img[@src='" + imgUrl + "']").count() > 0;
        assertTrue(img, "image should be on the page");
    }

    public void сheckingImg() {
        сheckIMG();
    }
}
