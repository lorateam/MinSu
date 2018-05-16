package dao;
import java.sql.Connection;
import util.DBUtil;
import java.sql.*;
import model.Order;

public class OrderDao{
    private Connection c = DBUtil.getConnection();
    public void InsertOrder(Order order) throws Exception{
        Statement s = c.createStatement();
        String sql = String.format("insert into order(seller, customer, money) value",
                order.getSeller(),order.getCustomer(),order.getMoney());
        s.execute(sql);
    }


}
