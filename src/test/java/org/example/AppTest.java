package org.example;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

public class AppTest {
    private Playwright playwright;
    private Browser browser;
    private Page page;

    @BeforeEach
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        page.navigate("https://www.saucedemo.com/");
    }

    @AfterEach
    public void tearDown() {
        if (page != null) {
            page.close();
        }
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }

    public String Pars(String regex,String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group();
        } else {
        return "text not found ";
        }
    }
    public void CheckBuy(int NumPurch) {
        String targetText= "Add to cart";
        int count=0;
        for (int i = 1; i < 6; i++) {
            if (count < NumPurch) {
                String textButton = page.locator(String.format("(//div[@id='inventory_container'][1]//button)[%d]", i)).textContent();
                if (targetText.equals(textButton)) {
                    page.locator(String.format("(//div[@id='inventory_container'][1]//button)[%d]", i)).click();
                    count++;
                }
            }
        }
    }

    @Test
    public void testMailRu() {
        try {
            int NumPurch=3;
            String user_names = page.locator("(//div[@id='login_credentials'])").textContent();
            String regex_user = "[a-zA-Z0-9]+(_user)";
            AppTest text = new AppTest();
            String user_name_login = text.Pars(regex_user,user_names);
            System.out.println(user_name_login);
            page.locator("//input[@id='user-name']").fill(user_name_login);

            String users_password = page.locator("//div[@class='login_password']").textContent();
            String regex_password = "[a-zA-Z0-9]+(_sauce)";
            String password = text.Pars(regex_password,users_password);
            System.out.println(password);

            page.locator("//input[@id='password']").fill(password);
            page.locator("//input[@id='login-button']").click();
            page.locator("//div[@class='right_component']").click();

            Locator sort = page.locator("//select[@class='product_sort_container']");
            sort.click();
            sort.selectOption("hilo");

            CheckBuy(NumPurch);

            sort.click();
            sort.selectOption("lohi");

            CheckBuy(NumPurch);

            page.locator("//div[@id='shopping_cart_container']/a").click();

            float prise;
            float max_price=0;
            float min_price=1000;
            int index_max=0;
            int index_min=0;
            String regex_price = "[0-9.]+";
            for (int i = 1; i <= 6; i++) {
                String priseTextPage = page.locator(String.format("(//div[@id='cart_contents_container']//div[@class='inventory_item_price'])[%d]",i)).textContent();
                prise = Float.parseFloat(text.Pars(regex_price,priseTextPage));
                if ( prise > max_price) {
                    max_price = prise;
                    index_max = i;
                }
                if (prise <min_price) {
                    min_price = prise;
                    index_min = i;
                }
            }
            if (index_min>index_max){
                index_min--;
            }

            page.locator(String.format("(//div[@id='cart_contents_container']//button[text()='Remove'])[%d]",index_max)).click();
            page.locator(String.format("(//div[@id='cart_contents_container']//button[text()='Remove'])[%d]",index_min)).click();
            page.waitForTimeout(10000);

            page.locator("//button[@id='checkout']").click();

            page.locator("(//div[@class='form_group']//input)[1]").fill("Ivan");
            page.locator("(//div[@class='form_group']//input)[2]").fill("Love");
            page.locator("(//div[@class='form_group']//input)[3]").fill("Dima");
            page.locator("//input[@id='continue']").click();

            page.locator("//button[@id='finish']").click();

            String imgUrl = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJAAAACQCAYAAADnRuK4AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyhpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDkuMC1jMDAwIDc5LmRhNGE3ZTVlZiwgMjAyMi8xMS8yMi0xMzo1MDowNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIDI0LjEgKE1hY2ludG9zaCkiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6QzQ4Q0IxMkVBRUZDMTFFREIwRThFMzc3OTlDRTMyNUIiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6QzQ4Q0IxMkZBRUZDMTFFREIwRThFMzc3OTlDRTMyNUIiPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDpDNDhDQjEyQ0FFRkMxMUVEQjBFOEUzNzc5OUNFMzI1QiIgc3RSZWY6ZG9jdW1lbnRJRD0ieG1wLmRpZDpDNDhDQjEyREFFRkMxMUVEQjBFOEUzNzc5OUNFMzI1QiIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/PojLpNEAABFkSURBVHja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";
            boolean img = page.locator("//img[@src='"+imgUrl+"']").count()>0;
            assertTrue(img,"image should be on the page");

            page.waitForTimeout(5000);
        } catch (PlaywrightException e) {
            System.out.println("Interaction error: " + e.getMessage());
        }
    }
}