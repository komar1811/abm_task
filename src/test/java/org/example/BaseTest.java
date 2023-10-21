package org.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.example.utils.PropertiesReader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    @BeforeAll
    protected static void setUp(){
        Configuration.baseUrl = PropertiesReader.readProperty("baseUrl");
        Configuration.browser = PropertiesReader.readProperty("browser");
    }

    @BeforeEach
    protected void openBrowser(){
        Selenide.open("/login");
    }

    @AfterEach
    protected void closeBrowser(){
        Selenide.clearBrowserCookies();
        Selenide.closeWindow();
    }

    @AfterAll
    protected static void tearDown(){
        Selenide.closeWebDriver();
    }
}
