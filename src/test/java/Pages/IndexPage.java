package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends BasePage{

    public IndexPage(WebDriver driver) {
       super(driver);
    }

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    public WebElement alertsFrameWindowsMenu;
    @FindBy(xpath = "//h5[text()='Elements']")
    public WebElement elementsMenu;


    public void interactWithAlertsFrameWindowMenu(){
        elementHelper.clickJSElement(alertsFrameWindowsMenu);
    }

    public void interactWithElementsMenu(){
        elementHelper.clickElement(elementsMenu);
    }
}
