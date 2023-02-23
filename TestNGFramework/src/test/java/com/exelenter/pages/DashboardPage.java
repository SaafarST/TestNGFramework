package com.exelenter.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.BaseClass.driver;

public class DashboardPage {
    @FindBy(id = "welcome")
    public WebElement welcome;
    @FindBy(xpath = "(//div[@id='branding']/a)[1]")
    public WebElement dashboardLogo;

    public DashboardPage(){
        PageFactory.initElements(driver,this);
    }
}
