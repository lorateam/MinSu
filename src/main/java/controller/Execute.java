package controller;

import dao.OrderDao;
import model.Order;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class Execute {
    private OrderDao orderDao = new OrderDao();
    private JSONObject m_json = new JSONObject();
    JSONObject execute(String action, HttpServletRequest request) throws Exception{
        if(action.equals("getOrder")){
            //{action : "getOrder", column : "id", value : "576"}
            Order order = orderDao.getOrder((String)request.getAttribute("column"), (String)request.getAttribute("value"));
            return order.toJSON();
        }else if(action.equals("addOrder")){
            Order order = new Order();
            order.setSeller((int)request.getAttribute("seller"));
            order.setCustomer((int)request.getAttribute("customer"));
            order.setMoney((int)request.getAttribute("money"));
            orderDao.InsertOrder(order);
            m_json.append("status", "success");
            return m_json;
        }else if(action.equals("updateOrder")){

        }
        return null;
    }
}
