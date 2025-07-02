package helperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sharedData.SharedData;

import java.util.ArrayList;
import java.util.List;

public class WindowsHelper extends SharedData {

    public WebDriver driver;

    public WindowsHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void getCurrentURL(){
        System.out.println(driver.getCurrentUrl());
    }

    public void switchToWindow(int tabIndex){
        List<String> tabsList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsList.get(tabIndex));
    }

    public void maximizeWindow(){
        driver.manage().window().maximize();
    }

}
