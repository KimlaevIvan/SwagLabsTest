package org.example.model;

import com.microsoft.playwright.Page;

import java.util.Map;

public class CheckoutPage {
    private Page page;

    public CheckoutPage(Page page) {
        this.page = page;
    }

    private Map<String, String> inputMap = Map.of(
            "Имя", "(//div[@class='form_group']//input)[1]",
            "Фамилия", "(//div[@class='form_group']//input)[2]",
            "Адрес", "(//div[@class='form_group']//input)[3]"
    );
    private Map<String, String> textMap = Map.of(
            "Имя", "Иван",
            "Фамилия", "Дмитрий",
            "Адрес", "Любовь"
    );
    private String continueButton = "//input[@id='continue']";
    private String finishButton = "//button[@id='finish']";

    public void fillInputCheckoutInput(String inputName) {
        page.locator(inputMap.get(inputName)).fill(textMap.get(inputName));
    }


    public void information() {
        fillInputCheckoutInput("Имя");
        fillInputCheckoutInput("Фамилия");
        fillInputCheckoutInput("Адрес");
        page.waitForTimeout(2000);
        page.click(continueButton);
        page.click(finishButton);
    }
}
