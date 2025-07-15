package tests;

import Pages.AlertFrameWindowPage;
import Pages.FramesPage;
import Pages.IndexPage;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class FrameTest extends SharedData {

    @Test
    public void testMethod() {

        IndexPage indexPage = new IndexPage(driver);
        indexPage.interactWithAlertsFrameWindowMenu();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(driver);
        alertFrameWindowPage.interactWithFramesSubMenu();

        FramesPage framesPage = new FramesPage(driver);
        framesPage.dealWithBigIFrame();
        framesPage.dealWithLittleIFrame();
    }
}

















