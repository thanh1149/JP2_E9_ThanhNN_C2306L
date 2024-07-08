package Service;

import DAO.OrderDAO;
import Entity.Order;
import Entity.OrderDetail;
import Entity.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderThread extends OrderService implements Runnable{
    private List<Order> orders;
    private OrderDAO orderDAO;

    public OrderThread(Order order, Product product, OrderDetail orderDetail,OrderDAO orderDAO){
        super(order,product,orderDetail);
        this.orders = new ArrayList<>();
        this.orderDAO = orderDAO;
    }

    @Override
    public Order addOrder() {
        if(super.getProduct().getQuantity() - super.getOrderDetail().getQuantity() > 0) {
            orders.add(super.getOrder());
            orderDAO.add(super.getOrder());
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
