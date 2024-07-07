package Entity;

import java.time.LocalDateTime;

public class Order {
    private String id;
    private int cus_id;
    private LocalDateTime dateTime;

    public Order(){}
    public Order(String id, int cus_id, LocalDateTime dateTime) {
        this.id = id;
        this.cus_id = cus_id;
        this.dateTime = dateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCus_id() {
        return cus_id;
    }

    public void setCus_id(int cus_id) {
        this.cus_id = cus_id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", custome_idr=" + cus_id +
                ", dateTime=" + dateTime +
                '}';
    }
}
