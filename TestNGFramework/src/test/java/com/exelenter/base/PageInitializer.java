package com.exelenter.base;

import pages.*;

public class PageInitializer {
    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;
    public static AddEmployeePage addEmployeePage;
    public static pages.pimPage pimPage;
    public static PersonalDetailsPage personalDetailsPage;

    public static void initialize() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        addEmployeePage = new AddEmployeePage();
        pimPage = new pimPage();
        personalDetailsPage = new PersonalDetailsPage();
    }
}
