package test.java.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Author: 灵枢
 * Date: 2018/12/25
 * Time: 17:40
 * Description:
 */
public class Retry implements IRetryAnalyzer {
    private int retryCount = 0;
    private int maxRetryCount = 1;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(retryCount<maxRetryCount){
            retryCount++;
            return true;
        }
        return false;
    }
}
