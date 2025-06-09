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
            "priceCart","(//div[@class='inventory_item_price'])[%d]",
            "buttonBuyCart ","(//button[text()='Remove'])[%d]",
            "Checkout","//button[@id='checkout']"
    );

    private int priceControlMax(String PriceCart) {
        ParseUtils parseUtils = new ParseUtils();
        return IntStream.rangeClosed(1, 6)
                .mapToObj(i -> new AbstractMap.SimpleEntry<>(i, Float.parseFloat(parseUtils.pars("money", page.textContent(String.format(PriceCart, i))))))
                .max(Comparator.comparing(AbstractMap.SimpleEntry::getValue))
                .map(AbstractMap.SimpleEntry::getKey)
                .orElse(0);
    }

    private int priceControlMin(String PriceCart) {
        ParseUtils parseUtils = new ParseUtils();
        return IntStream.rangeClosed(1, 5)
                .mapToObj(i -> new AbstractMap.SimpleEntry<>(i, Float.parseFloat(parseUtils.pars("money", page.textContent(String.format(PriceCart, i))))))
                .min(Comparator.comparing(AbstractMap.SimpleEntry::getValue))
                .map(AbstractMap.SimpleEntry::getKey)
                .orElse(0); // Если поток пустой, возвращаем 0
    }

    public
        void deleteHiProduct() {
        int i = priceControlMax(locatorMap.get("priceCart"));
        page.click(String.format(locatorMap.get("buttonBuyCart"), i));
    }

    public void deleteLoProduct() {page.click(String.format(locatorMap.get("buttonBuyCart"), priceControlMin(locatorMap.get("priceCart"))));}

    public void clickButton(String value) {page.click(locatorMap.get(value));}
}
