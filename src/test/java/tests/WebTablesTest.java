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
        Assert.assertEquals(tableList.size(),tableSize, "Expected table size: "+tableSize+" is not correct");

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
        Assert.assertEquals(tableList.size(),tableSize+1, "Expected table size is not correct");
        
        Assert.assertTrue(tableList.get(tableSize).getText().contains(formsHelper.firstNameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(formsHelper.lastnameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(formsHelper.emailValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(formsHelper.ageValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(formsHelper.salaryValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(formsHelper.departmentValue));

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
        Assert.assertEquals(tableList.size(),tableSize+1, "Expected table size is not correct");

        Assert.assertTrue(tableList.get(tableSize).getText().contains(formsHelper.editFirstNameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(formsHelper.editLastnameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(formsHelper.editEmailValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(formsHelper.editAgeValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(formsHelper.editSalaryValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(formsHelper.editDepartmentValue));

        //Delete Element

        WebElement deleteElement=driver.findElement(By.id("delete-record-4"));
        elementHelper.clickElement(deleteElement);

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(),tableSize, "Expected table size: "+tableSize+" is not correct");
    }
}






















