package com.exelenter.utils;

import org.openxmlformats.schemas.drawingml.x2006.main.STAdjAngle;

public class  Constants {
    public static final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver";
    public static final String GECKO_DRIVER_PATH = System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver ";
    public static final String MSEDGE_DRIVER_PATH = System.getProperty("user.dir") + "/src/test/resources/drivers/msedgedriver";
    public static final String CONFIGURATION_FILEPATH = System.getProperty("user.dir") + "/src/test/resources/configs/configuration.properties";

    public static final String TESTDATA_FILEPATH = System.getProperty("user.dir") + "/src/test/resources/testdata/ExelenterEmployeesList.xlsx";

    public static final String REPORT_FILEPATH = System.getProperty("user.dir") + "/target/html-report/reports.html";
    public static final int IMPLICIT_WAIT_TIME = 5;
    public static final int EXPLICIT_WAIT_TIME = 15;

}
