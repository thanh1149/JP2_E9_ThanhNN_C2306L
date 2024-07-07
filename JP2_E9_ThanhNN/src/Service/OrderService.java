package Service;

import Entity.Order;
import Entity.OrderDetail;
import Entity.Product;

public abstract class OrderService {
    private Order order;
    private Product product;
    private OrderDetail orderDetail;

    protected OrderService(Order order,Product product,OrderDetail orderDetail){
        this.order = order;
        this.product = product;
        this.orderDetail = orderDetail;
    }

    public abstract Order addOrder();

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
