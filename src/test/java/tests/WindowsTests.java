package tests;

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

        WebElement alertsFrameWindowsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertsFrameWindowsMenu.click();

        WebElement browserWindowsMenu = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        browserWindowsMenu.click();

        WebElement newTab=driver.findElement(By.xpath("//button[text()='New Tab']"));
        newTab.click();

        System.out.println(driver.getCurrentUrl());

        List<String> tabsList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsList.get(1));

        System.out.println(driver.getCurrentUrl());

        driver.close();

        driver.switchTo().window(tabsList.get(0));

        System.out.println(driver.getCurrentUrl());

        //Din cauza reclamei fortam site-ul sa acceseze un URL specific
        driver.navigate().to("https://demoqa.com/browser-windows");

        WebElement newWindow=driver.findElement(By.xpath("//button[text()='New Window']"));
        newWindow.click();

        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));

        driver.manage().window().maximize();

        System.out.println(driver.getCurrentUrl());

        driver.close();

        driver.switchTo().window(tabsList.get(0));

        System.out.println(driver.getCurrentUrl());
    }
}




















