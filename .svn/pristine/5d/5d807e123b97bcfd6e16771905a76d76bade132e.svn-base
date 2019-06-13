package test.java.cases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.common.BaseTest;
import test.java.common.OperateElement;
import test.java.pageobject.BaiduPO;

/**
 * Author: 灵枢
 * Date: 2018/12/4
 * Time: 16:07
 * Description:
 */

public class BaiduTest extends BaseTest {

    private String baiduUrl;

    @BeforeMethod
    public void beforeMethod(){
        baiduUrl = envProperties.getProperty("baidu.url");
    }

    @Test
    public void test百度搜索(){
        String keywords = envProperties.getProperty("keywords");
        driver.get(baiduUrl);
        BaiduPO.search(keywords);
        BaiduPO.searchResult(1).click();
        //切换到第二个窗口
        OperateElement.switchToWindowByIndex(1);
        //获取博客页的titleName
        String titleName = OperateElement.waitByXpath("//*[@class='lt_title']").getText().trim();
        //验证titleName是否正确
        Assert.assertTrue(titleName.contains("灵枢"),"title不对，显示的是:"+titleName);
    }

    @Test
    public void test百度登录(){
        //读取配置文件中的账号密码
        String username = envProperties.getProperty("baidu.username");
        String password = envProperties.getProperty("baidu.password");
        //回到第一个窗口
        OperateElement.closeWindowHandleNotFirst();
        driver.get(baiduUrl);
        OperateElement.clickByLinkText("登录");
        BaiduPO.login(username,password);
        //验证用户名是否存在
        boolean exsit = OperateElement.isElementExsit(OperateElement.waitByClassName("user-name"));
        Assert.assertTrue(exsit);
    }
}
