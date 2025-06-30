package tests;

import helperMethods.ElementHelper;
import helperMethods.FormsHelper;
import helperMethods.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;
import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test

    public void testMethodd(){

        ElementHelper elementHelper = new ElementHelper(driver);
        PageHelper pageHelper = new PageHelper(driver);
        FormsHelper formsHelper = new FormsHelper(driver);

        WebElement formsMenu = driver.findElement(By.xpath("//h5[text()='Forms']"));
        elementHelper.clickElement(formsMenu);

        WebElement practiceFormMenu = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        elementHelper.clickElement(practiceFormMenu);

        //Wait implicit
        pageHelper.waitImplicit();

        formsHelper.firstNameValue="Gojo";
        formsHelper.lastnameValue="Satoru";
        formsHelper.emailValue="gojo.satoru@gmail.com";
        formsHelper.mobileValue="2223334443";

        formsHelper.fillPracticeForm();

        WebElement subjectsElement=driver.findElement(By.id("subjectsInput"));
        List<String> subjectsValue = Arrays.asList("Arts","Accounting","Maths");
        for (int index=0; index < subjectsValue.size(); index++){
            elementHelper.sendKeys(subjectsElement, subjectsValue.get(index));
            elementHelper.pressElement(subjectsElement, Keys.ENTER);
        }

        String genderValue="Male";
        List<WebElement> genderElemenetList = driver.findElements(By.cssSelector("div[id='genterWrapper']>div>div>label[class='custom-control-label']"));
        switch (genderValue){
            case "Male":
                elementHelper.clickElement(genderElemenetList.get(0));
                break;
            case "Female":
                elementHelper.clickElement(genderElemenetList.get(1));
                break;
            case "Other":
                elementHelper.clickElement(genderElemenetList.get(2));
                break;
        }

        List<WebElement> hobbiesElementList = driver.findElements(By.cssSelector("div[id='hobbiesWrapper']>div>div>label[class='custom-control-label']"));
        List<String> hobbiesValues = Arrays.asList("Music", "Sports");
        for(int index = 0; index<hobbiesElementList.size();index++){
            if(hobbiesValues.contains(hobbiesElementList.get(index).getText())){
                elementHelper.clickElement(hobbiesElementList.get(index));
            }
        }

        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        String uploadValue = "src/test/resources/Map_alWnRyQmNq - Copy.png";
        File file = new File(uploadValue);
        uploadElement.sendKeys(file.getAbsolutePath());

        WebElement adressElement = driver.findElement(By.id("currentAddress"));
        String adressValue="Strada 10";
        adressElement.sendKeys(adressValue);

        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
        String stateValue ="NCR";
        elementHelper.sendKeys(stateInputElement, stateValue);
        elementHelper.pressElement(stateInputElement, Keys.ENTER);

        WebElement cityElement = driver.findElement(By.id("react-select-4-input"));
        String cityValue ="Delhi";
        elementHelper.sendKeys(cityElement, cityValue);
        elementHelper.pressElement(cityElement, Keys.ENTER);

        WebElement submitElement = driver.findElement(By.id("submit"));
        elementHelper.clickElement(submitElement);

        //Wait explicit
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table//td[1]")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table//td[2]")));

        List<WebElement> tableDescriptionList = driver.findElements(By.xpath("//table//td[1]"));
        List<WebElement> tableValueList = driver.findElements(By.xpath("//table//td[2]"));

        Assert.assertEquals(tableDescriptionList.get(0).getText(),"Student Name","Student Name text is not displayed right in the table");
        Assert.assertTrue(tableValueList.get(0).getText().contains(formsHelper.firstNameValue),"First Name is not displayed right in the table");
        Assert.assertTrue(tableValueList.get(0).getText().contains(formsHelper.lastnameValue), "Last Name is not displayed right in the table");

        Assert.assertEquals(tableDescriptionList.get(1).getText(), "Student Email","Email text is not displayed right in the table");
        Assert.assertEquals(tableValueList.get(1).getText(), formsHelper.emailValue,  "Email is not displayed right in the table");

        Assert.assertEquals(tableDescriptionList.get(2).getText(), "Gender","Gender text is not displayed right in the table");
        Assert.assertEquals(tableValueList.get(2).getText(), genderValue,"Gender is not displayed right in the table");

        Assert.assertEquals(tableDescriptionList.get(3).getText(), "Mobile","Mobile text is not displayed right in the table");
        Assert.assertEquals(tableValueList.get(3).getText(), formsHelper.mobileValue,"Mobile is not displayed right in the table");

        String actualSubjects = tableValueList.get(5).getText();
        for (String subject : subjectsValue) {
            Assert.assertTrue(actualSubjects.contains(subject), "Subject '" + subject + "' is not displayed in the table");
        }

        String actualHobbies = tableValueList.get(6).getText();
        for (String hobbies : hobbiesValues) {
            Assert.assertTrue(actualHobbies.contains(hobbies), "Hobbies '" + hobbies + "' is not displayed in the table");
        }

        File fileF = new File(uploadValue);
        String fileName = fileF.getName(); // => "Map_alWnRyQmNq - Copy.png"

        Assert.assertEquals(tableDescriptionList.get(7).getText(), "Picture", "Picture text is not displayed right in the table");
        Assert.assertEquals(tableValueList.get(7).getText(), fileName, "Picture is not displayed right in the table");

        Assert.assertEquals(tableDescriptionList.get(8).getText(), "Address","Address text is not displayed right in the table");
        Assert.assertEquals(tableValueList.get(8).getText(), adressValue,"Address is not displayed right in the table");

        Assert.assertEquals(tableDescriptionList.get(9).getText(),"State and City","State and City text is not displayed right in the table");
        Assert.assertTrue(tableValueList.get(9).getText().contains(stateValue),"State is not displayed right in the table");
        Assert.assertTrue(tableValueList.get(9).getText().contains(cityValue), "City is not displayed right in the table");
    }
}


























