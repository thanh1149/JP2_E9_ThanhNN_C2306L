package Service;

import Entity.Order;
import Entity.OrderDetail;
import Entity.Product;

import java.util.List;

public abstract class OrderDetailService {
    private Order order;
    private Product product;
    private OrderDetail orderDetail;
    public List<OrderDetail> orderDetails;

    protected OrderDetailService(Order order,Product product,OrderDetail orderDetail){
        this.order = order;
        this.product = product;
        this.orderDetail = orderDetail;
    }

    public abstract OrderDetail addOrderDetail();
    public abstract List<OrderDetail> updateStatus();

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }
}
