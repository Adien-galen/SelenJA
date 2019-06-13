package test.java.cases;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.common.BaseTest;
import test.java.common.OperateElement;
import test.java.pageobject.SogouPO;
import test.java.utils.ReadProperties;

/**
 * Author: 灵枢
 * Date: 2019/6/12
 * Time: 18:07
 * Description:
 */
public class SogouTest extends BaseTest {

    @Test
    public void test搜狗搜索(){
        String keywords = envProperties.getProperty("keywords");
        String sogouUrl = envProperties.getProperty("sogou.url");
        driver.get(sogouUrl);
        SogouPO.search(keywords);
        //验证搜索结果第一行是否包含“galen2016的博客”
        String firstResult = OperateElement.waitByXpath("(//*[@class='vrTitle']/a)[1]").getText();
        Assert.assertTrue(firstResult.contains("galen2016的博客"));
    }
}
