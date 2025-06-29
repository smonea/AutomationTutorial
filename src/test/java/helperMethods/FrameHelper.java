package helperMethods;

import org.openqa.selenium.WebDriver;
import sharedData.SharedData;

public class FrameHelper extends SharedData {
    public WebDriver driver;

    public FrameHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void switchFrame (String text){
        driver.switchTo().frame(text);
    }

    public void switchParent(){
        driver.switchTo().parentFrame();
    }
}
