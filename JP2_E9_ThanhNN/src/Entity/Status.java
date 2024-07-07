package Entity;

public enum Status {
    Pending("Chờ xử lý"),
    Complete("Đã hoàn thành"),
    Cancel("Hủy"),
    Paid("Đã thanh toán");

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
