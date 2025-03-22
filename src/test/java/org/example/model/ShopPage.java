package org.example.model;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.utils.CheckBuyUtils;

public class ShopPage {

    private  Page page;
    public ShopPage (Page page){this.page=page;}
    public int NumPurch = 3 ;
    private String ShoppingCartButton = "//div[@id='shopping_cart_container']/a";
    public String SortButton = "//select[@class='product_sort_container']";
    public String ButtonBuy = "(//div[@id='inventory_container'][1]//button)[%d]";
    private void clickShoppingCartButton (){page.click(ShoppingCartButton);}

    public void  clickHiLoButtonSort(){
        Locator sort = page.locator(SortButton);
        CheckBuyUtils buy = new CheckBuyUtils(page);
        sort.click();
        sort.selectOption("hilo");
        buy.CheckBuy(NumPurch,ButtonBuy);
    }
    private void clickLoHiButtonSort(){
        Locator sort = page.locator(SortButton);
        CheckBuyUtils buy = new CheckBuyUtils(page);
        sort.click();
        sort.selectOption("lohi");
        buy.CheckBuy(NumPurch,ButtonBuy);
    }
    public void Shopping(){
        clickHiLoButtonSort();
        clickLoHiButtonSort();
        clickShoppingCartButton();
    }
}
