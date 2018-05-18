package dao;
import java.sql.Connection;
import util.DBUtil;
import java.sql.*;
import model.Order;

public class OrderDao{
    private Statement s = DBUtil.getStatement();

    public OrderDao() throws Exception {
    }

    public void InsertOrder(Order order) throws Exception{
        
        String sql = String.format("INSERT INTO `order`(seller, customer, money, arrive_date, leave_date)  values(%d,%d,%f,'%s','%s');",
                order.getSeller(),order.getCustomer(),order.getMoney(),order.getArrive_date(),order.getLeave_date());
        System.out.println(sql);
        s.execute(sql);
    }

    public Order getOrder(String column, String value) throws Exception{
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
        
        s.execute(sql);
    }

    public void deleteOrder(long id) throws Exception {
        String sql = String.format("delete from order where id = %d", id);
        s.execute(sql);
    }
}
