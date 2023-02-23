package com.exelenter.pages;

import com.exelenter.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import static com.exelenter.utils.CommonMethods.click;

public class PIMPage extends BaseClass {
    @FindBy(id = "menu_pim_viewPimModule")
    public WebElement PIM;
    @FindBy(id = "menu_pim_viewEmployeeList")
    public WebElement employeeList;
    @FindBy(id = "menu_pim_addEmployee")
    public WebElement addEmployee;

    public PIMPage() {
        PageFactory.initElements(driver,this);
    }
    public void navigateToAddEmployee(){
        click(PIM);
        click(addEmployee);
    }
}
