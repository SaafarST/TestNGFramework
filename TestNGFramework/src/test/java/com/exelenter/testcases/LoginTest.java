package com.exelenter.testcases;


import com.exelenter.base.BaseClass;
import com.exelenter.utils.ConfigsReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.exelenter.base.PageInitializer.dashboardPage;
import static com.exelenter.base.PageInitializer.loginPage;
import static com.exelenter.utils.CommonMethods.click;
import static com.exelenter.utils.CommonMethods.sendText;

public class LoginTest extends BaseClass {
    /**
     *  US 16457: As an Admin User, I should not be able to login to the application using invalid credentials.    <== High Level explanation of the feature.
     */
   @Test(groups = "smoke")
    public void validAdminLogin(){

       loginPage.loginToWebsite("username","password");
       String expectedValue = "Welcome Admin";
       String actualValue = dashboardPage.welcome.getText();
       Assert.assertEquals(actualValue,expectedValue,"'Welcome Admin' text is incorrect");
   }
   @Test(groups = "smoke")
    public void validUserInvalidPassword(){
       String invalidPassword = "MineLibe";
       String expectedErrorMessage = "Invalid credentials";
       sendText(loginPage.username, ConfigsReader.getProperties("username"));
       sendText(loginPage.password, invalidPassword);
       click(loginPage.loginBtn);
       Assert.assertEquals(loginPage.loginErrorMessage,expectedErrorMessage,"Error message is incorrect.");
   }
    @Test(groups = "smoke")
    public void validUserEmptyPassword() {
        String expectedErrorMessage = "Password cannot be empty";

        sendText(loginPage.username, ConfigsReader.getProperties("username"));   // Valid Username, Password empty (skipped).
        click(loginPage.loginBtn);
        Assert.assertEquals(loginPage.loginErrorMessage.getText(),expectedErrorMessage, "Error message is incorrect");
    }
}
