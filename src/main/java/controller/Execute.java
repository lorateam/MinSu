package controller;

import dao.OrderDao;
import model.Order;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Execute {
    private OrderDao orderDao = new OrderDao();
    private JSONObject m_json = new JSONObject();
    JSONObject execute(String action, Map data) throws Exception{
        try{
            if(action.equals("getOrder")){
                //查询订单{action : "getOrder", column : "id", value : "576"}
                Iterator iter = data.entrySet().iterator();

                Order order = orderDao.getOrder((String)data.get("column"), (String)data.get("value"));
                return order.toJSON();
            }else if(action.equals("addOrder")){
                ///添加订单 {action:addOrder, seller: 456, customer:123, money:555}
                Order order = new Order();
                order.setSeller(Integer.parseInt(data.get("seller").toString()));
                order.setCustomer(Integer.parseInt(data.get("customer").toString()));
                order.setMoney(Integer.parseInt(data.get("money").toString()));
                //TODO:应该添加到店时间和离店时间
                orderDao.InsertOrder(order);
                m_json.append("status", "success");
                return m_json;
            }else if(action.equals("updateOrder")){
                //修改订单 {action: updateOrder, arrive_date:2018-05-26, leave_time:2018-05-28, money:45}
                orderDao.updateOrder((String)data.get("arrive_date"), (String)data.get("leave_time"),(double)data.get("money"), (long)data.get("id"));
                m_json.append("status", "success");
                return m_json;
            }else if(action.equals("deleteOrder")){
                //删除订单{action: deleteOrder, id : 1}
                orderDao.deleteOrder((long)data.get("id"));
            }
            m_json.append("status","没有对应action");
            return m_json;
        }catch (Exception e){
            e.printStackTrace();
            m_json.append("status","执行"+ action + "失败");
            return m_json;
        }
    }
}
