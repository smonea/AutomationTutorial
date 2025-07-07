package helperMethods;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ElementHelper {
    public WebDriver driver;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void clickJSElement(WebElement element){
        waitVisibleElement(element);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void clickElement(WebElement element){
        waitVisibleElement(element);
        element.click();
    }

    public void closeElement(){
        driver.close();
    }

    public void printTextElement(WebElement element){
        waitVisibleElement(element);
        System.out.println(element.getText());
    }

    public void sendKeys(WebElement element, String value){
        waitVisibleElement(element);
        element.sendKeys(value);
    }

    public void pressElement(WebElement element, Keys value){
        waitVisibleElement(element);
        element.sendKeys(value);
    }

    public void validateListSize(List<WebElement> elementsList, int expectedSize){
        waitVisibleList(elementsList);
        Assert.assertEquals(elementsList.size(),expectedSize, "Actual element list size: "+elementsList.size()+" is different than: "+expectedSize);
    }

    public void validateElementContainsText(WebElement element, String expectedtext){
        waitVisibleElement(element);
        Assert.assertTrue(element.getText().contains(expectedtext),"Actual element text: "+element.getText()+" is different than "+expectedtext);
    }

    public void validateElementEqualsText(WebElement element, String expectedtext){
        waitVisibleElement(element);
        Assert.assertEquals(element.getText(), expectedtext,"Actual element text: "+element.getText()+" is different than "+expectedtext);
    }

    public void clearFillElement(WebElement element,String value){
        clearElement(element);
        fillElement(element,value);
    }

    public void clearElement(WebElement element){
        waitVisibleElement(element);
        element.clear();
    }

    public void fillElement (WebElement element, String value){
        waitVisibleElement(element);
        element.sendKeys(value);
    }

    public void fillPressElement(WebElement element, String value, Keys keysValue){
        fillElement(element, value);
        pressElement(element, keysValue);
    }

    public void waitVisibleElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitVisibleList(List<WebElement> elementsList){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfAllElements(elementsList));
    }

    public void sendKeysById(String id, String value) {
        WebElement element = driver.findElement(By.id(id));
        element.sendKeys(value);
    }

    private void editSendKeys(String id, String value) {
        WebElement element = driver.findElement(By.id(id));
        element.clear();
        element.sendKeys(value);
    }

    public void sendKeysCSS(String id, String value) {
        WebElement element = driver.findElement(By.cssSelector(id));
        element.sendKeys(value);
    }

}
