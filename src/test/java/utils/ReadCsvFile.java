package test.java.utils;

import com.csvreader.CsvReader;

import java.nio.charset.Charset;
import java.util.ArrayList;

/*
 *作者:Adien_cui
 *时间:2017-9-25  下午4:36:29
 *描述:读取csv文件
 **/
public class ReadCsvFile {
	private static ArrayList<String[]> csvList;
	
	/**
	 * 读取csv文件，并存入list集合
	 * @param filePath
	 */
	public static void readCsvFile(String filePath){
		try {
			csvList = new ArrayList<String[]>(); 
//			CsvReader reader = new CsvReader(filePath,',',Charset.forName("SJIS"));
			CsvReader reader = new CsvReader(filePath,',',Charset.forName("GBK"));
//			reader.readHeaders(); //跳过表头,不跳可以注释掉
			
			while(reader.readRecord()){
				csvList.add(reader.getValues()); //按行读取，并把每一行的数据添加到list集合
			}
			reader.close();
//			System.out.println("读取的行数："+csvList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 读取测试用例的描述
	 * @param filePath  csv文件路径
	 * @param caseName  用例名
	 * @return
	 */
	public static String getCaseDescription(String filePath,String caseName){
		readCsvFile(filePath);
		for(int row=0;row<csvList.size();row++){
			/*System.out.println("-----------------");
			//打印每一行的数据
			System.out.print(csvList.get(row)[0]+",");
			System.out.print(csvList.get(row)[1]+",");
			System.out.print(csvList.get(row)[2]+",");
			System.out.println(csvList.get(row)[3]+",");*/
			//如果第一列（即姓名列）包含lisa，则打印出lisa的年龄
			if(csvList.get(row)[4].equals(caseName)){
				return csvList.get(row)[6];
			}
		}
		return null;
	}

	/**
	 * 读取测试用例的描述
	 * @param filePath  csv文件路径
	 * @param caseName  用例名
	 * @return
	 */
	public static String getOperateSteps(String filePath,String caseName){
		readCsvFile(filePath);
		for(int row=0;row<csvList.size();row++){
			if(csvList.get(row)[4].equals(caseName)){
				return csvList.get(row)[6];
			}
		}
		return null;
	}

	/**
	 * 读取测试用例的期望结果
	 * @param filePath  csv文件路径
	 * @param caseName  用例名
	 * @return
	 */
	public static String getExpectResult(String filePath,String caseName){
		readCsvFile(filePath);
		for(int row=0;row<csvList.size();row++){
			if(csvList.get(row)[4].equals(caseName)){
				return csvList.get(row)[7];
			}
		}
		return null;
	}

	public static void main(String[] args) {
		String filePath = "resource/M站自动化测试用例.csv";
		System.out.println("用例描述："+getCaseDescription(filePath,"test城市切换"));
	}
}
