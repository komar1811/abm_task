package org.example.services;

import org.example.pageobject.pages.MainPage;
import org.example.utils.PropertiesReader;
import org.example.utils.SoftAssertion;

import static org.hamcrest.Matchers.is;

public class MainPageService {

    private final MainPage mainPage = new MainPage();

    public MainPageService verifyMainPageIsOpened(){
        SoftAssertion.assertThat("Check Main Page link", () -> mainPage.checkPageLink().equals(PropertiesReader.readUrlProperty("mainUrl")), is(true));
        SoftAssertion.assertThat("Check if Main Page is opened", mainPage::checkLogoIsDisplayed, is(true));
        return this;
    }

    public CreateCompanyPageService clickAddCompany(){
        mainPage.clickAddButton();
        return new CreateCompanyPageService();
    }

    public CompanySettingsPageService goToFirstCompanySettings(){
        mainPage.clickFirstCompanySettingsButton();
        return new CompanySettingsPageService();
    }

    public MainPageService verifyCompanyDeleted(){
        SoftAssertion.assertThat("Check if company is deleted", mainPage::checkCompanyDeleted, is(true));
        return this;
    }
}
