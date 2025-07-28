package Pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FramesPage extends BasePage{

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "sampleHeading")
    private WebElement firstBlockElement;
    @FindBy(id = "sampleHeading")
    private WebElement secondBlockElement;

    public void dealWithBigIFrame (){
        frameHelper.switchFrameString("frame1");
        LoggerUtility.infoLog("The user switches to specific frame");
        elementHelper.printTextElement(firstBlockElement);
        frameHelper.switchToParent();
        LoggerUtility.infoLog("The user switched to parent frame");
    }

    public void dealWithLittleIFrame (){
        frameHelper.switchFrameString("frame2");
        LoggerUtility.infoLog("The user switches to specific frame");
        elementHelper.printTextElement(secondBlockElement);
    }
}
