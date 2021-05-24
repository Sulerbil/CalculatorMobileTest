package com.calculator;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileTestCalculator {

    static AppiumDriver<MobileElement> driver;

    public static void main(String[] args) {

        try {
            calculator();
        }catch (Exception exp){
            exp.getCause();
            exp.getMessage();
        }

    }

    public static void calculator() throws Exception {
        //capability tanimla

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName","Sule");
        dc.setCapability("udid","R5CR20VZGXY");
        dc.setCapability("platformName","Android");
        dc.setCapability("platformVersion","11");

        dc.setCapability("appPackage","com.google.android.calculator");
        dc.setCapability("appActivity","com.android.calculator2.Calculator");

       URL url = new URL("http://127.0.0.1:4723/wd/hub");

       driver = new AppiumDriver<MobileElement>(url, dc);

       MobileElement three = driver.findElement(By.id("com.google.android.calculator:id/digit_3"));
       MobileElement mult = driver.findElement(By.id("com.google.android.calculator:id/op_mul"));
       MobileElement five = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
       MobileElement equal = driver.findElement(By.id("com.google.android.calculator:id/eq"));

       three.click();
       mult.click();
       five.click();
       equal.click();

       MobileElement result = driver.findElement(By.id("com.google.android.calculator:id/result_final"));

       String resultPrint = result.getText();
        System.out.println("resultPrint = " + resultPrint);


    }


}
