package Service;

import DAO.OrderDAO;
import DAO.OrderDetailDAO;
import DAO.ProductDAO;
import Entity.Order;
import Entity.OrderDetail;
import Entity.Product;
import Entity.Status;

public class ShopService {
    private OrderDAO orderDAO;
    private OrderDetailDAO orderDetailDAO;
    private ProductDAO productDAO;

    public ShopService(){}

    public ShopService(OrderDAO orderDAO, OrderDetailDAO orderDetailDAO,ProductDAO productDAO) {
        this.orderDAO = orderDAO;
        this.orderDetailDAO = orderDetailDAO;
        this.productDAO = productDAO;
    }
    public Order checkOrderExist(String orderId) {
        return orderDAO.getById(orderId);
    }

    public OrderDetail createOrderDetail(String orderId, String productId, int quantity) {
        Order order = orderDAO.getById(orderId);
        Product product = productDAO.getById(productId);
        OrderDetail orderDetail = new OrderDetail(0, orderId, productId, quantity, Status.PENDING);
        orderDetailDAO.add(orderDetail);
        return orderDetail;
    }


}
