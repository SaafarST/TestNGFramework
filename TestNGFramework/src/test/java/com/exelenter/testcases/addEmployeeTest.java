package com.exelenter.testcases;

import org.testng.annotations.Test;
import utils.BaseClass;
import utils.ConfigsReader;

public class addEmployeeTest extends BaseClass {
    @Test
    public void addEmployeeTest(){
        loginPage.loginToWebsite(ConfigsReader.getProperties("username"),ConfigsReader.getProperties("password"));
        pimPage.navigateToAddEmployee();
        System.out.println("New Employee ID: " + addEmployeePage.employeeId.getAttribute("value"));
        addEmployeePage.addEmployee("EXname","EXsurname","ExFilePath");
    }
}
