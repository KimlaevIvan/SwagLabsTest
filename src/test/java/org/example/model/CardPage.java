package org.example.model;

import com.microsoft.playwright.Page;
import org.example.utils.ParseUtils;

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

    private int priceControlMax(String PriceCart) {
        float prise;
        float max_price = 0;
        int index_max = 0;
        for (int i = 1; i <= 6; i++) {
            prise = Float.parseFloat(ParseUtils.pars("money", page.textContent(String.format(PriceCart, i))));
            if (prise > max_price) {
                max_price = prise;
                index_max = i;
            }
        }
        return index_max;
    }

    private int priceControlMin(String PriceCart) {
        float prise;
        float min_price = 1000;
        int index_min = 0;
        for (int i = 1; i <= 5; i++) {
            prise = Float.parseFloat(ParseUtils.pars("money", page.textContent(String.format(PriceCart, i))));
            if (prise < min_price) {
                min_price = prise;
                index_min = i;
            }
        }
        return index_min;
    }

    public void deleteHiProduct() {page.click(String.format(locatorMap.get("Price Card"),priceControlMax(locatorMap.get("Price Cart"))));}

    public void deleteLoProduct() {page.click(String.format(locatorMap.get("Button Buy Cart"),priceControlMin(locatorMap.get("Price Cart"))));}

    public void clickButtonCheckout(String value) {
        page.click(locatorMap.get(value));
    }
}
