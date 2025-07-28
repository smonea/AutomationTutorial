package tests;

import Pages.AlertFrameWindowPage;
import Pages.AlertPage;
import Pages.IndexPage;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class AlertsTest extends SharedData {

    @Test
    public void testMethod() {

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactWithAlertsFrameWindowMenu();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.interactWithAlertsSubMenu();

        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.dealAlertOk();
        alertPage.dealAlertTimer();
        alertPage.dealAlertCancel();
        alertPage.dealAlertPrompt("AAA");
    }
}














