package model;

import org.json.JSONObject;

import java.lang.reflect.Field;

public class Order {
    private long id;
    private long seller;
    private long customer;
    private double money;
    private String time;//订单创建时间
    private String arrive_date;
    private String leav_date;
    private String status_pay;//订单状态
    private String status_handle;//卖家是否有处理此订单

    public JSONObject toJSON() throws Exception{
        Class clazz = Class.forName("model.Order");
        Field[] fields = clazz.getDeclaredFields();
        JSONObject json = new JSONObject();
        for(Field f: fields){
            json.append(f.getName(),f.get(this));
        }
//        json.append("id",id);
//        json.append("seller", seller);
//        json.append("money",money);
//        json.append("time",time);
//        json.append("status_pay",status_pay);
//        json.append("status_handle",status_handle);
//        json.append("arrive_date",arrive_date);
//        json.append("status_handle",status_handle);
        return json;
    }

    public String getArrive_date() {
        return arrive_date;
    }

    public void setArrive_date(String arrive_date) {
        this.arrive_date = arrive_date;
    }

    public String getLeav_date() {
        return leav_date;
    }

    public void setLeav_date(String leav_date) {
        this.leav_date = leav_date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSeller() {
        return seller;
    }

    public void setSeller(long seller) {
        this.seller = seller;
    }

    public long getCustomer() {
        return customer;
    }

    public void setCustomer(long customer) {
        this.customer = customer;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus_pay() {
        return status_pay;
    }

    public void setStatus_pay(String status_pay) {
        this.status_pay = status_pay;
    }

    public String getStatus_handle() {
        return status_handle;
    }

    public void setStatus_handle(String status_handle) {
        this.status_handle = status_handle;
    }
}
