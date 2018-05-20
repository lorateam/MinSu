package controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.xdevapi.JsonArray;
import dao.OrderDao;
import dao.UserDao;
import model.Order;
import model.User;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Execute {
    private OrderDao orderDao = new OrderDao();
    private JSONObject m_json = new JSONObject();

    public Execute() throws Exception {
    }

    JSONObject execute(String action, Map data) throws Exception{
        try{
            if(action.equals("selectOrder")){
                //查询订单{action : "getOrder", column : "id", value : "576"}
                List<JSONObject> orders = orderDao.getOrder(data.get("arrive_date").toString(), data.get("leave_date").toString(),data.get("customer").toString(), data.get("status_pay").toString(),data.get("id").toString());
                JSONArray jsons = (JSONArray) JSON.toJSON(orders);
                m_json.put("orders", jsons);
                return m_json;
            }else if(action.equals("addOrder")){
                ///添加订单 {action:addOrder, seller: 456, customer:123, money:555}
                Order order = new Order();
                order.setSeller(Integer.parseInt(data.get("seller").toString()));
                order.setCustomer(Integer.parseInt(data.get("customer").toString()));
                order.setMoney(BigDecimal.valueOf(Double.parseDouble(data.get("money").toString())));
                order.setArrive_date(Date.valueOf(data.get("arrive_date").toString()));
                order.setLeave_date(Date.valueOf(data.get("leave_date").toString()));
                orderDao.InsertOrder(order);
                m_json.put("status", "success");
                return m_json;
            }else if(action.equals("updateOrder")){
                //修改订单 {action: updateOrder, arrive_date:2018-05-26, leave_date:2018-05-28, money:45}
                orderDao.updateOrder(data.get("arrive_date").toString(), data.get("leave_date").toString(),data.get("customer").toString(), data.get("status_pay").toString(),data.get("id").toString());
                m_json.put("status", "success");
                return m_json;
            }else if(action.equals("deleteOrder")){
                //删除订单{action: deleteOrder, id : 1}
                orderDao.deleteOrder(Long.parseLong(data.get("id").toString()));
            }else if(action.equals("listOrder")){
                //显示所有订单
                List<JSONObject> orders = orderDao.listOrder();
                JSONArray jsons = (JSONArray) JSON.toJSON(orders);
                m_json.put("orders", jsons);
                return m_json;
            }else if(action.equals("register")){
                UserDao userDao = new UserDao();
                User user = new User();
                user.setHead_image(data.get("imgurl").toString());
                user.setAccount(data.get("account").toString());
                user.setName(data.get("name").toString());
                user.setPassword(data.get("password").toString());
                user.setEmail(data.get("email").toString());
                userDao.add(user);
                m_json.put("status","success");
            }else if(action.equals("showMyInfor")){
                User user = new User();
                UserDao userDao = new UserDao();
                user.setId(Integer.parseInt(data.get("id").toString()));
                user = userDao.get(user.getId());
                m_json.put("account", user.getAccount());
                m_json.put("name", user.getName());
                m_json.put("email", user.getEmail());
                return m_json;
            }else if(action.equals("changeMyInfor")){
                User user = new User();
                UserDao userDao = new UserDao();
                user.setId(Integer.parseInt(data.get("id").toString()));
                user.setEmail(data.get("email").toString());
                user.setPassword(data.get("password").toString());
                user.setName(data.get("name").toString());
                user.setAccount(data.get("account").toString());
                System.out.println(user);
                userDao.update(user);
                m_json.put("status","success");
                return m_json;
            }else if(action.equals("deleteUser")){
                User user = new User();
                UserDao userDao = new UserDao();
                user.setId(Integer.parseInt(data.get("idForDelete").toString()));
                userDao.delete(user.getId());
                m_json.put("status","success");
                return m_json;
            }else if(action.equals("searchUser")){
                User user = new User();
                UserDao userDao = new UserDao();
                user.setId(Integer.parseInt(data.get("idForSearch").toString()));
                user = userDao.get(user.getId());
                System.out.print("execute.java:101---"+user.getAccount());
                if(user.getAccount() == null)
                {
                    m_json.put("status","false");
                }
                else{
                    m_json.put("account", user.getAccount());
                    m_json.put("name", user.getName());
                    m_json.put("email", user.getEmail());
                    m_json.put("status","true");
                    return m_json;
                }
            }
            m_json.put("status","没有对应action");
            return m_json;
        }catch (Exception e){
            e.printStackTrace();
            m_json.put("status","执行"+ action + "失败");
            return m_json;
        }
    }
}
