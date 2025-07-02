package tests;

import helperMethods.ElementHelper;
import helperMethods.FormsHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.util.List;

public class WebTablesTest extends SharedData {

    @Test
    public void testMethod(){

        ElementHelper elementHelper = new ElementHelper(driver);
        FormsHelper formsHelper = new FormsHelper(driver);

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementHelper.clickElement(elementsMenu);

        WebElement webTablesSubMenu = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        elementHelper.clickElement(webTablesSubMenu);

        List<WebElement> tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        int tableSize = 3;
        elementHelper.validateListSize(tableList,tableSize);

        //Identificam un element.
        //Un element se identifica printr-o variabila locala -> WebElement

        WebElement addElement=driver.findElement(By.id("addNewRecordButton"));
        elementHelper.clickElement(addElement);

        formsHelper.firstNameValue="Gojo";
        formsHelper.lastnameValue="Satoru";
        formsHelper.emailValue="gojo.satoru@gmail.com";
        formsHelper.ageValue="27";
        formsHelper.salaryValue="212221";
        formsHelper.departmentValue="Test";

        formsHelper.fillWebTablesForm();

        WebElement submitElement=driver.findElement(By.id("submit"));
        elementHelper.clickJSElement(submitElement);

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        elementHelper.validateListSize(tableList,tableSize+1);


        elementHelper.validateElementContainsText(tableList.get(tableSize),formsHelper.firstNameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),formsHelper.lastnameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),formsHelper.emailValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),formsHelper.ageValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),formsHelper.salaryValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),formsHelper.departmentValue);

        //Edit functionality

        WebElement editElement=driver.findElement(By.id("edit-record-4"));
        elementHelper.clickElement(editElement);

        formsHelper.editFirstNameValue="Gojo1";
        formsHelper.editLastnameValue="Satoru2";
        formsHelper.editEmailValue="gojo1.satoru2@gmail.com";
        formsHelper.editAgeValue="30";
        formsHelper.editSalaryValue="11111111";
        formsHelper.editDepartmentValue="Dev";

        formsHelper.editFillWebTablesForm();

        WebElement editsubmitElement=driver.findElement(By.id("submit"));
        elementHelper.clickJSElement(editsubmitElement);

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        elementHelper.validateListSize(tableList,tableSize+1);

        elementHelper.validateElementContainsText(tableList.get(tableSize),formsHelper.editFirstNameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),formsHelper.editLastnameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),formsHelper.editEmailValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),formsHelper.editAgeValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),formsHelper.editSalaryValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),formsHelper.editDepartmentValue);

        //Delete Element

        WebElement deleteElement=driver.findElement(By.id("delete-record-4"));
        elementHelper.clickElement(deleteElement);

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        elementHelper.validateListSize(tableList,tableSize);
    }
}






















