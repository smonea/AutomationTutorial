package tests;

import Pages.ElementsPage;
import Pages.IndexPage;
import Pages.WebTablePage;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class WebTablesTest extends SharedData {

    @Test
    public void testMethod(){

        IndexPage indexPage = new IndexPage(driver);
        indexPage.interactWithElementsMenu();

        ElementsPage elementsPage = new ElementsPage(driver);
        elementsPage.interactWithWebTablesSubMenu();

        int tableSize = 3;
        String firstNameValue = "Satoru";
        String lastNameValue = "Gojo";
        String emailValue = "gojo.satoru@gmail.com";
        String ageValue="27";
        String salaryValue="33445455";
        String departmentValue="Testing";
        String editfirstnameValue="Gojo1";
        String editlastnameValue="Satoru2";
        String edituserEmailValue="gojo1.satoru2@gmail.com";
        String editageValue="31";
        String editsalaryValue="3333333";
        String editdepartmentValue="Sorcerer";

        WebTablePage webTablePage = new WebTablePage(driver);
        webTablePage.addNewEntry(tableSize,firstNameValue,lastNameValue,emailValue,ageValue,salaryValue,departmentValue);

        webTablePage.editNewEntry(tableSize, editfirstnameValue, editlastnameValue, edituserEmailValue,editageValue,editsalaryValue,editdepartmentValue);

        webTablePage.deleteNewEntry(tableSize);
    }
}






















