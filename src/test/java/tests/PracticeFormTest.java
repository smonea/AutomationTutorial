package tests;

import helperMethods.ElementHelper;
import helperMethods.FormsHelper;
import helperMethods.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import sharedData.SharedData;
import java.io.File;
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
            elementHelper.fillPressElement(subjectsElement, subjectsValue.get(index), Keys.ENTER);
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
        elementHelper.fillPressElement(stateInputElement, stateValue,Keys.ENTER);

        WebElement cityElement = driver.findElement(By.id("react-select-4-input"));
        String cityValue ="Delhi";
        elementHelper.fillPressElement(cityElement, cityValue,Keys.ENTER);

        WebElement submitElement = driver.findElement(By.id("submit"));
        elementHelper.clickElement(submitElement);

        List<WebElement> tableDescriptionList = driver.findElements(By.xpath("//table//td[1]"));
        List<WebElement> tableValueList = driver.findElements(By.xpath("//table//td[2]"));

        elementHelper.validateElementEqualsText(tableDescriptionList.get(0),"Student Name");
        elementHelper.validateElementContainsText(tableValueList.get(0), formsHelper.firstNameValue);
        elementHelper.validateElementContainsText(tableValueList.get(0), formsHelper.lastnameValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(1),"Student Email");
        elementHelper.validateElementEqualsText(tableValueList.get(1),formsHelper.emailValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(2),"Gender");
        elementHelper.validateElementEqualsText(tableValueList.get(2),genderValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(3),"Mobile");
        elementHelper.validateElementEqualsText(tableValueList.get(3),formsHelper.mobileValue);

        String actualSubjects = tableValueList.get(5).getText();
        elementHelper.validateElementEqualsText(tableDescriptionList.get(5),"Subjects");
        elementHelper.validateElementEqualsText(tableValueList.get(5),actualSubjects);

        String actualHobbies = tableValueList.get(6).getText();
        elementHelper.validateElementEqualsText(tableDescriptionList.get(6),"Hobbies");
        elementHelper.validateElementEqualsText(tableValueList.get(6),actualHobbies);

        File fileF = new File(uploadValue);
        String fileName = fileF.getName(); // => "Map_alWnRyQmNq - Copy.png"

        elementHelper.validateElementEqualsText(tableDescriptionList.get(7),"Picture");
        elementHelper.validateElementEqualsText(tableValueList.get(7),fileName);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(8),"Address");
        elementHelper.validateElementEqualsText(tableValueList.get(8),adressValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(9),"State and City");
        elementHelper.validateElementContainsText(tableValueList.get(9), stateValue);
        elementHelper.validateElementContainsText(tableValueList.get(9), cityValue);
    }
}


























