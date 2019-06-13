package test.java.utils;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 * Author: 灵枢
 * Date: 2019/1/16
 * Time: 16:39
 * Description:获取excel.xls的数据
 */
public class ExcelXlsData {

    private  HSSFSheet sheetAt;

    public ExcelXlsData(String filePath){
        FileInputStream is = null;
        try {
            is = new FileInputStream(filePath);
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
            sheetAt = hssfWorkbook.getSheetAt(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取excel的全部数据
     * @param filePath
     */
    public void readXlsData(String filePath){
        try {
            int rows = sheetAt.getPhysicalNumberOfRows();
            for (int i=0;i<rows;i++){
                HSSFRow row = sheetAt.getRow(i);
                int columns = row.getPhysicalNumberOfCells();
                for(int j=0;j<columns;j++){
                    String cell = row.getCell(j).toString();
                    System.out.println(cell);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据行列返回某个单元格的数据
     * @param row
     * @param column
     * @return
     */
    public String getExcelCell(int row,int column){
        HSSFRow row1 = sheetAt.getRow(row);
        String cell = row1.getCell(column).toString();
        return cell;
    }

    /**
     * 获取某一列的数据，除了第一行
     * @param columnIndex
     * @return
     */
    public ArrayList<String> getCellList(int columnIndex){
        ArrayList<String> list = new ArrayList<>();
        int rows = sheetAt.getPhysicalNumberOfRows();
        for(int i=1;i<rows;i++){
            HSSFRow row = sheetAt.getRow(i);
            String cell = row.getCell(columnIndex).toString();
            list.add(cell);
        }
        return list;
    }

    /**
     * 根据某一单元格的值，来获取这个单元格同一行的某一列的值
     * @param keyWords  某一单元格的值
     * @param currentColumn 该单元格所以的列
     * @param targetColumn 目标单元格所在的列
     * @return
     */
    public String getCellByKeyWords(String keyWords,int currentColumn,int targetColumn){
        String targetCell = "";
        int rows = sheetAt.getPhysicalNumberOfRows();
        for(int i=0;i<rows;i++){
            HSSFRow row = sheetAt.getRow(i);
            String currentCell = row.getCell(currentColumn).toString();
            if(currentCell.equals(keyWords)){
                targetCell = row.getCell(targetColumn).toString();
                break;
            }
        }
        return targetCell;
    }


}
