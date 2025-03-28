package org.example.model;

import com.microsoft.playwright.Page;

import java.util.Map;

public class CheckoutPage {
    private Page page;

    public CheckoutPage(Page page) {
        this.page = page;
    }

    private Map<String, String> inputMap = Map.of(
            "First Name", "(//div[@class='form_group']//input)[1]",
            "Last Name", "(//div[@class='form_group']//input)[2]",
            "Postal Code", "(//div[@class='form_group']//input)[3]"
    );

    private String continueButton = "//input[@id='continue']";
    private String finishButton = "//button[@id='finish']";

    public void fillInputCheckoutInput(String inputName,String value) {
        page.locator(inputMap.get(inputName)).fill(value);
    }


    public void clickButtonContinue() {
        page.click(continueButton);
    }

    public void clickButtonFinish() {
        page.click(finishButton);
    }

}
