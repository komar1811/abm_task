package org.example.pageobject.pages;

import com.codeborne.selenide.SelenideElement;
import org.example.pageobject.BasePage;

import static com.codeborne.selenide.Selenide.$x;

public class CreateCompanyPage extends BasePage {

    private final SelenideElement nameField = $x("//input[@name=\"company[name]\"]");
    private final SelenideElement systemField = $x("//input[@name=\"company[system_name]\"]");
    private final SelenideElement submitButton = $x("//input[@name=\"commit\"]");

    public void addCompany(String name, String systemName){
        nameField.setValue(name);
        systemField.setValue(systemName);
        submitButton.click();
    }
}
