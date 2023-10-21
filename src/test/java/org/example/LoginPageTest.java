package org.example;

import org.example.services.LoginPageService;
import org.example.utils.PropertiesReader;
import org.example.utils.SoftAssertion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginPageTest extends BaseTest {

    @Test
    @DisplayName("Check if login is successful after putting correct credentials")
    public void testSuccessfulLogin(){
        LoginPageService loginPageService = new LoginPageService();
        loginPageService.
                verifyLoginPageIsOpened()
                .login(PropertiesReader.readProperty("login"),
                        PropertiesReader.readProperty("password"))
                .verifyMainPageIsOpened();
        SoftAssertion.assertAll();
    }

    @Test
    @DisplayName("Check if login is not successful after putting incorrect credentials")
    public void testNotSuccessfulLogin(){
        LoginPageService loginPageService = new LoginPageService();
        loginPageService.
                verifyLoginPageIsOpened()
                .fakeLogin()
                .verifyErrorMessage()
                .verifyLoginPageIsOpened();
        SoftAssertion.assertAll();
    }
}
