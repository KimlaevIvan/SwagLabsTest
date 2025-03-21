package org.example.utils;

import com.microsoft.playwright.Page;

public class PurchaseControlUtils {
    private Page page;
    public PurchaseControlUtils(Page page){this.page=page;}

    public void PriceControl(String PriceCart, String ButtonCart){
        float prise;
        float max_price = 0;
        float min_price = 1000;
        int index_max = 0;
        int index_min = 0;
        for (int i = 1; i <= 6; i++) {
            prise = Float.parseFloat(ParseUtils.Pars("money", page.textContent(String.format(PriceCart, i))));
            if (prise > max_price) {
                max_price = prise;
                index_max = i;
            }
            if(prise < min_price){
                min_price = prise;
                index_min = i;
            }
        }
        index_min = index_min >  index_max ? index_min - 1 : index_min;
        page.waitForTimeout(3000);
        page.click(String.format(ButtonCart, index_max));
        page.click(String.format(ButtonCart, index_min));

    }
}
