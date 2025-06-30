package helperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sharedData.SharedData;

public class FrameHelper extends SharedData {
    public WebDriver driver;

    public FrameHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void switchFrameString (String text){
        driver.switchTo().frame(text);
    }

    public void switchToParent(){
        driver.switchTo().parentFrame();
    }

    public void switchFrameElement(WebElement element){
        driver.switchTo().frame(element);
    }
}
