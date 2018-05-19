package util;

import model.BaseModel;
import model.Order;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.List;

/**
 * 链接数据库的工具类
 */
public class DBUtil {
    static String ip = "tx.3cat.top";
    static int port = 3306;
    static String database = "minsu";
    static String encoding = "UTF-8";
    static String loginName = "root";
    static String password = "123";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        try {

            String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
            return DriverManager.getConnection(url, loginName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Statement getStatement() {
        try {

            Statement s = getConnection().createStatement();
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T parseResultSet(ResultSet rs, T object) {
        try {
            ResultSetMetaData sm = rs.getMetaData();
            int colNumber = sm.getColumnCount();

            Class clazz = Class.forName(object.getClass().getName());
            Field[] fields = clazz.getDeclaredFields();

            //取出每一个字段进行赋值
            for(int i=1;i<=colNumber;i++){
                Object value = rs.getObject(i);
                //匹配实体类中对应的属性
                for(int j = 0;j<fields.length;j++){
                    Field f = fields[j];
                    if(f.getName().equals(sm.getColumnName(i))){
                        boolean flag = f.isAccessible();
                        f.setAccessible(true);
                        f.set(object, value);
                        f.setAccessible(flag);
                        break;
                    }
                }
            }
            return object;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getConnection());
    }
}
