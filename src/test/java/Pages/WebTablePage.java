package Pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebTablePage extends BasePage{

    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='rt-tr -even' or @class='rt-tr -odd']")
    private List<WebElement> tableList;

    @FindBy(id = "addNewRecordButton")
    private WebElement addElement;

    @FindBy(id = "firstName")
    private WebElement firstnameElement;
    @FindBy(id = "lastName")
    private WebElement lastnameElement;
    @FindBy(id = "userEmail")
    private WebElement emailElement;
    @FindBy(id = "age")
    private WebElement ageElement;
    @FindBy(id = "salary")
    private WebElement salaryElement;
    @FindBy(id = "department")
    private WebElement departmentElement;
    @FindBy(id = "submit")
    private WebElement submitElement;

    @FindBy(id = "edit-record-4")
    private WebElement editElement;

    @FindBy(id = "firstName")
    private WebElement editfirstnameElement;
    @FindBy(id = "lastName")
    private WebElement editlastnameElement;
    @FindBy(id = "userEmail")
    private WebElement edituserEmailElement;
    @FindBy(id = "age")
    private WebElement editageElement;
    @FindBy(id = "salary")
    private WebElement editsalaryElement;
    @FindBy(id = "department")
    private WebElement editdepartmentElement;

    @FindBy(id = "delete-record-4")
    private WebElement deleteElement;

    public void addNewEntry(int tableSize, String firstNameValue, String lastNameValue, String emailValue,String ageValue,String salaryValue, String departmentValue){

        elementHelper.validateListSize(tableList,tableSize);
        LoggerUtility.infoLog("The user validates that the table has "+tableSize+" rows");
        clickAddButton();
        fillFirstName(firstNameValue);
        fillLastName(lastNameValue);
        fillEmail(emailValue);
        fillAge(ageValue);
        fillSalary(salaryValue);
        fillDepartment(departmentValue);
        clickSubmitButton();


        elementHelper.validateListSize(tableList,tableSize+1);
        LoggerUtility.infoLog("The user validates that the table has "+tableSize+1+" rows");

        elementHelper.validateElementContainsText(tableList.get(tableSize),firstNameValue);
        LoggerUtility.infoLog("The user validates that the table contains "+firstNameValue+" value");

        elementHelper.validateElementContainsText(tableList.get(tableSize),lastNameValue);
        LoggerUtility.infoLog("The user validates that the table contains "+lastNameValue+" value");

        elementHelper.validateElementContainsText(tableList.get(tableSize),emailValue);
        LoggerUtility.infoLog("The user validates that the table contains "+emailValue+" value");

        elementHelper.validateElementContainsText(tableList.get(tableSize),ageValue);
        LoggerUtility.infoLog("The user validates that the table contains "+ageValue+" value");

        elementHelper.validateElementContainsText(tableList.get(tableSize),salaryValue);
        LoggerUtility.infoLog("The user validates that the table contains "+salaryValue+" value");

        elementHelper.validateElementContainsText(tableList.get(tableSize),departmentValue);
        LoggerUtility.infoLog("The user validates that the table contains "+departmentValue+" value");
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
        LoggerUtility.infoLog("The user validates that the table has "+tableSize+1+" rows");

        elementHelper.validateElementContainsText(tableList.get(tableSize),editfirstnameValue);
        LoggerUtility.infoLog("The user validates that the table contains "+editfirstnameValue+" value");

        elementHelper.validateElementContainsText(tableList.get(tableSize),editlastnameValue);
        LoggerUtility.infoLog("The user validates that the table contains "+editlastnameValue+" value");

        elementHelper.validateElementContainsText(tableList.get(tableSize),edituserEmailValue);
        LoggerUtility.infoLog("The user validates that the table contains "+edituserEmailValue+" value");

        elementHelper.validateElementContainsText(tableList.get(tableSize),editageValue);
        LoggerUtility.infoLog("The user validates that the table contains "+editageValue+" value");

        elementHelper.validateElementContainsText(tableList.get(tableSize),editsalaryValue);
        LoggerUtility.infoLog("The user validates that the table contains "+editsalaryValue+" value");

        elementHelper.validateElementContainsText(tableList.get(tableSize),editdepartmentValue);
        LoggerUtility.infoLog("The user validates that the table contains "+editdepartmentValue+" value");
    }

    public void deleteNewEntry(int tableSize){
        clickDeleteButton();
        elementHelper.validateListSize(tableList,tableSize);
        LoggerUtility.infoLog("The user validates that the table has "+tableSize+" rows");
    }


    public void clickAddButton(){
        elementHelper.clickElement(addElement);
        LoggerUtility.infoLog("The user clicks on add button");
    }

    public void fillFirstName(String firstNameValue){
        elementHelper.fillElement(firstnameElement,firstNameValue);
        LoggerUtility.infoLog("The user fills first name field with value: "+firstNameValue);
    }

    public void fillLastName(String lastNameValue){
        elementHelper.fillElement(lastnameElement,lastNameValue);
        LoggerUtility.infoLog("The user fills last name field with value: "+lastNameValue);
    }

    public void fillEmail(String emailValue){
        elementHelper.fillElement(emailElement,emailValue);
        LoggerUtility.infoLog("The user fills email field with value: "+emailValue);
    }

    public void fillAge(String ageValue){
        elementHelper.fillElement(ageElement,ageValue);
        LoggerUtility.infoLog("The user fills age field with value: "+ageValue);
    }

    public void fillSalary(String salaryValue){
        elementHelper.fillElement(salaryElement,salaryValue);
        LoggerUtility.infoLog("The user fills salary field with value: "+salaryValue);
    }

    public void fillDepartment(String departmentValue){
        elementHelper.fillElement(departmentElement,departmentValue);
        LoggerUtility.infoLog("The user fills department field with value: "+departmentValue);
    }

    public void clickSubmitButton(){
        elementHelper.clickJSElement(submitElement);
        LoggerUtility.infoLog("The user clicks on submit button");
    }

    public void clickEditButton(){
        elementHelper.clickElement(editElement);
        LoggerUtility.infoLog("The user clicks on edit button");
    }

    public void fillEditFirstName(String firstNameValue){
        elementHelper.clearFillElement(editfirstnameElement,firstNameValue);
        LoggerUtility.infoLog("The user fills first name field with value: "+firstNameValue);
    }

    public void fillEditLastName(String lastNameValue){
        elementHelper.clearFillElement(editlastnameElement,lastNameValue);
        LoggerUtility.infoLog("The user fills last name field with value: "+lastNameValue);
    }

    public void fillEditEmail(String emailValue){
        elementHelper.clearFillElement(edituserEmailElement,emailValue);
        LoggerUtility.infoLog("The user fills email field with value: "+emailValue);
    }

    public void fillEditAge(String ageValue){
        elementHelper.clearFillElement(editageElement,ageValue);
        LoggerUtility.infoLog("The user fills age field with value: "+ageValue);
    }

    public void fillEditSalary(String salaryValue){
        elementHelper.clearFillElement(editsalaryElement,salaryValue);
        LoggerUtility.infoLog("The user fills salary field with value: "+salaryValue);
    }

    public void fillEditDepartment(String departmentValue){
        elementHelper.clearFillElement(editdepartmentElement,departmentValue);
        LoggerUtility.infoLog("The user fills department field with value: "+departmentValue);
    }

    public void clickDeleteButton(){
        elementHelper.clickElement(deleteElement);
        LoggerUtility.infoLog("The user clicks on delete button");
    }
}
