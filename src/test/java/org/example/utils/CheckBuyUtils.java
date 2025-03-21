package org.example.utils;

import com.microsoft.playwright.Page;

public class CheckBuyUtils {
    public Page page;

    public CheckBuyUtils(Page page){this.page=page;}
    public void CheckBuy(int NumPurch,String ButtonBuy) {
        String targetText = "Add to cart";
        int count = 0;
        for (int i = 1; i < 6; i++) {
            if (count < NumPurch) {
                String textButton = page.locator(String.format(ButtonBuy, i)).textContent();
                if (targetText.equals(textButton)) {
                    page.locator(String.format(ButtonBuy, i)).click();
                    count++;
                }
            }
        }
    }
}
