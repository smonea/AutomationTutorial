package tests;

import helperMethods.AlertHelper;
import helperMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.time.Duration;

public class AlertsTest extends SharedData {

    @Test
    public void testMethod() {

        ElementHelper elementHelper = new ElementHelper(driver);
        AlertHelper alertHelper = new AlertHelper(driver);

        WebElement alertsFrameWindowsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementHelper.clickJSElement(alertsFrameWindowsMenu);

        WebElement alertsMenu = driver.findElement(By.xpath("//span[text()='Alerts']"));
        elementHelper.clickJSElement(alertsMenu);

        WebElement firstAlert = driver.findElement(By.id("alertButton"));
        elementHelper.clickElement(firstAlert);

        alertHelper.acceptAlert();

        WebElement secondAlert = driver.findElement(By.id("timerAlertButton"));
        elementHelper.clickElement(secondAlert);

        //wait explicit pentru alerta
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        alertHelper.acceptAlert();

        WebElement thirdAlert = driver.findElement(By.id("confirmButton"));
        elementHelper.clickElement(thirdAlert);

        alertHelper.dismissAlert();

        WebElement fourthAlert = driver.findElement(By.id("promtButton"));
        elementHelper.clickElement(fourthAlert);

        alertHelper.fillAlert("Formula 1");
    }
}














