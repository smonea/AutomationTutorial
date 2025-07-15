package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FramesPage extends BasePage{

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "sampleHeading")
    public WebElement firstBlockElement;
    @FindBy(id = "sampleHeading")
    public WebElement secondBlockElement;

    public void dealWithBigIFrame (){
        frameHelper.switchFrameString("frame1");
        elementHelper.printTextElement(firstBlockElement);
        frameHelper.switchToParent();
    }

    public void dealWithLittleIFrame (){
        frameHelper.switchFrameString("frame2");
        elementHelper.printTextElement(secondBlockElement);
    }
}
