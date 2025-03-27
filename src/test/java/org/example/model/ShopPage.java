package org.example.model;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.utils.CheckBuyUtils;
import org.example.utils.PurchaseControlUtils;

public class ShopPage {

    private Page page;

    public ShopPage(Page page) {
        this.page = page;
    }

    private String shoppingCartButton = "//div[@id='shopping_cart_container']/a";
    public String sortButton = "//select[@class='product_sort_container']";
    public String buttonBuy = "(//div[@id='inventory_container'][1]//button)[%d]";

    public void clickShoppingCartButton() {
        page.click(shoppingCartButton);
    }

    public void clickHiLoButtonSort(int numPurch) {
        Locator sort = page.locator(sortButton);
        CheckBuyUtils buy = new CheckBuyUtils(page);
        sort.click();
        sort.selectOption("hilo");
        buy.CheckBuy(numPurch, buttonBuy);
    }

    public void clickLoHiButtonSort(int numPurch) {
        Locator sort = page.locator(sortButton);
        CheckBuyUtils buy = new CheckBuyUtils(page);
        sort.click();
        sort.selectOption("lohi");
        buy.CheckBuy(numPurch, buttonBuy);
    }


}
