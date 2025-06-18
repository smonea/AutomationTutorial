package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertsTest {

    public WebDriver driver;

    @Test
    public void testMethod() {

        //Deschidem o instanta de Chrome.

        driver = new EdgeDriver();

        //Accesam o pagina specifica.

        driver.get("https://demoqa.com");

        //Facem browserul in modul maximize.

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement alertsFrameWindowsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertsFrameWindowsMenu.click();

        WebElement alertsMenu = driver.findElement(By.xpath("//span[text()='Alerts']"));
        alertsMenu.click();

        WebElement firstAlert = driver.findElement(By.id("alertButton"));
        firstAlert.click();

        //Ca sa dam click pe Alerta
        Alert alertOk = driver.switchTo().alert();
        alertOk.accept();

        WebElement secondAlert = driver.findElement(By.id("timerAlertButton"));
        secondAlert.click();

        //wait explicit pentru alerta
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alertOk2 = driver.switchTo().alert();
        alertOk2.accept();

        WebElement thirdAlert = driver.findElement(By.id("confirmButton"));
        thirdAlert.click();

        Alert alertDeny = driver.switchTo().alert();
        alertDeny.dismiss();

        WebElement fourthAlert = driver.findElement(By.id("promtButton"));
        fourthAlert.click();

        Alert alertPrompt = driver.switchTo().alert();
        alertPrompt.sendKeys("Example");
        alertPrompt.accept();

        driver.quit();

    }
}














