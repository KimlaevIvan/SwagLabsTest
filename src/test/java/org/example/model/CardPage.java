package org.example.model;

import com.microsoft.playwright.Page;
import org.example.utils.ParseUtils;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.IntStream;

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
        return IntStream.rangeClosed(1, 6)
                .mapToObj(i -> new AbstractMap.SimpleEntry<>(i, Float.parseFloat(ParseUtils.pars("money", page.textContent(String.format(PriceCart, i))))))
                .max(Comparator.comparing(AbstractMap.SimpleEntry::getValue))
                .map(AbstractMap.SimpleEntry::getKey)
                .orElse(0);
    }

    private int priceControlMin(String PriceCart) {
        return IntStream.rangeClosed(1, 5)
                .mapToObj(i -> new AbstractMap.SimpleEntry<>(i, Float.parseFloat(ParseUtils.pars("money", page.textContent(String.format(PriceCart, i))))))
                .min(Comparator.comparing(AbstractMap.SimpleEntry::getValue))
                .map(AbstractMap.SimpleEntry::getKey)
                .orElse(0); // Если поток пустой, возвращаем 0
    }

    public void deleteHiProduct() {page.click(String.format(locatorMap.get("Price Card"),priceControlMax(locatorMap.get("Price Cart"))));}

    public void deleteLoProduct() {page.click(String.format(locatorMap.get("Button Buy Cart"),priceControlMin(locatorMap.get("Price Cart"))));}

    public void clickButtonCheckout(String value) {
        page.click(locatorMap.get(value));
    }
}
