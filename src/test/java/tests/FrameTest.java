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

        frameHelper.switchFrame("frame1");

        //Alta varianta pentru frame1

//        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame1']")));

        WebElement firstBlockElement = driver.findElement(By.id("sampleHeading"));
        System.out.println(firstBlockElement.getText());

        frameHelper.switchParent();

        frameHelper.switchFrame("frame2");

        WebElement secondBlockElement = driver.findElement(By.id("sampleHeading"));
        System.out.println(secondBlockElement.getText());
    }
}

















