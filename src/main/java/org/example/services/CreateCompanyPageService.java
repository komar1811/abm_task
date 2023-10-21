package org.example.services;

import org.example.pageobject.pages.CreateCompanyPage;

public class CreateCompanyPageService {

    private final CreateCompanyPage createCompanyPage = new CreateCompanyPage();

    public CompanySettingsPageService addCompany(String name, String systemName){
        createCompanyPage.addCompany(name, systemName);
        return new CompanySettingsPageService();
    }
}
