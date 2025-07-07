package tests;

import helperMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.util.List;

public class WebTablesTest extends SharedData {

    @Test
    public void testMethod(){

        ElementHelper elementHelper = new ElementHelper(driver);

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

        WebElement firstnameElement=driver.findElement(By.id("firstName"));
        String firstNameValue = "Satoru";
        elementHelper.fillElement(firstnameElement,firstNameValue);

        WebElement lastnameElement=driver.findElement(By.id("lastName"));
        String lastNameValue = "Gojo";
        elementHelper.fillElement(lastnameElement,lastNameValue);

        WebElement emailElement=driver.findElement(By.id("userEmail"));
        String emailValue = "gojo.satoru@gmail.com";
        elementHelper.fillElement(emailElement,emailValue);

        WebElement ageElement=driver.findElement(By.id("age"));
        String ageValue="27";
        elementHelper.fillElement(ageElement,ageValue);

        WebElement salaryElement=driver.findElement(By.id("salary"));
        String salaryValue="33445455";
        elementHelper.fillElement(salaryElement,salaryValue);

        WebElement departmentElement=driver.findElement(By.id("department"));
        String departmentValue="Testing";
        elementHelper.fillElement(departmentElement,departmentValue);

        WebElement submitElement=driver.findElement(By.id("submit"));
        elementHelper.clickJSElement(submitElement);

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        elementHelper.validateListSize(tableList,tableSize+1);


        elementHelper.validateElementContainsText(tableList.get(tableSize),firstNameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),lastNameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),emailValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),ageValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),salaryValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),departmentValue);

        //Edit functionality

        WebElement editElement=driver.findElement(By.id("edit-record-4"));
        elementHelper.clickElement(editElement);

        WebElement editfirstnameElement=driver.findElement(By.id("firstName"));
        String editfirstnameValue="Gojo1";
        elementHelper.clearFillElement(editfirstnameElement,editfirstnameValue);

        WebElement editlastnameElement=driver.findElement(By.id("lastName"));
        String editlastnameValue="Satoru2";
        elementHelper.clearFillElement(editlastnameElement,editlastnameValue);

        WebElement edituserEmailElement=driver.findElement(By.id("userEmail"));
        String edituserEmailValue="gojo1.satoru2@gmail.com";
        elementHelper.clearFillElement(edituserEmailElement,edituserEmailValue);

        WebElement editageElement=driver.findElement(By.id("age"));
        String editageValue="31";
        elementHelper.clearFillElement(editageElement,editageValue);

        WebElement editsalaryElement=driver.findElement(By.id("salary"));
        String editsalaryValue="3333333";
        elementHelper.clearFillElement(editsalaryElement,editsalaryValue);

        WebElement editdepartmentElement=driver.findElement(By.id("department"));
        String editdepartmentValue="Sorcerer";
        elementHelper.clearFillElement(editdepartmentElement,editdepartmentValue);

        WebElement editsubmitElement=driver.findElement(By.id("submit"));
        elementHelper.clickJSElement(editsubmitElement);

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        elementHelper.validateListSize(tableList,tableSize+1);

        elementHelper.validateElementContainsText(tableList.get(tableSize),editfirstnameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),editlastnameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),edituserEmailValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),editageValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),editsalaryValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),editdepartmentValue);

        //Delete Element

        WebElement deleteElement=driver.findElement(By.id("delete-record-4"));
        elementHelper.clickElement(deleteElement);

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        elementHelper.validateListSize(tableList,tableSize);
    }
}






















