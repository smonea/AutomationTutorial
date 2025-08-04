package Pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowsPage extends BasePage{
    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[text()='New Tab']")
    private WebElement newTab;
    @FindBy(xpath = "//button[text()='New Window']")
    private WebElement newWindow;

    public void dealWithNewTab(){
        elementHelper.clickElement(newTab);
        LoggerUtility.infoLog("The user clicks on new tab button");
        windowsHelper.switchToWindow(1);
        LoggerUtility.infoLog("The user switches on second tab open");
        elementHelper.closeElement();
        LoggerUtility.infoLog("The user closes the tab");
        windowsHelper.switchToWindow(0);
        LoggerUtility.infoLog("The user switches to initial tab");
    }

    public void dealWithNewWindow(){
        newWindow.click();
//        elementHelper.clickJSElement(newWindow);
        LoggerUtility.infoLog("The user clicks on new window button");
        windowsHelper.switchToWindow(1);
        LoggerUtility.infoLog("The user switches on second window open");
        windowsHelper.maximizeWindow();
        LoggerUtility.infoLog("The user maximizez the window");
        elementHelper.closeElement();
        LoggerUtility.infoLog("The user closes the window");
        windowsHelper.switchToWindow(0);
        LoggerUtility.infoLog("The user switches to initial window");
    }
}
