package model;

public class order {
    private int seller;
    private int customer;
    private float money;
    String time;//订单创建时间
    String status_pay;//订单状态
    String status_handle;//卖家是否有处理此订单

    public int getSeller() {
        return seller;
    }

    public void setSeller(int seller) {
        this.seller = seller;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
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
