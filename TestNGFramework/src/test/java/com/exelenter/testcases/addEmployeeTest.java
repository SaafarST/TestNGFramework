package com.exelenter.testcases;

import com.exelenter.base.BaseClass;
import com.exelenter.utils.ConfigsReader;
import org.testng.annotations.Test;


public class addEmployeeTest extends BaseClass {
    @Test(groups = "smoke")
    public void addEmployeeTest(){
        loginPage.loginToWebsite("username","password");
        pimPage.navigateToAddEmployee();
        System.out.println("New Employee ID: " + addEmployeePage.employeeId.getAttribute("value"));
        addEmployeePage.addEmployee("EXname","EXsurname","ExFilePath");
    }
}
