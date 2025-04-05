package org.example.model;

import com.microsoft.playwright.Page;
import org.example.utils.PurchaseControlUtils;
import java.util.Map;

public class CardPage {
    private Page page;

    public CardPage(Page page) {
        this.page = page;
    }

    private Map<String ,String> locatorMap = Map.of(
            "Price Cart","(//div[@id='cart_contents_container']//div[@class='inventory_item_price'])[%d]",
            "Button Buy Cart ","(//div[@id='cart_contents_container']//button[text()='Remove'])[%d]",
            "Checkout","//button[@id='checkout']"
    );

    public void deleteHiProduct() {
        PurchaseControlUtils purchaseControlUtils = new PurchaseControlUtils(page);
        page.click(String.format(locatorMap.get("Price Card"), purchaseControlUtils.priceControlMax(locatorMap.get("Price Cart"))));
    }

    public void deleteLoProduct() {
        PurchaseControlUtils purchaseControlUtils = new PurchaseControlUtils(page);
        page.click(String.format(locatorMap.get("Button Buy Cart"), purchaseControlUtils.priceControlMin(locatorMap.get("Price Cart"))));
    }

    public void clickButtonCheckout(String value) {
        page.click(locatorMap.get(value));
    }
}
