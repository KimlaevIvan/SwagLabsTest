package org.example.model;

import com.microsoft.playwright.Page;
import org.example.utils.PurchaseControlUtils;

public class CardPage {
    private Page page;

    public CardPage(Page page) {
        this.page = page;
    }

    public String priceCart = "(//div[@id='cart_contents_container']//div[@class='inventory_item_price'])[%d]";
    public String buttonCart = "(//div[@id='cart_contents_container']//button[text()='Remove'])[%d]";
    private String buttonCheckout = "//button[@id='checkout']";

    public void deleteHiProduct() {
        PurchaseControlUtils purchaseControlUtils = new PurchaseControlUtils(page);
        page.click(String.format(buttonCart, purchaseControlUtils.priceControlMax(priceCart)));
    }

    public void deleteLoProduct() {
        PurchaseControlUtils purchaseControlUtils = new PurchaseControlUtils(page);
        page.click(String.format(buttonCart, purchaseControlUtils.priceControlMin(priceCart)));
    }

    public void clickButtonCheckout() {
        page.click(buttonCheckout);
    }
}
