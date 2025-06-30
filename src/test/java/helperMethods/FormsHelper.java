package helperMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sharedData.SharedData;

public class FormsHelper extends SharedData {

    public WebDriver driver;

    public FormsHelper(WebDriver driver) {
        this.driver = driver;
    }

    public String firstNameValue;
    public String lastnameValue;
    public String emailValue;
    public String ageValue;
    public String salaryValue;
    public String departmentValue;
    public String mobileValue;

    public String editFirstNameValue;
    public String editLastnameValue;
    public String editEmailValue;
    public String editAgeValue;
    public String editSalaryValue;
    public String editDepartmentValue;

    public void fillWebTablesForm() {
        sendKeysById("firstName", firstNameValue);
        sendKeysById("lastName", lastnameValue);
        sendKeysById("userEmail", emailValue);
        sendKeysById("age", ageValue);
        sendKeysById("salary", salaryValue);
        sendKeysById("department", departmentValue);
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

    public void editFillWebTablesForm() {
        editSendKeys("firstName", editFirstNameValue);
        editSendKeys("lastName", editLastnameValue);
        editSendKeys("userEmail", editEmailValue);
        editSendKeys("age", editAgeValue);
        editSendKeys("salary", editSalaryValue);
        editSendKeys("department", editDepartmentValue);
    }

    public void fillPracticeForm(){
        sendKeysCSS("input[placeholder='First Name']", firstNameValue);
        sendKeysCSS("input[placeholder='Last Name']", lastnameValue);
        sendKeysCSS("input[placeholder='name@example.com']", emailValue);
        sendKeysCSS("input[placeholder='Mobile Number']", mobileValue);
    }
}