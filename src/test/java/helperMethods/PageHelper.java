package helperMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class PageHelper {

    //Doar pentru scroll

    public WebDriver driver;

    public PageHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollPage(int x, int y){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+x+","+y+")", "");
    }

    public void waitImplicit(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


}