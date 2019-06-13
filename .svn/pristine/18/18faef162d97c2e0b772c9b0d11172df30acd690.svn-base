package test.java.utils;

import java.io.File;

/**
 * Author: 灵枢
 * Date: 2019/1/16
 * Time: 15:50
 * Description: 文件操作
 */
public class FileOperate {

    /**
     * 读取某个目录下的全部文件名
     * @param filePath
     */
    public void getFileList(String filePath){
        File file = new File(filePath);
        File[] fileList = file.listFiles();
        for(int i=0;i<fileList.length;i++){
            if(fileList[i].isFile()){
                String name = fileList[i].getName();
                System.out.println("fileName:"+name);
            }
        }
    }

    /**
     * 根据模糊文件名找个这个文件，并返回完整文件名
     * @param filePath  文件路径
     * @param likeName  模糊文件名
     * @return
     */
    public String getCompleteFileName(String filePath,String likeName){
        String completeName="";
        File file = new File(filePath);
        File[] fileList = file.listFiles();
        for(int i=0;i<fileList.length;i++){
            if(fileList[i].isFile()){
                String name = fileList[i].getName();
                if(name.contains(likeName)){
                    completeName = name;
                    break;
                }
            }
        }
        return completeName;
    }

    /**
     * 根据模糊文件名找个这个文件，找到返回true
     * @param filePath  文件路径
     * @param likeName  模糊文件名
     * @return
     */
    public boolean isFileExist(String filePath,String likeName){
        boolean result = false;
        File file = new File(filePath);
        File[] fileList = file.listFiles();
        for(int i=0;i<fileList.length;i++){
            if(fileList[i].isFile()){
                String name = fileList[i].getName();
                if(name.contains(likeName)){
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

}
