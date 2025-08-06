package tests;

import Pages.AlertFrameWindowPage;
import Pages.IndexPage;
import Pages.WindowsPage;
import org.testng.annotations.Test;
import sharedData.SharedData;
import suite.Suite;

public class WindowsTests extends SharedData {

    @Test(groups = {Suite.REGRESSION_SUITE,Suite.SANITY_SUITE,Suite.ALERTWINDOWFRAME_SUITE})
    public void testMethod() {

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactWithAlertsFrameWindowMenu();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.interactWithBrowserWindowsSubMenu();

        WindowsPage windowsPage = new WindowsPage(getDriver());
        windowsPage.dealWithNewTab();

        //Din cauza reclamei fortam site-ul sa acceseze un URL specific
//        driver.navigate().to("https://demoqa.com/browser-windows");

        windowsPage.dealWithNewWindow();
    }
}







