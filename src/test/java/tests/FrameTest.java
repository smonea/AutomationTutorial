package tests;

import Pages.AlertFrameWindowPage;
import Pages.FramesPage;
import Pages.IndexPage;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class FrameTest extends SharedData {

    @Test
    public void testMethod() {

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactWithAlertsFrameWindowMenu();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.interactWithFramesSubMenu();

        FramesPage framesPage = new FramesPage(getDriver());
        framesPage.dealWithBigIFrame();
        framesPage.dealWithLittleIFrame();
    }
}

















