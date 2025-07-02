package tests;

import helperMethods.ElementHelper;
import helperMethods.WindowsHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.util.ArrayList;
import java.util.List;

public class WindowsTests extends SharedData {

    @Test
    public void testMethod() {

        ElementHelper elementHelper = new ElementHelper(driver);
        WindowsHelper windowsHelper = new WindowsHelper(driver);

        WebElement alertsFrameWindowsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementHelper.clickElement(alertsFrameWindowsMenu);

        WebElement browserWindowsMenu = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        elementHelper.clickElement(browserWindowsMenu);

        WebElement newTab=driver.findElement(By.xpath("//button[text()='New Tab']"));
        elementHelper.clickElement(newTab);

        windowsHelper.switchToWindow(1);

        elementHelper.closeElement();

        windowsHelper.switchToWindow(0);

        //Din cauza reclamei fortam site-ul sa acceseze un URL specific
        driver.navigate().to("https://demoqa.com/browser-windows");

        WebElement newWindow=driver.findElement(By.xpath("//button[text()='New Window']"));
        newWindow.click();

        windowsHelper.switchToWindow(1);

        windowsHelper.maximizeWindow();

        elementHelper.closeElement();

        windowsHelper.switchToWindow(0);
    }
}







