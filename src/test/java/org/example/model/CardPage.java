package org.example.model;

import com.microsoft.playwright.Page;
import org.example.utils.PurchaseControlUtils;

public class CardPage {
    private Page page;
    public CardPage(Page page){this.page=page;}

    public String PriceCart ="(//div[@id='cart_contents_container']//div[@class='inventory_item_price'])[%d]";
    public String ButtonCart ="(//div[@id='cart_contents_container']//button[text()='Remove'])[%d]";
    private String ButtonCheckout = "//button[@id='checkout']" ;
    public void clickButtonCheckout(){page.click(ButtonCheckout);}
    public void CheckBuy(){
        PurchaseControlUtils purchaseControlUtils=new PurchaseControlUtils(page);
        purchaseControlUtils.PriceControl(PriceCart, ButtonCart);
        page.waitForTimeout(3000);
        clickButtonCheckout();
    }
}
