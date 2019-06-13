package test.java.utils;

import org.openqa.selenium.WebDriver;
import test.java.common.OperateElement;

import java.io.IOException;

/**
 * Author: 灵枢
 * Date: 2019/1/16
 * Time: 13:58
 * Description:AutoIT方法封装
 */
public class AutoITUtil {
    /**
     * 使用AutoIT上传图片
     * @param fileName  文件名
     * @param driver
     */
    public static void uploadPic(String fileName,WebDriver driver){
        String path = "resource/"+fileName;
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        OperateElement.threadSleep(1500);
    }
}
