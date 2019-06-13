package test.java.common;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.testng.AssertJUnit.assertTrue;

/*
 *作者:灵枢
 *时间:2018-11-22  下午4:45:15
 *描述:封装元素的基本操作：等待、点击、输入
 **/


public class OperateElement {
	private static int timeOutInSeconds = 10;
	public static WebDriver driver;

	/**
	 * 通过元素的Xpath，等待元素的出现,返回此元素
	 * @return 返回等待的元素
	 */
	public static WebElement waitByXpath(String xpath){
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		//presenceOfElementLocated:显示等待元素在页面中存在,不用等页面全部加载完
		WebElement targetElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		return targetElement;
	}
	
	/**
	 * 通过元素的name，等待元素的出现,返回此元素
	 * @param name 元素的name
	 * @return 返回等待的元素
	 */
	public static WebElement waitByName(String name){
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement	targetElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(name)));
		return targetElement;
	}
	
	/**
	 * 通过元素的id，等待元素的出现,返回此元素
	 * @param id 元素的id
	 * @return 返回等待的元素
	 */
	public static WebElement waitById(String id){
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement	targetElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
		return targetElement;
	}
	
	/**
	 * 通过元素的linkText，等待元素的出现,返回此元素
	 * @param linkText 元素的linkText
	 * @return 返回等待的元素
	 */
	public static WebElement waitByLinkText(String linkText){
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement targetElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(linkText)));
		return targetElement;
	}
	
	/**
	 * 通过元素的className，等待元素的出现,返回此元素
	 * @param className 元素的className
	 * @return 返回等待的元素
	 */
	public static WebElement waitByClassName(String className){
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement targetElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.className(className)));
		return targetElement;
	}
	
	/**
	 * 通过元素的Css，等待元素的出现,返回此元素
	 * @return 返回等待的元素
	 */
	public static WebElement waitByCss(String css){
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement targetElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css)));
		return targetElement;
	}

	/**
	 * 通过元素的某个属性，等待元素的出现,返回此元素
	 * @param attribute 属性名
	 * @param value 属性值
	 * @return
	 */
	public static WebElement waitByAttribute(String attribute,String value){
		String xpath = "//*[@"+attribute+"='"+value+"']";
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement targetElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		return targetElement;
	}

	/**
	 * 通过元素的className，等待元素列表的出现,返回此元素列表
	 * @param className 元素的className
	 * @return 返回等待的元素
	 */
	public static List<WebElement> waitElesByClassName(String className){
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		List<WebElement> targetElementList  = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By.className(className))));
		return targetElementList;
	}
	
	/**
	 * 通过元素的linktext，等待元素列表的出现,返回此元素列表
	 * @param linkText 元素的linktext
	 * @return 返回等待的元素
	 */
	public static List<WebElement> waitElesByLinkText(String linkText){
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		List<WebElement> targetElementList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By.linkText(linkText))));
		return targetElementList ;
	}

	/**
	 * 通过元素的xpath，等待元素列表的出现,返回此元素列表
	 * @param xpath
	 * @return
	 */
	public static List<WebElement> waitElesByXpath(String xpath){
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		List<WebElement> targetElementList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By.xpath(xpath))));
		return targetElementList ;
	}
	
	/**
	 * 通过元素的linkText，等待元素的出现,并点击它
	 * @param linkText
	 */
	public static void clickByLinkText(String linkText){
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement targetElement = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(linkText)));
		targetElement.click();
	}
	
	/**
	 * 通过元素的Xpath，等待元素的出现,并点击它
	 * @param xpath
	 */
	public static void clickByXpath(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement targetElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		targetElement.click();
	}
	
	/**
	 * 通过元素的Xpath，等待元素的出现,并点击它
	 * @param css
	 */
	public static void clickByCss(String css){
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement targetElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(css)));
		targetElement.click();
	}
	
	
	/**
	 * 通过元素的ID，等待元素的出现,并点击它
	 * @param Id
	 */
	public static void clickById(String Id){
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement targetElement = wait.until(ExpectedConditions.elementToBeClickable(By.id(Id)));
		targetElement.click();
	}
	
	/**
	 * 通过元素的ClassName，等待元素的出现,并点击它
	 * @param className
	 */
	public static void clickByClassName(String className) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement targetElement = wait.until(ExpectedConditions.elementToBeClickable(By.className(className)));
		targetElement.click();
	}
	
	/**
	 * 通过元素的Name，等待元素的出现,并点击它
	 * @param name
	 */
	public static void clickByName(String name) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement targetElement = wait.until(ExpectedConditions.elementToBeClickable(By.name(name)));
		targetElement.click();
	}

	/**
	 * 通过元素的某个特定属性，等待元素的出现,并点击它
	 * @param attribute
	 * @param value
	 * @return
	 */
	public static void clickByAttribute(String attribute,String value){
		String xpath = "//*[@"+attribute+"='"+value+"']";
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement targetElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		targetElement.click();
	}

	/**
	 * 通过元素的Xpath，等待文本框的出现,并输入
	 */
	public static void sendKeysByXpath(String xpath,String keys) {
		WebElement targetElement = waitByXpath(xpath);
		targetElement.clear();
		targetElement.sendKeys(keys);
	}

	/**
	 * 指定元素，再输入
	 * @param element
	 * @param keys
	 */
	public static void sendKeysByEle(WebElement element,String keys){
		element.clear();
		element.sendKeys(keys);
	}

	/**
	 * 通过元素的ID，等待文本框的出现,并输入
	 */
	public static void sendKeysById(String Id,String keys) {
		WebElement targetElement = waitById(Id);
		targetElement.clear();
		targetElement.sendKeys(keys);
	}

	/**
	 * 通过元素的name，等待文本框的出现,并输入
	 */
	public static void sendKeysByName(String name,String keys) {
		WebElement targetElement = waitByName(name);
		targetElement.clear();
		targetElement.sendKeys(keys);
	}

	/**
	 * 通过元素的ClassName，等待文本框的出现,并输入
	 */
	public static void sendKeysByClassName(String className,String keys) {
		WebElement targetElement = waitByClassName(className);
		targetElement.clear();
		targetElement.sendKeys(keys);
	}

	/**
	 * 通过元素的Name，等待文本框的出现,并输入
	 */
	public static void SendKeysByName(String name,String keys){
		WebElement targetElement = waitByName(name);
		targetElement.clear();
		targetElement.sendKeys(keys);
	}


	/**
	 * 等待元素可见
	 * @param ele
	 * @param waitTime
	 */
	public static void waitEleVisible(WebElement ele,int waitTime){
		WebDriverWait wait = new WebDriverWait(driver,waitTime);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	/**
	 * 等待元素可点击
	 * @param ele
	 * @param waitTime
	 */
	public static void waitEleCanClickable(WebElement ele,int waitTime){
		WebDriverWait wait = new WebDriverWait(driver,waitTime);
		wait.until(ExpectedConditions.visibilityOf(ele));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	/**
	 * 拖动元素
	 * @param element 元素
	 * @param xOffset 拖到目标的横坐标位置，xOffset为正数时向右移动，为负数时向左移动
	 * @param yOffset 拖到目标的纵坐标位置
	 */
	public static void dragAndDropBy(WebElement element,int xOffset,int yOffset){
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(element,xOffset,yOffset).build().perform();
	}

	/**
	 * 拖动滚动条到目标元素的位置
	 */
	public static void scrollIntoView(WebElement target){
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",target);
	}

	/**
	 * 通过点击一个元素来切换窗口
	 * @param element 被点击的元素
	 */
	public static void switchToWindowByClick(WebElement element){
		String currentWindow = driver.getWindowHandle();
		element.click();
		threadSleep(1000);
		Set<String> windowHandles = driver.getWindowHandles();
		//切换窗口
		for (String windowHandle:windowHandles){
			if(!windowHandle.equals(currentWindow)){
				driver.switchTo().window(windowHandle);
			}
		}
	}

	/**
	 * 通过窗口的索引来切换窗口
	 * @param index
	 */
	public static void switchToWindowByIndex(int index){
		try {
			List<String> windowHandles = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window((String)windowHandles.get(index));
		} catch (IndexOutOfBoundsException var3) {
			var3.printStackTrace();
		}
	}

	/**
	 * 通过窗口名称来切换窗口
	 * @param windowTitleName 窗口名称
	 */
	public static void switchToWindowHandle(String windowTitleName){
		Set<String> handles = driver.getWindowHandles();
		List<String> it = new ArrayList<String>(handles);
		Iterator<String> iterator = handles.iterator();
		String currentHandle=null;
		try{
			currentHandle=driver.getWindowHandle();
		}
		catch(NoSuchWindowException e){
			driver.switchTo().window(it.get(0));
		}
		while (iterator.hasNext()) {
			String h = (String) iterator.next();
			String currentTitle=driver.getTitle();
			if (currentTitle.contains(windowTitleName)){
				break;
			}
			if (h != currentHandle) {
				if (driver.switchTo().window(h).getTitle().contains(windowTitleName)) {
					driver.switchTo().window(h);
					System.out.println("switch to "+driver.getTitle()+" news page successfully");
					break;
				}
			}
		}
	}

	/**
	 * 关闭除了第一个窗口外的其它窗口
	 */
	public static void closeWindowHandleNotFirst(){
		Set<String> windowHandles = driver.getWindowHandles();
		if (windowHandles.size()>1){
			for (int i=windowHandles.size()-1;i>0;i--){
				driver.close();
				switchToWindowByIndex(i-1);
                //System.out.println("切到window"+(i-1));
			}
		}
	}

	/**
	 * 通过frame的ID切换iframe
	 * @param
	 * @author 灵枢
	 */
	public static void switchToFrameById(String id){
		WebElement frame = driver.findElement(By.id(id));
		driver.switchTo().frame(frame);
	}

	/**
	 * 切换iframe
	 * @param
	 * @author 灵枢
	 */
	public static void switchToFrameByEle(WebElement iframe){
		driver.switchTo().frame(iframe);
	}

	/**
	 * 接收alert
	 * @param
	 * @author 灵枢
	 */
	public static void acceptAlert(){
		try {
			Alert alert = driver.switchTo().alert(); //接收alert
			alert.accept();
		} catch (Exception e) {
		}
	}

	/**
	 * 等待alert出现
	 * @param alertName
	 * @return
	 */
	public static Alert waitForAlert(String alertName){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Alert targetAlert = null;
		try{
			targetAlert = wait.until(ExpectedConditions.alertIsPresent());
		}catch(Exception e){
			assertTrue("没有找到目标元素--"+alertName,false);
		}
		return targetAlert;
	}

	/**
	 * 用javaScript执行点击事件
	 * @param
	 * @author guilin_cui
	 */
	public static void clickByJS(WebElement ele){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ele);
	}

	/**
	 * 用javaScript执行点击事件
	 * @param by 传入定位
	 */
	public static void clickByJSBy(By by){
		WebElement ele = driver.findElement(by);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ele);
	}

	/**
	 * 用javaScript输入
	 * @param
	 * @author guilin_cui
	 */
	public static void sendKesyByJS(WebElement ele,String keys){
		String str = "arguments[0].value='"+keys+"';";
		ele.clear();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript(str, ele);
	}


	/**
	 * 打开新的窗口，并切换到该窗口
	 * @param url 新窗口的url
	 * @param windwoName  窗口title
	 */
	public static void openWindow(String url,String windwoName){
		String js = "window.open(\""+url+"\")";
		((JavascriptExecutor)driver).executeScript(js);
		switchToWindowHandle(windwoName);
	}

	/**
	 * 鼠标悬停
	 * @param ele 元素
	 * @param ms 悬停时间(毫秒)
	 */
	public static void mouthHover(WebElement ele,int ms){
		Actions actions = new Actions(driver);
		actions.moveToElement(ele).perform();
		threadSleep(ms);
	}

	/**
	 *鼠标点击并悬停
	 */
	public static void clickAndHold(WebElement ele){
		Actions actions = new Actions(driver);
		actions.clickAndHold(ele).perform();
	}

	/**
	 *双击
	 */
	public static void doubleClick(WebElement ele){
		Actions builder = new Actions(driver);
		Actions hoverOverRgeistrar = builder.doubleClick(ele);
		hoverOverRgeistrar.perform();
	}


	/**
	 * 线程等待
	 * @param timeout 单位：毫秒
	 */
	public static void threadSleep(int timeout){
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 判断元素是否存在
	 * @param ele 等待的元素
	 * @return boolean 是否存在
	 */
	public static boolean isElementExsit(WebElement ele) {
		boolean flag ;
		try {
			WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
			WebElement element = wait.until(ExpectedConditions.visibilityOf(ele));
			flag = element.isDisplayed();
		} catch (Exception e) {
			flag = false;
			System.out.println("Element:" + ele.toString()
					+ " is not exsit!");
		}
		return flag;
	}

	/**
	 * 判断元素是否存在
	 * @param locator 如：By.id("")
	 * @return boolean 是否存在
	 */
	public static boolean isElementExsitBy(By locator) {
		boolean flag = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			flag = true;
		} catch (NoSuchElementException e) {
			System.out.println("Element:" + locator.toString()
					+ " is not exsit!");
		}
		return flag;
	}

	/**
	 * 打开url，一直等到页面的readyState为“complete",注意readyState=complete时并不意味着url全部加载完毕，只是这时我们的页面元素可以操作了
	 * @param url
	 */
	public static void getUrlUntilLoadComplete(String url){
		driver.get(url);
		for(int i=0;i<10;i++){
			if(((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete")){
				break;
			}
			threadSleep(1000);
//			System.out.println("readyState:"+((JavascriptExecutor)driver).executeScript("return document.readyState"));
			//如果等了10秒还没有加载完，停止加载，往后执行代码
			if(i==9){
				((JavascriptExecutor)driver).executeScript("window.stop();");
			}
		}
	}
}

