package org.example.pageobject.pages;

import com.codeborne.selenide.SelenideElement;
import org.example.pageobject.BasePage;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {


    private final SelenideElement loginField = $x("//input[@name='user[email]']");
    private final SelenideElement passwordField = $x("//input[@name='user[password]']");
    private final SelenideElement submitButton = $x("//input[@name='commit']");
    private final SelenideElement pageTitle = $x("//h2[contains(text(),\"Log in\")]");
    private final SelenideElement errorMessage = $x("//div[@class=\"text-danger\"]");

    public void login(String login, String password){
        loginField.setValue(login);
        passwordField.setValue(password);
        submitButton.click();
    }

    public boolean checkPageTitleIsDisplayed(){
        return pageTitle.isDisplayed();
    }

    public boolean checkErrorMessageIsDisplayed(){
        return errorMessage.isDisplayed();
    }

    public String getErrorMessage(){
        return errorMessage.getOwnText();
    }

    public boolean checkErrorMessageTextContainsPattern(String pattern){
        return getErrorMessage().contains(pattern);
    }
}
