package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class FrameTest {

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

        WebElement framesMenu = driver.findElement(By.xpath("//span[text()='Frames']"));
        framesMenu.click();

        driver.switchTo().frame("frame1");

        //Alta varianta pentru frame1

//        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame1']")));

        WebElement firstBlockElement = driver.findElement(By.id("sampleHeading"));
        System.out.println(firstBlockElement.getText());

        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame2");

        WebElement secondBlockElement = driver.findElement(By.id("sampleHeading"));
        System.out.println(secondBlockElement.getText());

        driver.quit();
    }
}

















