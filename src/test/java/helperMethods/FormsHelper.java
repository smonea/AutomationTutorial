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
        sendKeys("firstName", firstNameValue);
        sendKeys("lastName", lastnameValue);
        sendKeys("userEmail", emailValue);
        sendKeys("age", ageValue);
        sendKeys("salary", salaryValue);
        sendKeys("department", departmentValue);
    }

    public void sendKeys(String id, String value) {
        WebElement element = driver.findElement(By.id(id));
        element.sendKeys(value);
    }

    private void editSendKeys(String id, String value) {
        WebElement element = driver.findElement(By.id(id));
        element.clear();
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
        sendKeys("input[placeholder='First Name']", firstNameValue);
        sendKeys("input[placeholder='Last Name']", lastnameValue);
        sendKeys("input[placeholder='name@example.com']", emailValue);
        editSendKeys("input[placeholder='Mobile Number']", mobileValue);
    }
}