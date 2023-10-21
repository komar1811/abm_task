package org.example.pageobject.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.example.pageobject.BasePage;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends BasePage {
    private final SelenideElement logo = $x("//a[@id=\"company_logo_link\"]");
    private final SelenideElement addButton = $x("//a[@title=\"Add\"]");
    private final ElementsCollection companySettingsButtons = $$x("//a/i[@class=\"ic ic-settings\"]");
    private final SelenideElement noDataTitle = $x("//h1[@class=\"none-table-title\"]");

    public boolean checkLogoIsDisplayed(){
        return this.logo.isDisplayed();
    }
    public void clickAddButton(){
        addButton.click();
    }
    public void clickFirstCompanySettingsButton(){
        companySettingsButtons.get(0).click();
    }

    public boolean checkCompanyDeleted(){
        return noDataTitle.isDisplayed();
    }
}