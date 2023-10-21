package org.example.pageobject;

import com.codeborne.selenide.Selenide;

public class BasePage {

    public String checkPageLink(){
        return Selenide.webdriver().driver().getCurrentFrameUrl();
    }

    public void goToPage(String url){
        Selenide.open(url);
    }
}
