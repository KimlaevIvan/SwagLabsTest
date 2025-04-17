package org.example.model;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.utils.CheckBuyUtils;

public class ShopPage {

    private Page page;

    public ShopPage(Page page) {this.page = page;}

    private String shoppingCartButton = "//div[@id='shopping_cart_container']/a";
    public String sortButton = "//select[@class='product_sort_container']";
    public String buttonBuy = "(//div[@id='inventory_container'][1]//button)[%d]";

    public void clickShoppingCartButton() {page.click(shoppingCartButton);}

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

    public void clickHiLoButtonSort(int numPurch) {
        page.locator(sortButton).selectOption("hilo");
        CheckBuy(numPurch, buttonBuy);
    }

    public void clickLoHiButtonSort(int numPurch) {
        page.locator(sortButton).selectOption("lohi");
        CheckBuy(numPurch, buttonBuy);
    }


}
