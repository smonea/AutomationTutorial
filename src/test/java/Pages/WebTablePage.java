package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebTablePage extends BasePage{

    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='rt-tr -even' or @class='rt-tr -odd']")
    public List<WebElement> tableList;

    @FindBy(id = "addNewRecordButton")
    public WebElement addElement;

    @FindBy(id = "firstName")
    public WebElement firstnameElement;
    @FindBy(id = "lastName")
    public WebElement lastnameElement;
    @FindBy(id = "userEmail")
    public WebElement emailElement;
    @FindBy(id = "age")
    public WebElement ageElement;
    @FindBy(id = "salary")
    public WebElement salaryElement;
    @FindBy(id = "department")
    public WebElement departmentElement;
    @FindBy(id = "submit")
    public WebElement submitElement;

    @FindBy(id = "edit-record-4")
    public WebElement editElement;

    @FindBy(id = "firstName")
    public WebElement editfirstnameElement;
    @FindBy(id = "lastName")
    public WebElement editlastnameElement;
    @FindBy(id = "userEmail")
    public WebElement edituserEmailElement;
    @FindBy(id = "age")
    public WebElement editageElement;
    @FindBy(id = "salary")
    public WebElement editsalaryElement;
    @FindBy(id = "department")
    public WebElement editdepartmentElement;

    @FindBy(id = "delete-record-4")
    public WebElement deleteElement;

    public void addNewEntry(int tableSize, String firstNameValue, String lastNameValue, String emailValue,String ageValue,String salaryValue, String departmentValue){

        elementHelper.validateListSize(tableList,tableSize);

        clickAddButton();
        fillFirstName(firstNameValue);
        fillLastName(lastNameValue);
        fillEmail(emailValue);
        fillAge(ageValue);
        fillSalary(salaryValue);
        fillDepartment(departmentValue);
        clickSubmitButton();

        elementHelper.validateListSize(tableList,tableSize+1);
        elementHelper.validateElementContainsText(tableList.get(tableSize),firstNameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),lastNameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),emailValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),ageValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),salaryValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),departmentValue);
    }

    public void editNewEntry(int tableSize, String editfirstnameValue, String editlastnameValue, String edituserEmailValue,String editageValue,String editsalaryValue, String editdepartmentValue){

        clickEditButton();
        fillEditFirstName(editfirstnameValue);
        fillEditLastName(editlastnameValue);
        fillEditEmail(edituserEmailValue);
        fillEditAge(editageValue);
        fillEditSalary(editsalaryValue);
        fillEditDepartment(editdepartmentValue);
        clickSubmitButton();

        elementHelper.validateListSize(tableList,tableSize+1);

        elementHelper.validateElementContainsText(tableList.get(tableSize),editfirstnameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),editlastnameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),edituserEmailValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),editageValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),editsalaryValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize),editdepartmentValue);

    }

    public void deleteNewEntry(int tableSize){
        clickDeleteButton();
        elementHelper.validateListSize(tableList,tableSize);
    }


    public void clickAddButton(){
        elementHelper.clickElement(addElement);
    }

    public void fillFirstName(String firstNameValue){
        elementHelper.fillElement(firstnameElement,firstNameValue);
    }

    public void fillLastName(String lastNameValue){
        elementHelper.fillElement(lastnameElement,lastNameValue);
    }

    public void fillEmail(String emailValue){
        elementHelper.fillElement(emailElement,emailValue);
    }

    public void fillAge(String ageValue){
        elementHelper.fillElement(ageElement,ageValue);
    }

    public void fillSalary(String salaryValue){
        elementHelper.fillElement(salaryElement,salaryValue);
    }

    public void fillDepartment(String departmentValue){
        elementHelper.fillElement(departmentElement,departmentValue);
    }

    public void clickSubmitButton(){
        elementHelper.clickJSElement(submitElement);
    }

    public void clickEditButton(){
        elementHelper.clickElement(editElement);
    }

    public void fillEditFirstName(String firstNameValue){
        elementHelper.clearFillElement(editfirstnameElement,firstNameValue);
    }

    public void fillEditLastName(String lastNameValue){
        elementHelper.clearFillElement(editlastnameElement,lastNameValue);
    }

    public void fillEditEmail(String emailValue){
        elementHelper.clearFillElement(edituserEmailElement,emailValue);
    }

    public void fillEditAge(String ageValue){
        elementHelper.clearFillElement(editageElement,ageValue);
    }

    public void fillEditSalary(String salaryValue){
        elementHelper.clearFillElement(editsalaryElement,salaryValue);
    }

    public void fillEditDepartment(String departmentValue){
        elementHelper.clearFillElement(editdepartmentElement,departmentValue);
    }

    public void clickDeleteButton(){
        elementHelper.clickElement(deleteElement);
    }
}
