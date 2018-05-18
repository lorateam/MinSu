package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

/**
 * 链接数据库的工具类
 */
public class DBUtil
{
    static String ip="tx.3cat.top";
    static int port=3306;
    static String database="minsu";
    static String encoding="UTF-8";
    static String loginName="root";
    static String password="123";

    static
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public static Connection getConnection()
    {
        String url=String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s",ip,port,database,encoding);
        try{
            return DriverManager.getConnection(url,loginName,password);
        }catch(SQLException e){
            e.getStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws SQLException
    {
        System.out.println(getConnection());
    }
}
