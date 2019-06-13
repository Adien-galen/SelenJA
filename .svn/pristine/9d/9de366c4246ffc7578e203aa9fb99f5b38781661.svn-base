package test.java.pageobject;

import org.openqa.selenium.WebElement;
import test.java.common.OperateElement;

/**
 * Author: 灵枢
 * Date: 2019/6/12
 * Time: 18:09
 * Description:搜狗搜索页面封装
 */
public class SogouPO {

    /**
     * 搜索框
     * @return
     */
    public static WebElement searchInput(){
        return OperateElement.waitById("query");
    }

    /**
     * 搜索按钮
     * @return
     */
    public static WebElement searchBtn(){
        return OperateElement.waitById("stb");
    }

    /**
     * 搜索操作封装
     * @param keywords
     */
    public static void search(String keywords){
        searchInput().clear();
        searchInput().sendKeys(keywords);
        searchBtn().click();
        OperateElement.threadSleep(2000);
    }


}
