package test.java.common;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import test.java.utils.ReadProperties;

import java.util.Properties;

/**
 * Author: 灵枢
 * Date: 2019/3/28
 * Time: 17:11
 * Description:
 */

public class BaseTest {
    public ChromeDriver driver;
    public Properties envProperties;

    public ChromeDriver getDriver(){
        return driver;
    }

    @BeforeClass
    public void setUp(){
        //初始化webdriver
        driver = InitDriver.launchChromeDriver();
        OperateElement.driver = driver;
        //读取配置文件
        envProperties = ReadProperties.readProperties("env.properties");
    }

    @AfterClass(enabled = false)
    public void tearDown() {
         driver.quit();
    }

}
