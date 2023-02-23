package com.exelenter.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.BaseClass;
import utils.ConfigsReader;

public class AddEmployeePage extends BaseClass {
    @FindBy(id = "firstName")
    public WebElement firstName;
    @FindBy(id = "lastName")
    public WebElement lastName;
    @FindBy(id = "employeeId")
    public WebElement employeeId;
    @FindBy(id = "photofile")
    public WebElement uploadPhoto;
    @FindBy(id = "btnSave")
    public WebElement saveButton;
    @FindBy(id = "chkLogin")
    public WebElement checkLogin;
    @FindBy(id = "user_name")
    public WebElement userName;
    @FindBy(id = "user_password")
    public WebElement EmployeePassword;
    @FindBy(id = "re_password")
    public WebElement confirmEmployeePassword;
    @FindBy(id = "status")
    public Select status;

    public AddEmployeePage() {
        PageFactory.initElements(driver, this);
    }

    public void addEmployee(String name,String surname, String filePath){
//        var loginPage = new LoginPage();// Happy Path Testing
//        loginPage.loginToWebsite(ConfigsReader.getProperties("username"),ConfigsReader.getProperties("password"));
//
//        PIMPage pimPage = new PIMPage();
//        pimPage.navigateToAddEmployee();
//
//        AddEmployeePage addEmployee = new AddEmployeePage();
//        sendText(addEmployee.firstName,ConfigsReader.getProperties("name"));
//        sendText(addEmployee.lastName,ConfigsReader.getProperties("surname"));
//        sendText(addEmployee.uploadPhoto, ConfigsReader.getProperties("filePath"));
//        click(addEmployee.saveButton);
        sendText(firstName, ConfigsReader.getProperties(name));
        sendText(lastName, ConfigsReader.getProperties(surname));
        sendText(uploadPhoto, ConfigsReader.getProperties(filePath));
        click(saveButton);
    }
//    public void addEmployee(String firstName,String lastName, int age){
//
//        sendText(firstName, firstName);
//        sendText(lastName, ConfigsReader.getProperties(surname));
//        sendText(uploadPhoto, ConfigsReader.getProperties(filePath));
//        click(saveButton);
//    }
}
