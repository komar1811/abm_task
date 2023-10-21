package org.example.services;

import org.example.pageobject.pages.LoginPage;
import org.example.utils.PropertiesReader;
import org.example.utils.SoftAssertion;

import static org.hamcrest.Matchers.is;

public class LoginPageService {

    private final LoginPage loginPage = new LoginPage();

    public MainPageService login(String login, String password){
        loginPage.login(login, password);
        return new MainPageService();
    }

    public LoginPageService fakeLogin(){
        loginPage.login("bad login", "bad password");
        return this;
    }

    public LoginPageService verifyLoginPageIsOpened(){
        SoftAssertion.assertThat("Check Login Page link", () -> loginPage.checkPageLink().equals(PropertiesReader.readUrlProperty("loginUrl")), is(true));
        SoftAssertion.assertThat("Check if Login Page is opened", loginPage::checkPageTitleIsDisplayed, is(true));
        return this;
    }

    public LoginPageService verifyErrorMessage(){
        SoftAssertion.assertThat("Check if Error Message is displayed",
                loginPage::checkErrorMessageIsDisplayed, is(true));
        SoftAssertion.assertThat("Check if Error Message content equals expected",
                () -> loginPage.checkErrorMessageTextContainsPattern("Email or password is incorrect"), is(true));
        return this;
    }
}
