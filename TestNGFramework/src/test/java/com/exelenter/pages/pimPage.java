package com.exelenter.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseClass;

public class pimPage extends BaseClass {
    @FindBy(id = "menu_pim_viewPimModule")
    public WebElement PIM;
    @FindBy(id = "menu_pim_viewEmployeeList")
    public WebElement employeeList;
    @FindBy(id = "menu_pim_addEmployee")
    public WebElement addEmployee;

    public pimPage() {
        PageFactory.initElements(driver,this);
    }
    public void navigateToAddEmployee(){
        click(PIM);
        click(addEmployee);
    }
}
