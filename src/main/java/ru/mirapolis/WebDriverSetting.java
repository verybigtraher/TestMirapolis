package ru.mirapolis;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverSetting {
    public ChromeDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","D:/For Testing/chromedriver.exe");


        driver = new ChromeDriver();


    }
    @After
    public void close() {
        //driver.quit();
    }

}
