package model;


import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

public class Order extends BaseModel{
    private long id;
    private long seller;
    private long customer;
    private BigDecimal money;
    private Time time;//订单创建时间
    private Date arrive_date;
    private Date leav_date;
    private String status_pay;//订单状态
    private String status_handle;//卖家是否有处理此订单



    public Date getArrive_date() {
        return arrive_date;
    }

    public void setArrive_date(Date arrive_date) {
        this.arrive_date = arrive_date;
    }

    public Date getLeave_date() {
        return leav_date;
    }

    public void setLeave_date(Date leav_date) {
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

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
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
