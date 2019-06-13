package test.java.utils;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

/**
 * Author: 灵枢
 * Date: 2018/11/14
 * Time: 16:07
 * Description: Sikuli：可以根据图片来定位，然后执行操作
 */
public class SikuliUtil {
    public static Pattern pattern = null;
    public static Pattern pattern2 = null;
    public static Screen screen = null;

    /**
     * 实现单击操作
     * @param iconPath 图片路径
     */
    public static void click(String iconPath){
        if(isExist(iconPath)==false){
            System.err.println("找不到图片:" + iconPath);
        }
        pattern = new Pattern(iconPath);
        screen = new Screen();
        try {
            screen.click(pattern);
        } catch (FindFailed e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        clear();
    }

    /**
     * 双击操作
     * @param iconPath 图片路径
     * @return
     */
    public static void doubleClick(String iconPath){
        if(isExist(iconPath)==false){
            System.err.println("找不到图片:" + iconPath);
        }
        pattern = new Pattern(iconPath);
        screen = new Screen();
        try {
            screen.doubleClick(pattern);
        } catch (FindFailed e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        clear();
    }

    /**
     * 只能输入英文，输入中文会调出输入法,输入中文用u''试试,不行就用粘贴
     * @param iconPath
     * @param text
     */
    public static void typeText(String iconPath,String text){
        if(isExist(iconPath)==false){
            System.err.println("找不到图片:" + iconPath);
        }
        pattern = new Pattern(iconPath);
        screen = new Screen();
        screen.type(iconPath,text);
        /*try {
            screen.type(pattern,text);

        } catch (FindFailed e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }*/
        clear();
    }

    /**
     * 粘贴文本
     * @param picPath
     * @param text
     */
    public static void pasteText(String picPath,String text){
        Screen screen = new Screen();
        try {
            screen.paste(picPath,text);
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
        screen = null;
    }

    /**
     * 拖拽功能，拖动路径是icon1到icon2
     * @param icon1Path
     * @param icon2Path
     */
    public static void dragDrop(String icon1Path,String icon2Path){
        if(isExist(icon1Path)&&isExist(icon2Path)){
            pattern = new Pattern(icon1Path);
            pattern2 = new Pattern(icon2Path);
            screen = new Screen();
            try {
                screen.dragDrop(pattern,pattern2);
            } catch (FindFailed e) {
                e.printStackTrace();
                System.err.println(e.getMessage());
            }
            clear();
        }
    }

    /**
     * 验证图片是否存在
     * @param iconPath
     */
    public static boolean isExist(String iconPath){
        boolean exist;
        pattern = new Pattern(iconPath);
        screen = new Screen();
        try {
            screen.find(pattern);
            exist = true;
        } catch (FindFailed e) {
            e.printStackTrace();
            exist = false;
        }
        clear();
        return exist;
    }

    /**
     * 关闭弹窗
     */
    public static void closePrompt(){
        Screen.closePrompt();
    }

    /**
     * 清空变量值
     */
    public static void clear(){
        if(pattern != null){
            pattern = null;
        }

        if(pattern2 != null){
            pattern2 = null;
        }

        if(screen != null){
            screen = null;
        }
    }

}
