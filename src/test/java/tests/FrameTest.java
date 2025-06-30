package tests;

import helperMethods.ElementHelper;
import helperMethods.FrameHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.time.Duration;

public class FrameTest extends SharedData {

    @Test
    public void testMethod() {

        ElementHelper elementHelper = new ElementHelper(driver);
        FrameHelper frameHelper = new FrameHelper(driver);

        WebElement alertsFrameWindowsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementHelper.clickElement(alertsFrameWindowsMenu);

        WebElement framesMenu = driver.findElement(By.xpath("//span[text()='Frames']"));
        elementHelper.clickElement(framesMenu);

        frameHelper.switchFrameString("frame1");

        //Alta varianta pentru frame1 by element

//        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame1']")));

        WebElement firstBlockElement = driver.findElement(By.id("sampleHeading"));
        elementHelper.printTextElement(firstBlockElement);

        frameHelper.switchToParent();

        frameHelper.switchFrameString("frame2");

        WebElement secondBlockElement = driver.findElement(By.id("sampleHeading"));
        elementHelper.printTextElement(secondBlockElement);
    }
}

















