package test.java.utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.text.DecimalFormat;


/**
 * Author: 灵枢
 * Date: 2018/12/05
 * Time: 17:21
 * Description:读取Excel.xlsx数据
 */
public class ExcelData {

	private XSSFSheet sheet;

	/**
	 * 构造函数，初始化excel数据
	 * @param filePath  excel路径
	 * @param sheetName sheet表名
	 */
	public ExcelData(String filePath,String sheetName){
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(filePath);
			XSSFWorkbook sheets = new XSSFWorkbook(fileInputStream);
			//获取sheet
			sheet = sheets.getSheet(sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * 根据行和列的索引获取单元格的数据
	 * @param row
	 * @param column
	 * @return
	 */
	public String getExcelDateByIndex(int row,int column){
		XSSFRow row1 = sheet.getRow(row);
		String cell = row1.getCell(column).toString();
		return cell;
	}


	/**
	 * 根据某一列值为“******”的这一行，来获取该行第x列的值
	 * @param caseName
	 * @param currentColumn 当前单元格列的索引
	 * @param targetColumn 目标单元格列的索引
	 * @return
	 */
	public String getCellByCaseName(String caseName,int currentColumn,int targetColumn){
		String operateSteps="";
			//获取行数
			int rows = sheet.getPhysicalNumberOfRows();
			for(int i=0;i<rows;i++){
				XSSFRow row = sheet.getRow(i);
				String cell = row.getCell(currentColumn).toString().trim();
				if(cell.equals(caseName)){
					operateSteps = row.getCell(targetColumn).toString();
					break;
				}
			}
		return operateSteps;
	}

	/**
	 * 根据某一列值为“******”的这一行，当第x列的值是长数字时，来获取该行第x列的值
	 * @param caseName
	 * @param currentColumn 当前单元格列的索引
	 * @param targetColumn 目标单元格列的索引
	 * @return  返回int类型
	 */
	public String getIntCellByCaseName(String caseName,int currentColumn,int targetColumn){
		String operateSteps="";
		DecimalFormat df = new DecimalFormat("0");
		//获取行数
		int rows = sheet.getPhysicalNumberOfRows();
		for(int i=0;i<rows;i++){
			XSSFRow row = sheet.getRow(i);
			String cell = row.getCell(currentColumn).toString().trim();
			if(cell.equals(caseName)){
				//获取double类型的值，不然是科学计数法
				double targetCell = row.getCell(targetColumn).getNumericCellValue();
				//再转换成string
				operateSteps = df.format(targetCell);
				break;
			}
		}
		return operateSteps;
	}

	//打印excel数据
	public void readExcelData(){
		//获取行数
		int rows = sheet.getPhysicalNumberOfRows();
		for(int i=0;i<rows;i++){
			//获取列数
			XSSFRow row = sheet.getRow(i);
			int columns = row.getPhysicalNumberOfCells();
			for(int j=0;j<columns;j++){
				String cell = row.getCell(j).toString();
				System.out.println(cell);
			}
		}

	}

}


