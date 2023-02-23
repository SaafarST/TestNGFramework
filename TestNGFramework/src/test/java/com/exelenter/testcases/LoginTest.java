package com.exelenter.testcases;


import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.ConfigsReader;

public class LoginTest extends BaseClass {
    /**
     *  US 16457: As an Admin User, I should not be able to login to the application using invalid credentials.    <== High Level explanation of the feature.
     */
   @Test
    public void validAdminLogin(){

       loginPage.loginToWebsite("username","password");
       String expectedValue = "Welcome Admin";
       String actualValue = dashboardPage.welcome.getText();
       Assert.assertEquals(actualValue,expectedValue,"'Welcome Admin' text is incorrect");
   }
   @Test
    public void validUserInvalidPassword(){
       String invalidPassword = "MineLibe";
       String expectedErrorMessage = "Invalid credentials";
       sendText(loginPage.username, ConfigsReader.getProperties("username"));
       sendText(loginPage.password, invalidPassword);
       click(loginPage.loginBtn);
       Assert.assertEquals(loginPage.loginErrorMessage,expectedErrorMessage,"Error message is incorrect.");
   }
    @Test
    public void validUserEmptyPassword() {
        String expectedErrorMessage = "Password cannot be empty";

        sendText(loginPage.username, ConfigsReader.getProperties("username"));   // Valid Username, Password empty (skipped).
        click(loginPage.loginBtn);
        Assert.assertEquals(loginPage.loginErrorMessage.getText(),expectedErrorMessage, "Error message is incorrect");
    }
}
