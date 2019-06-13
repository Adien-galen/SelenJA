package test.java.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

    //设置数据库名称
    private final static String URL = "jdbc:sqlserver://*********;DatabaseName=Star-Notify";
    private static final String USER="****";
    private static final String PASSWORD="****";

    private static Connection conn=null;
    //静态代码块（将加载驱动、连接数据库放入静态块中）
    static{
        try {
            //1.加载驱动程序
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //2.获得数据库的连接
            conn=(Connection)DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //对外提供一个方法来获取数据库连接
    public  Connection getConnection(){
        return conn;
    }


    /**
     * 执行一条或多条sql，但是查询和删除不要同时进行
     * @param sqlArr
     */
    public static void executeSql(String[] sqlArr){
        DBUtil dbUtil = new DBUtil();
        try {
            Connection conn = dbUtil.getConnection();
            Statement stmt = conn.createStatement();
            for(int i=0;i<sqlArr.length;i++){
                stmt.addBatch(sqlArr[i]);
            }
            stmt.executeBatch();
            conn.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}