package controller;

import dao.OrderDao;
import model.Order;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class Execute {
    private OrderDao orderDao = new OrderDao();
    JSONObject execute(String action, HttpServletRequest request) throws Exception{
        //{action : "getOrder", column : "id", value : "576"}
        if(action.equals("getOrder")){
            Order order = orderDao.getOrder((String)request.getAttribute("column"), (String)request.getAttribute("value"));
            return order.toJSON();
        }else if(action.equals("...")){
            //......
        }
        return null;
    }
}
