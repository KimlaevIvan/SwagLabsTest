package org.example.model;

import com.microsoft.playwright.Page;

import java.util.Map;
import java.util.stream.IntStream;

public class ShopPage {

    private Page page;

    public ShopPage(Page page) {this.page = page;}

    private Map<String,String> inputMap =  Map.of(
            "shoppingCartButton", "//div[@id='shopping_cart_container']/a",
            "sortButton", "//select[@class='product_sort_container']",
            "buttonBuy", "(//div[@id='inventory_container'][1]//button)[%d]"
    );

    public void clickShoppingCartButton() {page.click(inputMap.get("buttonBuy"));}

    public void CheckBuy(int numPurch, String buttonBuy) {
        String targetText = "Add to cart";

        IntStream.range(1, 6)
                .filter(i -> page.locator(String.format(buttonBuy, i)).textContent().equals(targetText))
                .limit(numPurch)
                .forEach(i -> page.locator(String.format(buttonBuy, i)).click());
    }


    public void clickHiLoButtonSort(int numPurch) {
        page.locator(inputMap.get("sortButton")).selectOption("hilo");
        CheckBuy(numPurch, inputMap.get("buttonBuy"));
    }

    public void clickLoHiButtonSort(int numPurch) {
        page.locator(inputMap.get("sortButton")).selectOption("lohi");
        CheckBuy(numPurch, inputMap.get("buttonBuy"));
    }


}
