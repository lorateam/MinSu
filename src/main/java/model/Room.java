package model;

public class Room extends BaseModel{
    private long id;
    private long hotel;
    private String status;
    private double price;
    private String description;
    private String parking_set;
    private String wifi;
    private String room_type;

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getHotel() {
        return hotel;
    }

    public void setHotel(long hotel) {
        this.hotel = hotel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParking_set() {
        return parking_set;
    }

    public void setParking_set(String parking_set) {
        this.parking_set = parking_set;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }
}
