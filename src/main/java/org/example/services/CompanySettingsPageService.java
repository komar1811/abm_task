package org.example.services;

import org.example.enums.TABS;
import org.example.pageobject.pages.CompanySettingsPage;
import org.example.pageobject.pages.company_settings_tabs.ExchangeTabPage;
import org.example.utils.PropertiesReader;
import org.example.utils.SoftAssertion;

import static org.hamcrest.Matchers.is;

public class CompanySettingsPageService {

    private final CompanySettingsPage companySettingsPage = new CompanySettingsPage();
    private final ExchangeTabPage exchangeTabPage = new ExchangeTabPage();

    public CompanySettingsPageService openExchangeTab(){
        companySettingsPage.clickTab(TABS.EXCHANGE);
        return this;
    }

    public CompanySettingsPageService openGeneralTab(){
        companySettingsPage.clickTab(TABS.GENERAL);
        return this;
    }

    public CompanySettingsPageService createExchange(String host, String port, String login, String password, String threshold){
        exchangeTabPage.createExchange(host,port,login,password,threshold);
        return this;
    }

    public MainPageService goToMainPage(){
        companySettingsPage.goToPage(PropertiesReader.readUrlProperty("mainUrl"));
        return new MainPageService();
    }

    public MainPageService deleteCompany(){
        companySettingsPage.deleteCompany();
        return goToMainPage();
    }

    public CompanySettingsPageService verifyCompanyCreatedNotificationDisplayed(){
        SoftAssertion.assertThat("Check if company created notification is displayed", companySettingsPage::checkCompanyCreatedNotificationDisplayed, is(true));
        return this;
    }

    public CompanySettingsPageService verifyExchangeUpdatedNotificationDisplayed(){
        SoftAssertion.assertThat("Check if exchange updated notification is displayed", exchangeTabPage::checkExchangeUpdatedNotificationDisplayed, is(true));
        return this;
    }

    public CompanySettingsPageService verifyExchangeSettings(String host, String port, String login, String password, String threshold){
        SoftAssertion.assertThat("Check if exchange values updated", () -> exchangeTabPage.checkExchangeSettings(host, port, login, password, threshold), is(true));
        return this;
    }

}
