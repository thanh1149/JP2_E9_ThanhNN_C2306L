package Service;

import Entity.Order;
import Entity.OrderDetail;
import Entity.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderThread extends OrderService implements Runnable{
    private List<Order> orders;

    public OrderThread(Order order, Product product, OrderDetail orderDetail){
        super(order,product,orderDetail);
        this.orders = new ArrayList<>();
    }

    @Override
    public Order addOrder() {
        if(super.getProduct().getQuantity() - super.getOrderDetail().getQuantity() > 0) {
            orders.add(super.getOrder());
        }else{
            System.out.println("Not Enough Quantity");
        }
        return super.getOrder();
    }

    @Override
    public void run() {
        addOrder();
    }
}
