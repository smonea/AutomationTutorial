package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.util.List;

public class WebTablesTest extends SharedData {

    @Test
    public void testMethod(){

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsMenu.click();

        WebElement webTablesSubMenu = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        webTablesSubMenu.click();

        List<WebElement> tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        int tableSize = 3;
        Assert.assertEquals(tableList.size(),tableSize, "Expected table size: "+tableSize+" is not correct");

        //Identificam un element.
        //Un element se identifica printr-o variabila locala -> WebElement

        WebElement addElement=driver.findElement(By.id("addNewRecordButton"));
        addElement.click();

        WebElement firstnameElement=driver.findElement(By.id("firstName"));
        String firstnameValue="Satoru";
        firstnameElement.sendKeys(firstnameValue);

        WebElement lastnameElement=driver.findElement(By.id("lastName"));
        String lastnameValue="Gojo";
        lastnameElement.sendKeys(lastnameValue);

        WebElement emailElement=driver.findElement(By.id("userEmail"));
        String emailValue="gojo.satoru@gmail.com";
        emailElement.sendKeys(emailValue);

        WebElement ageElement=driver.findElement(By.id("age"));
        String ageValue="27";
        ageElement.sendKeys(ageValue);

        WebElement salaryElement=driver.findElement(By.id("salary"));
        String salaryValue="33445455";
        salaryElement.sendKeys(salaryValue);

        WebElement departmentElement=driver.findElement(By.id("department"));
        String departmentValue="Testing";
        departmentElement.sendKeys(departmentValue);

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement submitElement=driver.findElement(By.id("submit"));
        executor.executeScript("arguments[0].click();", submitElement);

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(),tableSize+1, "Expected table size is not correct");
        
        Assert.assertTrue(tableList.get(tableSize).getText().contains(firstnameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(lastnameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(emailValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(ageValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(salaryValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(departmentValue));

        //Edit functionality

        WebElement editElement=driver.findElement(By.id("edit-record-4"));
        editElement.click();

        WebElement editfirstnameElement=driver.findElement(By.id("firstName"));
        String editfirstnameValue="Gojo1";
        editfirstnameElement.clear();
        editfirstnameElement.sendKeys(editfirstnameValue);

        WebElement editlastnameElement=driver.findElement(By.id("lastName"));
        String editlastnameValue="Satoru2";
        editlastnameElement.clear();
        editlastnameElement.sendKeys(editlastnameValue);

        WebElement edituserEmailElement=driver.findElement(By.id("userEmail"));
        String edituserEmailValue="gojo1.satoru2@gmail.com";
        edituserEmailElement.clear();
        edituserEmailElement.sendKeys(edituserEmailValue);

        WebElement editageElement=driver.findElement(By.id("age"));
        String editageValue="31";
        editageElement.clear();
        editageElement.sendKeys(editageValue);

        WebElement editsalaryElement=driver.findElement(By.id("salary"));
        String editsalaryValue="3333333";
        editsalaryElement.clear();
        editsalaryElement.sendKeys(editsalaryValue);

        WebElement editdepartmentElement=driver.findElement(By.id("department"));
        String editdepartmentValue="Sorcerer";
        editdepartmentElement.clear();
        editdepartmentElement.sendKeys(editdepartmentValue);

        WebElement editsubmitElement=driver.findElement(By.id("submit"));
        executor.executeScript("arguments[0].click();", editsubmitElement);

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(),tableSize+1, "Expected table size is not correct");

        Assert.assertTrue(tableList.get(tableSize).getText().contains(editfirstnameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editlastnameValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(edituserEmailValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editageValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editsalaryValue));
        Assert.assertTrue(tableList.get(tableSize).getText().contains(editdepartmentValue));

        //Delete Element

        WebElement deleteElement=driver.findElement(By.id("delete-record-4"));
        deleteElement.click();

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableList.size(),tableSize, "Expected table size: "+tableSize+" is not correct");
    }
}






















