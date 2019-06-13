package test.java.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Author: 灵枢
 * Date: 2018/11/15
 * Time: 14:44
 * Description:获取时间
 */
public class TimeUtil {

    /**
     * 获取当前时间的月日时分
     * @return
     */
    public static String getDate(String dateFormat){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        return format.format(date);
    }

    /**
     * 获取三年后的今天
     * @return
     */
    public static String getTheDayAfter3Years(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR,3);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String time = dateFormat.format(calendar.getTime());
        return time;
    }
    public static void main(String[] args) {
        /*Date date = new Date();
        SimpleDateFormat dateFormat_min=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");//设置当前时间的格式，为年-月-日 时-分-秒
        System.out.println(dateFormat_min.format(date));*/
        System.out.println(getTheDayAfter3Years());
    }
}
