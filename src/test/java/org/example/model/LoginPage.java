package org.example.model;

import com.microsoft.playwright.Page;

import java.util.Map;

public class LoginPage {
    private Page page;

    public  LoginPage(Page page){
        this.page=page;
    }

    private Map<String,String> inputMap =  Map.of(
            "Логин","//input[@id='user-name']",
            "Пароль","//input[@id='password']"
    );

    private String loginButton = "//input[@id='login-button']";

    public void clickLoginButton(){
        page.click(loginButton);
    }
    public void fillInput(String inputName,String value){
        page.locator(inputMap.get(inputName)).fill(value);
    }

    public void login (String username,String password){
        fillInput("Логин",username);
        fillInput("Пароль",password);
        clickLoginButton();
    }
}
