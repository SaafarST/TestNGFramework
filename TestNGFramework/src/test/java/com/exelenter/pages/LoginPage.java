package com.exelenter.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseClass;
import utils.ConfigsReader;

// Note: This is just a template for LoginPage where we store everything related to Login page here, in this class.
//  In Page Object Model (Design Pattern), we organize our code by pages. Each web page will have their own class.
public class LoginPage extends BaseClass {

    @FindBy(id = "txtUsername")
    public WebElement username;

    public @FindBy(name = "txtPassword")
    WebElement password;

    @FindBy(id = "btnLogin")
    public WebElement loginBtn;

    @FindBy(css = "#divLogo img")
    public WebElement homepageLogo;
    @FindBy(id = "spanMessage")
    public WebElement loginErrorMessage;
    public LoginPage() {
        PageFactory.initElements(driver,this);
    }

    public void loginToWebsite(String user, String pswd){
        sendText(username, ConfigsReader.getProperties(user));
        sendText(password, ConfigsReader.getProperties(pswd));
        clickButWaitForClickability(loginBtn);
    }
    public void loginToWebsite1(String user, String pswd){
        sendText(username, user);
        sendText(password, pswd);
        clickButWaitForClickability(loginBtn);
    }
}
