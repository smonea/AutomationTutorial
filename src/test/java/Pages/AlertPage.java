package Pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertPage extends BasePage{

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "alertButton")
    private WebElement alertOkButtonElement;
    @FindBy(id = "timerAlertButton")
    private WebElement alertWaitButtonElement;
    @FindBy(id = "confirmButton")
    private WebElement alertOkCancelElement;
    @FindBy(id = "promtButton")
    private WebElement alertPromptElement;

    public void dealAlertOk(){
        elementHelper.clickElement(alertOkButtonElement);
        LoggerUtility.infoLog("The user clicks on alert ok button.");
        alertHelper.acceptAlert();
        LoggerUtility.infoLog("The user deals with alert ok presence.");
    }

    public void dealAlertTimer(){
        elementHelper.clickElement(alertWaitButtonElement);
        LoggerUtility.infoLog("The user clicks on alert timer button.");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        alertHelper.acceptAlert();
        LoggerUtility.infoLog("The user deals with alert ok presence.");
    }

    public void dealAlertCancel(){
        elementHelper.clickElement(alertOkCancelElement);
        LoggerUtility.infoLog("The user clicks on alert ok button.");
        alertHelper.dismissAlert();
        LoggerUtility.infoLog("The user cancels the alert.");
    }

    public void dealAlertPrompt(String value){
        elementHelper.clickElement(alertPromptElement);
        LoggerUtility.infoLog("The user clicks on alert prompt button.");
        alertHelper.fillAlert(value);
        LoggerUtility.infoLog("The user fills the alert prompt with the value: "+value);
    }
}
