# SelenJA
## 简介
SelenJA是我封装的一个基于selenium+testng的自动化测试框架，使用Jenkins来跑自动化用例，并在Jenkins中使用了Allure插件来显示测试报告
# GitHub
https://github.com/Adien-galen/SelenJA   欢迎点star
# 技术栈
  - Java
  - maven
  - selenium
  - testng
  - allure
  - Jenkins

# 优点
- 封装selenium对元素、浏览器的操作，使用起来更简单
- 使用PageObject模式对页面元素和公共操作进行封装
- 环境信息通过读取配置文件获取
- 失败用例重跑
- 使用allure显示测试报告，提供失败截图、操作步骤、期望结果
- 使用testng单元测试框架，方便用例的组织以及运行时参数的传递
# 一个例子

```
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
```

# 常用API介绍
- 初始化webdriver
```
InitDriver.launchChromeDriver()		//初始化chromedrive配置，并返回一个driver
```
- 元素操作
```
 OperateElement.waitByXpath(String xpath)   //通过元素的Xpath，等待元素的出现,返回此元素
```

```
 OperateElement.waitById(String id)   //通过元素的id，等待元素的出现,返回此元素
```

```
 OperateElement.waitByAttribute(String attribute,String value)   //通过元素的某个属性，等待元素的出现,返回此元素
```

```
 OperateElement.waitElesByXpath(String xpath)   //通过元素的xpath，等待元素列表的出现,返回List<WebElement>
```

```
OperateElement.waitElesByClassName(String className)   //通过元素的className，等待元素列表的出现,返回List<WebElement>
```

```
OperateElement.clickByText(String text)   //通过html某个标签中间的text找到元素,并点击它
```

```
OperateElement.clickByCss(String css)   //通过元素的Xpath，等待元素的出现,并点击它
```

```
OperateElement.clickByAttribute(String attribute,String value)  //通过元素的某个特定属性，等待元素的出现,并点击它
```

```
OperateElement.clickByJSBy(By by)   //用javaScript执行点击事件
```

```
OperateElement.isElementExsitBy(By locator)   //判断元素是否存在
```

```
OperateElement.sendKeysByXpath(String xpath,String keys)  //通过元素的Xpath，等待文本框的出现,并输入
```

```
OperateElement.dragAndDropBy(WebElement element,int xOffset,int yOffset)  //拖动元素
```

```
OperateElement.mouthHover(WebElement ele,int ms)   //鼠标悬停
```
- 浏览器操作

```
OperateElement.switchToWindowByIndex(int index)   //通过窗口的索引来切换窗口,index从0开始
```

```
OperateElement.closeWindowHandleNotFirst()   //关闭除了第一个窗口外的其它窗口
```

```
OperateElement.acceptAlert()  //接收alert
```

```
OperateElement.switchToFrameById(String id)   //通过frame的ID切换iframe
```
- 其它

```
OperateElement.threadSleep(int timeout)   //线程等待,单位：毫秒
```

# 安装使用
- 安装jdk1.8
- 安装maven，我的版本是3.3.9
- 安装IDEA
- clone项目到本地，然后用IDEA打开
- 安装Jenkins
- Jenkins添加Allure插件，可参考：https://blog.csdn.net/galen2016/article/details/88015322
- Jenkins新增一个job并配置
- 构建项目
- 查看Allure报告
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190613195405112.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2dhbGVuMjAxNg==,size_16,color_FFFFFF,t_70)
# 调用原理
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190613200207597.png)
# 项目结构介绍
### 主目录：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190613181953252.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2dhbGVuMjAxNg==,size_16,color_FFFFFF,t_70)
### libs文件夹
存放外部jar包，如jdbc的jar不能通过maven下载，就可以直接下下来放到这里，然后在pom.xml里引用
### resource文件夹
存放一些资源文件，如测试用例.excel文件
### cases包
测试用例文件
### common包
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190613190126454.png)
BaseTest.java  测试用例的基类，其他测试用例都继承这个类
InitDriver.java  初始webdriver，可以提供获取chrome、firefox、ie三个浏览器的方法
OperateElement.java  对webdriver的API做了二次封装
TestngListener  全局监控器，控制失败用例重跑、截图、打印测试步骤

### pageobject包
对每个测试页面的元素和公共操作封装成一个类

### utils包
封装一些实用的工具类，如：读取excel、xml、配置文件，获取随机身份证号码、地址等

### env.properties
测试要用到的url、账号密码等可以写在这个文件里面
### pom.xml
1、管理jar包   2、配置maven-surefire-plugin插件来运行test包下面的代码
