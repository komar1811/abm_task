package org.example;

import org.example.services.LoginPageService;
import org.example.utils.PropertiesReader;
import org.example.utils.SoftAssertion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainPageTest extends BaseTest {

    @Test
    @DisplayName("")
    public void checkCompanyCreate(){
        LoginPageService loginPageService = new LoginPageService();
        loginPageService.
                verifyLoginPageIsOpened()
                .login(PropertiesReader.readProperty("test_3_login"),
                        PropertiesReader.readProperty("test_3_password"))
                .verifyMainPageIsOpened()
                .clickAddCompany()
                .addCompany(PropertiesReader.readProperty("name"),
                        PropertiesReader.readProperty("system"))
                .verifyCompanyCreatedNotificationDisplayed()
                .openExchangeTab()
                .createExchange(PropertiesReader.readProperty("host"),
                        PropertiesReader.readProperty("port"),
                        PropertiesReader.readProperty("exchange_login"),
                        PropertiesReader.readProperty("exchange_password"),
                        PropertiesReader.readProperty("threshold"))
                .verifyExchangeUpdatedNotificationDisplayed()
                .goToMainPage()
                .goToFirstCompanySettings()
                .openExchangeTab()
                .verifyExchangeSettings(PropertiesReader.readProperty("host"),
                        PropertiesReader.readProperty("port"),
                        PropertiesReader.readProperty("exchange_login"),
                        PropertiesReader.readProperty("exchange_password"),
                        PropertiesReader.readProperty("threshold"))
                .openGeneralTab()
                .deleteCompany()
                .verifyCompanyDeleted();
        SoftAssertion.assertAll();
    }
}
