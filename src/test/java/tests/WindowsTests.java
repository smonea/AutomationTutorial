package tests;

import Pages.AlertFrameWindowPage;
import Pages.IndexPage;
import Pages.WindowsPage;
import helperMethods.ElementHelper;
import helperMethods.WindowsHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class WindowsTests extends SharedData {

    @Test
    public void testMethod() {

        IndexPage indexPage = new IndexPage(driver);
        indexPage.interactWithAlertsFrameWindowMenu();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(driver);
        alertFrameWindowPage.interactWithBrowserWindowsSubMenu();

        WindowsPage windowsPage = new WindowsPage(driver);
        windowsPage.dealWithNewTab();

        //Din cauza reclamei fortam site-ul sa acceseze un URL specific
//        driver.navigate().to("https://demoqa.com/browser-windows");

        windowsPage.dealWithNewWindow();
    }
}







