package test.java.utils;

import java.io.*;
import java.util.Properties;

/**
 * Author: 灵枢
 * Date: 2019/6/12
 * Time: 15:55
 * Description: 读取properties文件
 */
public class ReadProperties {

    /**
     * 读取properties文件
     * @param fileName 文件名
     * @return 返回Properties
     */
    public static Properties readProperties(String fileName){
        Properties properties = new Properties();
        try{
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileName));
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    /**
     * 通过key读取properties文件里的value
     * @param fileName  文件名
     * @param key
     * @return 对应的value
     */
    public static String readPropertiesByKey(String fileName,String key){
        Properties properties = new Properties();
        try{
            InputStream in = new BufferedInputStream(new FileInputStream(fileName));
            BufferedReader bf = new BufferedReader(new InputStreamReader(in, "GBK"));  //解决中文乱码
            properties.load(bf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.get(key).toString();
    }

    public static void main(String[] args) {
        Properties properties2 = readProperties("env.properties");

        System.out.println(properties2.getProperty("baidu.url"));
    }
}
