package org.example.pageobject.pages.company_settings_tabs;

import com.codeborne.selenide.SelenideElement;
import org.example.pageobject.pages.CompanySettingsPage;

import static com.codeborne.selenide.Selenide.$x;

public class ExchangeTabPage extends CompanySettingsPage {

    private final SelenideElement hostField = $x("//input[@name=\"exchange_storage[host]\"]");
    private final SelenideElement portField = $x("//input[@name=\"exchange_storage[port]\"]");
    private final SelenideElement loginField = $x("//input[@name=\"exchange_storage[login]\"]");
    private final SelenideElement passwordField = $x("//input[@name=\"exchange_storage[password]\"]");
    private final SelenideElement thresholdField = $x("//input[@name=\"exchange_storage[threshold]\"]");
    private final SelenideElement submitButton = $x("//input[@name=\"commit\"]");
    private final SelenideElement exchangeUpdatedNotification = $x("//div[@class=\"ng-alert alert fade in alert-success\"]");

    public void createExchange(String host, String port, String login, String password, String threshold){
        hostField.setValue(host);
        portField.setValue(port);
        loginField.setValue(login);
        passwordField.setValue(password);
        thresholdField.setValue(threshold);
        submitButton.click();
    }

    public boolean checkExchangeUpdatedNotificationDisplayed(){
        return exchangeUpdatedNotification.isDisplayed();
    }

    public boolean checkExchangeSettings(String host, String port, String login, String password, String threshold){
        return hostField.getAttribute("value").contains(host)
                && portField.getAttribute("value").contains(port)
                && loginField.getAttribute("value").contains(login)
                && passwordField.getAttribute("value").contains(password)
                && thresholdField.getAttribute("value").contains(threshold);
    }
}
