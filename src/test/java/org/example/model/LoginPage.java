package org.example.model;

import com.microsoft.playwright.Page;
import org.example.utils.ParseUtils;

import java.util.Map;

public class LoginPage {
    private Page page;

    public  LoginPage(Page page){
        this.page=page;
    }

    private Map<String,String> inputMap =  Map.of(
            "Username","//input[@id='user-name']",
            "Password","//input[@id='password']"
    );

    private String loginButton = "//input[@id='login-button']";

    public void clickLoginButton(){
        page.click(loginButton);
    }
    public void fillInput(String inputName,String value){
        page.locator(inputMap.get(inputName)).fill(value);
    }

    private String LoginParsUsername() {
        return ParseUtils.Pars("login",page.locator("(//div[@id='login_credentials'])").textContent());
    }
    private String LoginParsPassword() {
        return ParseUtils.Pars("password",page.locator("//div[@class='login_password']").textContent());
    }

    public void login (){
        String username = LoginParsUsername();
        fillInput("Username", username);
        String password=LoginParsPassword();
        fillInput("Password",password);
        clickLoginButton();
    }
}
