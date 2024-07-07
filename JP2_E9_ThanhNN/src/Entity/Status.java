package Entity;

public enum Status {
    PENDING("Chờ xử lý"),
    COMPLETE("Đã hoàn thành"),
    CANCEL("Hủy"),
    PAID("Đã thanh toán");

    private String status;
    Status(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
