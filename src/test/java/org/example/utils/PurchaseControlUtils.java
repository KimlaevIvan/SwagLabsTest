package org.example.utils;

import com.microsoft.playwright.Page;

public class PurchaseControlUtils {
    private Page page;

    public PurchaseControlUtils(Page page) {
        this.page = page;
    }

    public int priceControlMax(String PriceCart) {
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

    public int priceControlMin(String PriceCart) {
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


}
