package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowsPage extends BasePage{
    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[text()='New Tab']")
    public WebElement newTab;
    @FindBy(xpath = "//button[text()='New Window']")
    public WebElement newWindow;

    public void dealWithNewTab(){
        elementHelper.clickElement(newTab);
        windowsHelper.switchToWindow(1);
        elementHelper.closeElement();
        windowsHelper.switchToWindow(0);
    }

    public void dealWithNewWindow(){
        newWindow.click();
        windowsHelper.switchToWindow(1);
        windowsHelper.maximizeWindow();
        elementHelper.closeElement();
        windowsHelper.switchToWindow(0);
    }
}
