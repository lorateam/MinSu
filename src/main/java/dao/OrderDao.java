package dao;
import java.sql.Connection;
import util.DBUtil;
import java.sql.*;
import model.Order;

public class OrderDao{
    private Connection c = DBUtil.getConnection();

    public void InsertOrder(Order order) throws Exception{
        Statement s = c.createStatement();
        String sql = String.format("insert into order(seller, customer, money) values(%d,%d,%f)",
                order.getSeller(),order.getCustomer(),order.getMoney());
        s.execute(sql);
    }

    public Order getOrder(String column, String value) throws Exception{
        Statement s = c.createStatement();
        String sql = String.format("select * from `order` where %s=%s;",column, value);
        System.out.println(sql);
        ResultSet rs = s.executeQuery(sql);
        Order order = new Order();
        while(rs.next()){
            order.setId(rs.getLong("id"));
            order.setSeller(rs.getLong("seller"));
            order.setCustomer(rs.getInt("customer"));
            order.setMoney(rs.getDouble("money"));
            order.setTime(rs.getString("create_time"));
            order.setStatus_handle(rs.getString("status_handle"));
            order.setStatus_pay(rs.getString("status_pay"));
        }
        return order;
    }

    public void updateOrder(String arrive_date, String leave_time, double money, long id) throws Exception{
        String sql = String.format("update order set arrive_date=%s, leave_time=%s, money=%f where id = %d", arrive_date,leave_time,money, id);
        Statement s = c.createStatement();
        s.execute(sql);
    }

    public void deleteOrder(long id) throws Exception {
        String sql = String.format("delete from order where id = %d", id);
        Statement s = c.createStatement();
        s.execute(sql);
    }
}
