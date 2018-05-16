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
                //{action : "getOrder", column : "id", value : "576"}
                Iterator iter = data.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry entry = (Map.Entry) iter.next();
                    Object key = entry.getKey();
                    Object val = entry.getValue();
                    System.out.println((String)key + (String)val);
                }
                Order order = orderDao.getOrder((String)data.get("column"), (String)data.get("value"));
                return order.toJSON();
            }else if(action.equals("addOrder")){
                Order order = new Order();
                order.setSeller((int)data.get("seller"));
                order.setCustomer((int)data.get("customer"));
                order.setMoney((int)data.get("money"));
                orderDao.InsertOrder(order);
                m_json.append("status", "success");
                return m_json;
            }else if(action.equals("updateOrder")){
                orderDao.updateOrder((String)data.get("arrive_date"), (String)data.get("leave_time"),(double)data.get("money"));
                m_json.append("status", "success");
                return m_json;
            }else if(action.equals("deleteOrder")){
                orderDao.deleteOrder((long)data.get("id"));
            }
        }catch (Exception e){
            e.printStackTrace();
            m_json.append("status","error_acton");
            return m_json;
        }

        return null;
    }
}
