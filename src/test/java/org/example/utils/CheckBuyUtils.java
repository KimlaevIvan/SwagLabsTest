package org.example.utils;

import com.microsoft.playwright.Page;

public class CheckBuyUtils {
    public Page page;

    public CheckBuyUtils(Page page) {
        this.page = page;
    }

    public void CheckBuy(int numPurch, String buttonBuy) {
        String targetText = "Add to cart";
        int count = 0;
        for (int i = 1; i < 6; i++) {
            if (count < numPurch) {
                String textButton = page.locator(String.format(buttonBuy, i)).textContent();
                if (targetText.equals(textButton)) {
                    page.locator(String.format(buttonBuy, i)).click();
                    count++;
                }
            }
        }
    }
}
