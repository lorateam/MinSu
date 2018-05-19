
package dao;

import java.sql.Connection;

import com.alibaba.fastjson.JSONObject;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Order;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class OrderDao {
    private Statement s = DBUtil.getStatement();

    public void InsertOrder(Order order) throws Exception {

        String sql = String.format("INSERT INTO `order`(seller, customer, money, arrive_date, leave_date)  values(%d,%d,%f,'%s','%s');",
                order.getSeller(), order.getCustomer(), order.getMoney(), order.getArrive_date(), order.getLeave_date());
        System.out.println(sql);
        s.execute(sql);
    }

    public List<JSONObject> getOrder(String arrive_date, String leave_date, String customer, String status_pay, String id) throws Exception {
        String sql;
        if (leave_date != "") {

            sql = String.format("select * from `order` where " +
                            "arrive_date > '%s%%' and " +
                            "leave_date < '%s%%' and " +
                            "customer like '%s%%' and " +
                            "status_pay like '%s%%' and " +
                            "id like '%s%%'",
                    arrive_date, leave_date, customer, status_pay, id);
        } else {
            sql = String.format("select * from `order` where " +
                            "arrive_date > '%s%%' and " +
                            "customer like '%s%%' and " +
                            "status_pay like '%s%%' and " +
                            "id like '%s%%'",
                    arrive_date, customer, status_pay, id);
        }
        List<JSONObject> jsons = new ArrayList();
        Order order = new Order();
        log.println(sql);
        ResultSet rs = s.executeQuery(sql);
        getJsonList(jsons, order, rs);
        return jsons;
    }

    private void getJsonList(List<JSONObject> jsons, Order order, ResultSet rs) throws SQLException {
        while (rs.next()) {
            order = DBUtil.parseResultSet(rs, order);
            try {
                jsons.add(order.toJSON());
            } catch (Exception e) {
                System.out.println("Orderdao:65");
            }
        }
    }

    public void updateOrder(String arrive_date, String leave_date, String customer, String status_pay, String id) throws Exception {
        String sql = String.format("update `order` set arrive_date='%s', leave_date='%s', customer=%s, status_pay='%s' where id = %s", arrive_date, leave_date, customer, status_pay, id);
        System.out.println(sql);
        s.execute(sql);
    }

    public void deleteOrder(long id) throws Exception {
        String sql = String.format("delete from `order` where id = %d", id);
        s.execute(sql);
    }

    public List<JSONObject> listOrder() throws Exception {
        List<JSONObject> jsons = new ArrayList();
        Order order = new Order();
        String sql = "SELECT * FROM `order` ";
        ResultSet rs = s.executeQuery(sql);
        getJsonList(jsons, order, rs);
        return jsons;
    }
}
