package org.example.pageobject.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.example.enums.TABS;
import org.example.pageobject.BasePage;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CompanySettingsPage extends BasePage {

    private final SelenideElement availableTabsButton = $x("//button[@name=\"button\"][contains(text(),\"Available tabs\")]");
    private final ElementsCollection tabs = $$x("//ul[@class=\"dropdown-menu dropdown-menu-right\"]/li/a");
    private final SelenideElement deleteButton = $x("//a[@id=\"company_settings_delete_btn\"]");
    private final SelenideElement confirmDeleteButton = $x("//div[@class=\"modal-content\"]//input[@name=\"commit\"]");
    private final SelenideElement companyCreatedNotification = $x("//div[@class=\"ng-alert alert fade in alert-success\"]");

    public void clickTab(TABS tab){
        availableTabsButton.click();
        tabs.get(tab.getValue()).click();
    }

    public void deleteCompany(){
        deleteButton.click();
        confirmDeleteButton.click();
    }

    public boolean checkCompanyCreatedNotificationDisplayed(){
        return companyCreatedNotification.isDisplayed();
    }

}
