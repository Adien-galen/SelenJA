package test.java.pageobject;

import org.openqa.selenium.WebElement;
import test.java.common.OperateElement;

/**
 * Author: 灵枢
 * Date: 2019/6/12
 * Time: 17:40
 * Description: 百度搜索元素及操作封装
 */
public class BaiduPO {

    /**
     * 搜索框
     * @return
     */
    public static WebElement searchInput(){
        return OperateElement.waitById("kw");
    }

    /**
     * 百度一下 按钮
     * @return
     */
    public static WebElement searchBtn(){
        return OperateElement.waitById("su");
    }

    /**
     * 搜索结果的第几行
     * @param row  第几行
     * @return
     */
    public static WebElement searchResult(int row){
        String xpath = "//*[@id='"+row+"']/h3/a";
        return OperateElement.waitByXpath(xpath);
    }

    /**
     * 搜索操作
     * @param keywords
     */
    public static void search(String keywords){
        searchInput().clear();
        searchInput().sendKeys(keywords);
        searchBtn().click();
        OperateElement.threadSleep(2000);
    }

    /**
     * 使用用户名登录
     * @param username
     * @param password
     */
    public static void login(String username,String password){
        OperateElement.clickByXpath("//p[text()='用户名登录']");
        OperateElement.sendKeysById("TANGRAM__PSP_10__userName",username);
        OperateElement.sendKeysById("TANGRAM__PSP_10__password",password);
        OperateElement.clickById("TANGRAM__PSP_10__submit");
    }
}
