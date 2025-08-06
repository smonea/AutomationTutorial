package tests;

import Pages.FormsPage;
import Pages.IndexPage;
import Pages.PracticeFormPage;
import org.testng.annotations.Test;
import sharedData.SharedData;
import suite.Suite;

import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test(groups = {Suite.REGRESSION_SUITE,Suite.FORMS_SUITE})

    public void testMethodd(){

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.interactWithFormsMenu();

        FormsPage formsPage = new FormsPage(getDriver());
        formsPage.interactWithPracticeFormMenu();

        String firstNameValue = "Satoru";
        String lastNameValue = "Gojo";
        String emailValue = "gojo.satoru@gmail.com";
        String mobileValue = "2223334443";
        List<String> subjectsValue = Arrays.asList("Arts","Accounting","Maths");
        String genderValue="Male";
        List<String> hobbiesValues = Arrays.asList("Sports","Music");
        String uploadValue = "src/test/resources/Map_alWnRyQmNq - Copy.png";
        String adressValue="Strada 10";
        String stateValue ="NCR";
        String cityValue ="Delhi";

        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.fillEntirePracticeForm(firstNameValue,lastNameValue,emailValue,mobileValue,subjectsValue,genderValue,hobbiesValues,uploadValue,adressValue,stateValue,cityValue);

        practiceFormPage.validateFormValues(firstNameValue, lastNameValue, emailValue, genderValue, mobileValue, subjectsValue, hobbiesValues, uploadValue, adressValue, stateValue, cityValue);

    }
}


























