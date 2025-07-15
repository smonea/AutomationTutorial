package tests;

import Pages.AlertFrameWindowPage;
import Pages.AlertPage;
import Pages.IndexPage;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.time.Duration;

public class AlertsTest extends SharedData {

    @Test
    public void testMethod() {

        IndexPage indexPage = new IndexPage(driver);
        indexPage.interactWithAlertsFrameWindowMenu();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(driver);
        alertFrameWindowPage.interactWithAlertsSubMenu();

        AlertPage alertPage = new AlertPage(driver);
        alertPage.dealAlertOk();
        alertPage.dealAlertTimer();
        alertPage.dealAlertCancel();
        alertPage.dealAlertPrompt("AAA");
    }
}














