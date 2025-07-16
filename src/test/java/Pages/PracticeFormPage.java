package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.util.List;

public class PracticeFormPage extends BasePage{
    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[placeholder='First Name']")
    public WebElement firstnameElement;

    @FindBy(css = "input[placeholder='Last Name']")
    public WebElement lastnameElement;

    @FindBy(css = "input[placeholder='name@example.com']")
    public WebElement emailElement;

    @FindBy(css = "input[placeholder='Mobile Number']")
    public WebElement mobileElement;

    @FindBy(id = "subjectsInput")
    public WebElement subjectsElement;

    @FindBy(css = "div[id='genterWrapper']>div>div>label[class='custom-control-label']")
    public List<WebElement> genderElementList;

    @FindBy(css = "div[id='hobbiesWrapper']>div>div>label[class='custom-control-label']")
    public List<WebElement> hobbiesElementList;

    @FindBy(id = "uploadPicture")
    public WebElement uploadElement;

    @FindBy(id = "currentAddress")
    public WebElement adressElement;

    @FindBy(id = "react-select-3-input")
    public WebElement stateInputElement;

    @FindBy(id = "react-select-4-input")
    public WebElement cityElement;

    @FindBy(id = "submit")
    public WebElement submitElement;

    @FindBy(xpath = "//table//td[1]")
    public List<WebElement> tableDescriptionList;

    @FindBy(xpath = "//table//td[2]")
    public List<WebElement> tableValueList;

    public void fillEntirePracticeForm(String firstNameValue, String lastNameValue, String emailValue, String mobileValue, List<String> subjectsValue, String genderValue,
                                       List<String> hobbiesValues, String uploadValue, String adressValue, String stateValue,
                                       String cityValue){
        pageHelper.waitImplicit();
        elementHelper.fillElement(firstnameElement,firstNameValue);
        elementHelper.fillElement(lastnameElement,lastNameValue);
        elementHelper.fillElement(emailElement,emailValue);
        elementHelper.fillElement(mobileElement,mobileValue);

        for (int index=0; index < subjectsValue.size(); index++){
            elementHelper.fillPressElement(subjectsElement, subjectsValue.get(index), Keys.ENTER);
        }

        switch (genderValue){
            case "Male":
                elementHelper.clickElement(genderElementList.get(0));
                break;
            case "Female":
                elementHelper.clickElement(genderElementList.get(1));
                break;
            case "Other":
                elementHelper.clickElement(genderElementList.get(2));
                break;
        }

        for(int index = 0; index<hobbiesElementList.size();index++){
            if(hobbiesValues.contains(hobbiesElementList.get(index).getText())){
                elementHelper.clickElement(hobbiesElementList.get(index));
            }
        }

        File file = new File(uploadValue);
        elementHelper.fillElement(uploadElement, file.getAbsolutePath());
        elementHelper.fillElement(adressElement,adressValue);
        elementHelper.fillPressElement(stateInputElement, stateValue,Keys.ENTER);
        elementHelper.fillPressElement(cityElement, cityValue,Keys.ENTER);
        elementHelper.clickElement(submitElement);
    }

    public void validateFormValues(String firstNameValue, String lastNameValue, String emailValue, String genderValue, String mobileValue, List<String> subjectsValue, List<String> hobbiesValues, String uploadValue,
                                   String adressValue, String stateValue, String cityValue){
        elementHelper.validateElementEqualsText(tableDescriptionList.get(0),"Student Name");
        elementHelper.validateElementContainsText(tableValueList.get(0), firstNameValue);
        elementHelper.validateElementContainsText(tableValueList.get(0), lastNameValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(1),"Student Email");
        elementHelper.validateElementEqualsText(tableValueList.get(1),emailValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(2),"Gender");
        elementHelper.validateElementEqualsText(tableValueList.get(2),genderValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(3),"Mobile");
        elementHelper.validateElementEqualsText(tableValueList.get(3),mobileValue);

        String actualSubjects = tableValueList.get(5).getText();
        elementHelper.validateElementEqualsText(tableDescriptionList.get(5),"Subjects");
        elementHelper.validateElementEqualsText(tableValueList.get(5),String.join(", ", subjectsValue));

        String actualHobbies = tableValueList.get(6).getText();
        elementHelper.validateElementEqualsText(tableDescriptionList.get(6),"Hobbies");
        elementHelper.validateElementEqualsText(tableValueList.get(6),String.join(", ", hobbiesValues));

        File fileF = new File(uploadValue);
        String fileName = fileF.getName(); // => "Map_alWnRyQmNq - Copy.png"

        elementHelper.validateElementEqualsText(tableDescriptionList.get(7),"Picture");
        elementHelper.validateElementEqualsText(tableValueList.get(7),fileName);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(8),"Address");
        elementHelper.validateElementEqualsText(tableValueList.get(8), adressValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(9),"State and City");
        elementHelper.validateElementContainsText(tableValueList.get(9), stateValue);
        elementHelper.validateElementContainsText(tableValueList.get(9), cityValue);
    }
}
