package com.exelenter.testcases;

import com.exelenter.base.BaseClass;
import com.exelenter.utils.Constants;
import com.exelenter.utils.ExcelUtility;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

public class AddEmployeeFromExcel extends BaseClass {
    /*
      Task: HW: Add Employees using Data Provider Annotation
             1.  Open the Chrome browser
             2.  Go to https://exelentersdet.com/
             3.  Login into the application
             4.  Navigate to Add Employee Page
             5.  Add 5 different Employees and create login credentials by providing:
                     - First Name
                     - Last Name
                     - Username
                     - Password
             6.  Verify Employee has been added successfully and take screenshots (you
                  must have 5 different screenshots)
             7.  Close the browser
                  BONUS: Specify a group name for this test case, and execute from the
                  XML file.
     */
    @Test(dataProvider = "readFromExcel", groups = {"smoke","regression", "excel"})
    public void loginTest(String firstName, String lastName, String username, String password) {

        //Login to website:
        loginPage.loginToWebsite("username","password");
        //Navigate to Add Employee Page:
        pimPage.navigateToAddEmployee();
        //Add name and surname:
        sendText(addEmployeePage.firstName, firstName);
        sendText(addEmployeePage.lastName, lastName);
        String expectedEmployeeId = addEmployeePage.employeeId.getAttribute("value");
        //click to Create login details
        click(addEmployeePage.checkLogin);
        //Add Username and password, reaffirm password
        sendText(addEmployeePage.userName, username);
        sendText(addEmployeePage.EmployeePassword, password);
        sendText(addEmployeePage.confirmEmployeePassword, password);
        //Click save button
        click(addEmployeePage.saveButton);
        waitForVisibility(personalDetailsPage.personalDetailsHeader);

        //takeScreenshot1 Method modified to for this assignment, scroll down to the end to see the method
        takeScreenshot1(firstName,lastName);

        try {
            boolean headerDisplayed = personalDetailsPage.personalDetailsHeader.isDisplayed();
            if (headerDisplayed) {
                String actualEmployeeId = personalDetailsPage.employeeID.getAttribute("value");
                assertEquals(actualEmployeeId, expectedEmployeeId, "Employee ID does not match");
                takeScreenshot(firstName + "_" + lastName);
                System.out.println("The new employee is added successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException("Employee is not added. Username or ID already exits.");
        }
    }

    @DataProvider(name = "readFromExcel")
    public Object[][] getDataFromExcel(){
        //String absolutePath = ExcelUtility.projectPath + "/testData/ExelenterEmployeesList.xlsx";  //Don't forget slash in front of testData
        return ExcelUtility.readFromExcel(Constants.TESTDATA_FILEPATH, "Employee");
    }

}

