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
        if(action == null || action.equals("")){
            return null;
        }else if(action.equals("getOrder")){
            Order order = orderDao.getOrder((String)request.getAttribute("column"), (String)request.getAttribute("value"));
            Map map = new HashMap();
            map.put(order.toJSON());
        }
    }
}
