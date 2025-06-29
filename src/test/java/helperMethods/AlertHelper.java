package helperMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertHelper {

    public WebDriver driver;

    public AlertHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitAlert(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }


    //Ca sa dam click si accept pe Alerta
    public void acceptAlert(){
        waitAlert();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    //Ca sa dam click si dismiss pe Alerta
    public void dismissAlert(){
        waitAlert();
        Alert alertDeny = driver.switchTo().alert();
        alertDeny.dismiss();
    }

    public void fillAlert(String text){
        waitAlert();
        Alert alertPrompt = driver.switchTo().alert();
        alertPrompt.sendKeys(text);
        alertPrompt.accept();
    }
}
